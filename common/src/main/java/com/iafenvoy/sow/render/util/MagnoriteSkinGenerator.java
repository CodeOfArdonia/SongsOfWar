package com.iafenvoy.sow.render.util;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.render.ImageRenderUtils;
import com.iafenvoy.sow.util.PerlinNoise;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleFunction;

public class MagnoriteSkinGenerator {
    private static final Map<Long, MagnoriteSkinGenerator> GENERATORS = new HashMap<>();
    private static final List<Pair<Rectangle, Rectangle>> layerMapping = List.of(
            new Pair<>(new Rectangle(8, 0, 15, 7), new Rectangle(40, 0, 55, 7)),
            new Pair<>(new Rectangle(0, 8, 31, 15), new Rectangle(32, 8, 63, 15)),
            new Pair<>(new Rectangle(4, 16, 11, 19), new Rectangle(4, 32, 11, 35)),
            new Pair<>(new Rectangle(20, 16, 35, 19), new Rectangle(20, 32, 35, 35)),
            new Pair<>(new Rectangle(44, 16, 51, 19), new Rectangle(44, 32, 51, 35)),
            new Pair<>(new Rectangle(0, 20, 55, 31), new Rectangle(0, 36, 55, 47)),
            new Pair<>(new Rectangle(20, 48, 27, 51), new Rectangle(4, 48, 11, 51)),
            new Pair<>(new Rectangle(36, 48, 43, 51), new Rectangle(52, 48, 59, 51)),
            new Pair<>(new Rectangle(16, 52, 31, 63), new Rectangle(0, 52, 15, 63)),
            new Pair<>(new Rectangle(32, 52, 47, 63), new Rectangle(48, 52, 63, 63))
    );
    private final long seed;
    private final Identifier skinId;
    private boolean present = false;

    private MagnoriteSkinGenerator(long seed) {
        this.seed = seed;
        this.skinId = Identifier.of(SongsOfWar.MOD_ID, "magnorite_skin_" + seed);
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

    public Identifier getForSkin() {
        if (!this.present) this.generate();
        return this.skinId;
    }

    private void generate() {
        this.present = true;
        NativeImage skin = new NativeImage(64, 64, true);
        Color4i[][] lavaMap = this.generateColors(this.seed, 0.2, List.of(
                PerlinNoise.NoiseConfig.of(8, 0.5),
                PerlinNoise.NoiseConfig.of(5, 0.25),
                PerlinNoise.NoiseConfig.of(3, 0.125),
                PerlinNoise.NoiseConfig.of(1, 0.0625)
        ), h -> ImageRenderUtils.interpolateColor(new Color4i(0xff, 0x45, 0x00, 0xff), new Color4i(0xff, 0xff, 0x00, 0xff), h));
        ImageRenderUtils.fillWithCondition(skin, lavaMap, MagnoriteSkinGenerator::inFirstLayer);

        Color4i[][] carveColor = this.generateColors(this.seed + 1, 0, List.of(
                PerlinNoise.NoiseConfig.of(1, 0.75),
                PerlinNoise.NoiseConfig.of(0.5, 0.5),
                PerlinNoise.NoiseConfig.of(0.25, 0.25)
        ), h -> ImageRenderUtils.interpolateColor(new Color4i(0x72, 0x5f, 0x52, 0xff), new Color4i(0x1c, 0x15, 0x12, 0xff), h));
        Color4i[][] carve = this.generateColors(this.seed + 2, -0.5, List.of(
                PerlinNoise.NoiseConfig.of(2, 1.5),
                PerlinNoise.NoiseConfig.of(1.5, 1.5),
                PerlinNoise.NoiseConfig.of(0.5, 0.5)
        ), h -> h > 0 ? new Color4i(0xff, 0xff, 0xff, 0xff) : new Color4i(0, 0, 0, 0));
        Color4i[][] firstLayer = new Color4i[64][64], secondLayer = new Color4i[64][64];
        resolveCarve(carveColor, carve, firstLayer, secondLayer);
        ImageRenderUtils.fillWithCondition(skin, firstLayer, MagnoriteSkinGenerator::inFirstLayer);
        ImageRenderUtils.fillWithCondition(skin, secondLayer, MagnoriteSkinGenerator::inSecondLayer);
        ImageRenderUtils.fillWithCondition(skin, carveColor, MagnoriteSkinGenerator::isFirstFace);

        skin.setColor(9, 11, new Color4i(0x30, 0x27, 0x1F, 0xFF).getIntValue());
        skin.setColor(14, 11, new Color4i(0x30, 0x27, 0x1F, 0xFF).getIntValue());
        skin.setColor(10, 11, 16767902);
        skin.setColor(13, 11, 16767902);

        ImageRenderUtils.upload(skin, this.skinId);
    }

    public double[][] generatePerlin(long seed, double base, List<PerlinNoise.NoiseConfig> config) {
        PerlinNoise noise = new PerlinNoise(seed, base, config);
        double[][] perlin = new double[64][64];
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 64; j++)
                perlin[i][j] = noise.getHeight(i, j);
        return perlin;
    }

    //这里会自动去除噪点，防止太多单像素点太丑
    public Color4i[][] generateColors(long seed, double base, List<PerlinNoise.NoiseConfig> config, DoubleFunction<Color4i> colorLoader) {
        double[][] perlinMap = this.generatePerlin(seed, base, config);
        Color4i[][] colorMap = new Color4i[64][64];
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 64; j++)
                colorMap[i][j] = colorLoader.apply(perlinMap[i][j]);
        ImageRenderUtils.smooth(colorMap, 0, 0, 64, 64);
        return colorMap;
    }

    private static boolean inFirstLayer(int i, int j) {
        if (isFirstFace(i, j)) return false;
        for (Pair<Rectangle, Rectangle> pair : layerMapping)
            if (pair.getLeft().xMin <= i && i <= pair.getLeft().xMax && pair.getLeft().yMin <= j && j <= pair.getLeft().yMax)
                return true;
        return false;
    }

    private static boolean inSecondLayer(int i, int j) {
        if (isSecondFace(i, j)) return false;
        for (Pair<Rectangle, Rectangle> pair : layerMapping)
            if (pair.getRight().xMin <= i && i <= pair.getRight().xMax && pair.getRight().yMin <= j && j <= pair.getRight().yMax)
                return true;
        return false;
    }

    private static boolean isFirstFace(int i, int j) {
        return 8 <= i && i <= 15 && 9 <= j && j <= 12 || 10 <= i && i <= 13 && 13 <= j && j <= 15;
    }

    private static boolean isSecondFace(int i, int j) {
        return 41 <= i && i <= 42 && 10 <= j && j <= 12 || 45 <= i && i <= 46 && 10 <= j && j <= 12;
    }

    private static void resolveCarve(Color4i[][] carveColor, Color4i[][] carve, Color4i[][] firstLayer, Color4i[][] secondLayer) {
        for (Pair<Rectangle, Rectangle> pair : layerMapping)
            for (int i = pair.getLeft().xMin; i <= pair.getLeft().xMax; i++)
                for (int j = pair.getLeft().yMin; j <= pair.getLeft().yMax; j++)
                    if (carve[i][j].a > 0) firstLayer[i][j] = carveColor[i][j];
                    else
                        secondLayer[i - pair.getLeft().xMin + pair.getRight().xMin][j - pair.getLeft().yMin + pair.getRight().yMin] = carveColor[i][j];
    }

    private record Rectangle(int xMin, int yMin, int xMax, int yMax) {
    }
}
