package com.iafenvoy.sow.render;

import com.iafenvoy.neptune.render.SimpleTexture;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.ToIntFunction;

@Environment(EnvType.CLIENT)
public final class ImageRenderUtils {
    public static final Identifier WHITE_TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/white.png");
    public static final Identifier STONE_TEXTURE = Identifier.of(Identifier.DEFAULT_NAMESPACE, "textures/block/stone.png");
    public static final int BODY_OFFSET_X = 0;
    public static final int BODY_OFFSET_Y = 20;
    public static final int LEGS_OFFSET_X = 16;
    public static final int LEGS_OFFSET_Y = 52;

    public static void upload(NativeImage texture, Identifier id) {
        SimpleTexture skinTexture = new SimpleTexture(texture);
        skinTexture.upload(false, false);
        MinecraftClient.getInstance().getTextureManager().registerTexture(id, skinTexture);
    }

    public static void directFill(Random random, NativeImage skin, NativeImage grave, int offsetX, int offsetY, boolean[][] map, ToIntFunction<Random> colorProvider) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++) {
                int x = offsetX + i, y = offsetY + j;
                int color = map[i][j] ? colorProvider.applyAsInt(random) : 0;
                skin.setColor(x, y, color);
                grave.setColor(x, y, 20 <= x && x <= 27 && 20 <= y && y <= 31 ? color : 0);
            }
    }

    public static void fillWithCondition(NativeImage image, Color4i[][] source, PointAllow allow) {
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 64; j++)
                if (allow.allow(i, j))
                    image.setColor(i, j, source[i][j].getIntValue());
    }

    public static Color4i interpolateColor(Color4i color1, Color4i color2, double t) {
        t = MathHelper.clamp(t, 0, 1);
        return new Color4i(
                (int) (color1.r + (color2.r - color1.r) * t),
                (int) (color1.g + (color2.g - color1.g) * t),
                (int) (color1.b + (color2.b - color1.b) * t),
                (int) (color1.a + (color2.a - color1.a) * t)
        );
    }


    public static void smooth(Color4i[][] colorMap, int minX, int minY, int maxX, int maxY) {
        for (int i = minX; i < maxX; i++)
            for (int j = minY; j < maxY; j++) {
                if (isAlone(colorMap, i, j))
                    colorMap[i][j] = new Color4i(0, 0, 0, 0);
                else if (isHole(colorMap, i, j))
                    colorMap[i][j] = average(colorMap, i, j);
            }
    }

    public static List<Color4i> getAround(Color4i[][] colorMap, int i, int j) {
        List<Color4i> list = new LinkedList<>();
        if (i > 0) list.add(colorMap[i - 1][j]);
        if (j > 0) list.add(colorMap[i][j - 1]);
        if (i < colorMap.length - 1) list.add(colorMap[i + 1][j]);
        if (j < colorMap[i].length - 1) list.add(colorMap[i][j + 1]);
        return list;
    }

    public static boolean isAlone(Color4i[][] colorMap, int i, int j) {
        return getAround(colorMap, i, j).stream().allMatch(x -> x.a == 0);
    }

    public static boolean isHole(Color4i[][] colorMap, int i, int j) {
        return getAround(colorMap, i, j).stream().allMatch(x -> x.a > 0);
    }

    public static Color4i average(Color4i[][] colorMap, int i, int j) {
        List<Color4i> around = getAround(colorMap, i, j);
        return new Color4i(
                around.stream().map(x -> x.r).reduce(0, Integer::sum, Integer::sum) / around.size(),
                around.stream().map(x -> x.g).reduce(0, Integer::sum, Integer::sum) / around.size(),
                around.stream().map(x -> x.b).reduce(0, Integer::sum, Integer::sum) / around.size(),
                around.stream().map(x -> x.a).reduce(0, Integer::sum, Integer::sum) / around.size()
        );
    }

    @FunctionalInterface
    public interface PointAllow {
        boolean allow(int i, int j);
    }
}
