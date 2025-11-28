package com.iafenvoy.sow.render.generator;

import com.iafenvoy.neptune.util.PerlinNoise;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.render.util.ImageRenderUtils;
import com.mojang.blaze3d.platform.NativeImage;
import it.unimi.dsi.fastutil.floats.Float2IntFunction;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MagnoriteSkinGenerator {
    private static final ResourceLocation DEFAULT = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/magnorite/magnorite_default.png");
    private static final ResourceLocation DEFAULT_MARKER = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/magnorite/magnorite_default_marker.png");
    private static final Map<Long, MagnoriteSkinGenerator> GENERATORS = new HashMap<>();
    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(0, 3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    private final long seed;
    private final ResourceLocation skinId, markerId;
    private boolean present = false, executing = false;

    private MagnoriteSkinGenerator(long seed) {
        this.seed = seed;
        this.skinId = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "magnorite_skin_" + seed);
        this.markerId = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "magnorite_marker_" + seed);
    }

    public static MagnoriteSkinGenerator getOrCreate(long seed) {
        if (!GENERATORS.containsKey(seed)) GENERATORS.put(seed, new MagnoriteSkinGenerator(seed));
        return GENERATORS.get(seed);
    }

    public static void resetAll() {
        GENERATORS.values().forEach(MagnoriteSkinGenerator::reset);
    }

    public void reset() {
        this.present = false;
    }

    public ResourceLocation getForSkin() {
        if (!this.present) {
            this.generate();
            return DEFAULT;
        }
        return this.skinId;
    }

    public ResourceLocation getForMarker() {
        if (!this.present) {
            this.generate();
            return DEFAULT_MARKER;
        }
        return this.markerId;
    }

    //FIXME::We need to swap all R and B color value in this method, I can't understand why.
    private void generate() {
        if (!this.executing) {
            this.executing = true;
            EXECUTOR.execute(() -> {
                NativeImage skin = new NativeImage(64, 64, true);
                NativeImage marker = new NativeImage(64, 64, true);
                int[][] lavaMap = generateColors(this.seed, 0.2, List.of(
                        PerlinNoise.NoiseConfig.of(8, 0.5),
                        PerlinNoise.NoiseConfig.of(5, 0.25),
                        PerlinNoise.NoiseConfig.of(3, 0.125),
                        PerlinNoise.NoiseConfig.of(1, 0.0625)
                ), h -> ImageRenderUtils.interpolateColor(0xFF0045FF, 0xFF00FFFF, h));
                ImageRenderUtils.fillWithCondition(skin, lavaMap, ImageRenderUtils::inFirstLayer);
                ImageRenderUtils.fillWithCondition(marker, lavaMap, ImageRenderUtils::inFirstLayer);

                int[][] carveColor = generateColors(this.seed + 1, 0, List.of(
                        PerlinNoise.NoiseConfig.of(1, 0.75),
                        PerlinNoise.NoiseConfig.of(0.5, 0.5),
                        PerlinNoise.NoiseConfig.of(0.25, 0.25)
                ), h -> ImageRenderUtils.interpolateColor(0xFF525F72, 0xFF12151C, h));
                int[][] carve = generateColors(this.seed + 2, -0.5, List.of(
                        PerlinNoise.NoiseConfig.of(2, 1.5),
                        PerlinNoise.NoiseConfig.of(1.5, 1.5),
                        PerlinNoise.NoiseConfig.of(0.5, 0.5)
                ), h -> h > 0 ? 0xFFFFFFFF : 0x00000000);
                int[][] firstLayer = ImageRenderUtils.create(64, 64), secondLayer = ImageRenderUtils.create(64, 64);
                ImageRenderUtils.resolveCarve(carveColor, carve, firstLayer, secondLayer);
                ImageRenderUtils.fillWithCondition(skin, firstLayer, ImageRenderUtils::inFirstLayer);
                ImageRenderUtils.fillWithCondition(skin, secondLayer, ImageRenderUtils::inSecondLayer);
                ImageRenderUtils.fillWithCondition(skin, carveColor, ImageRenderUtils::isFirstFace);
                ImageRenderUtils.removeDuplicateWithCondition(marker, firstLayer, ImageRenderUtils::inFirstLayer);
                ImageRenderUtils.removeDuplicateWithCondition(marker, carveColor, ImageRenderUtils::isFirstFace);

                skin.setPixelRGBA(9, 11, 0xFF1F2730);
                skin.setPixelRGBA(14, 11, 0xFF1F2730);
                marker.setPixelRGBA(10, 11, 0xFF1995F8);
                marker.setPixelRGBA(13, 11, 0xFF1995F8);

                Minecraft.getInstance().execute(() -> {
                    ImageRenderUtils.upload(skin, this.skinId);
                    ImageRenderUtils.upload(marker, this.markerId);
                    this.present = true;
                    this.executing = false;
                });
            });
        }
    }

    public static double[][] generatePerlin(long seed, double base, List<PerlinNoise.NoiseConfig> config) {
        PerlinNoise noise = new PerlinNoise(seed, base, config);
        double[][] perlin = new double[64][64];
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 64; j++)
                perlin[i][j] = noise.getHeight(i, j);
        return perlin;
    }

    //这里会自动去除噪点，防止太多单像素点太丑
    public static int[][] generateColors(long seed, double base, List<PerlinNoise.NoiseConfig> config, Float2IntFunction colorLoader) {
        double[][] perlinMap = generatePerlin(seed, base, config);
        int[][] colorMap = ImageRenderUtils.create(64, 64);
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 64; j++)
                colorMap[i][j] = colorLoader.apply((float) perlinMap[i][j]);
        ImageRenderUtils.smooth(colorMap, 0, 0, 64, 64);
        return colorMap;
    }
}
