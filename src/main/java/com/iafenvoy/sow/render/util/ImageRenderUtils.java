package com.iafenvoy.sow.render.util;

import com.iafenvoy.neptune.render.SimpleTexture;
import com.mojang.blaze3d.platform.NativeImage;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.Tuple;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public final class ImageRenderUtils {
    public static final int BODY_OFFSET_X = 0;
    public static final int BODY_OFFSET_Y = 20;
    public static final int LEGS_OFFSET_X = 16;
    public static final int LEGS_OFFSET_Y = 52;
    public static final List<Tuple<Rectangle, Rectangle>> LAYER_MAPPING = List.of(
            new Tuple<>(new Rectangle(8, 0, 23, 7), new Rectangle(40, 0, 55, 7)),
            new Tuple<>(new Rectangle(0, 8, 31, 15), new Rectangle(32, 8, 63, 15)),
            new Tuple<>(new Rectangle(4, 16, 11, 19), new Rectangle(4, 32, 11, 35)),
            new Tuple<>(new Rectangle(20, 16, 35, 19), new Rectangle(20, 32, 35, 35)),
            new Tuple<>(new Rectangle(44, 16, 51, 19), new Rectangle(44, 32, 51, 35)),
            new Tuple<>(new Rectangle(0, 20, 55, 31), new Rectangle(0, 36, 55, 47)),
            new Tuple<>(new Rectangle(20, 48, 27, 51), new Rectangle(4, 48, 11, 51)),
            new Tuple<>(new Rectangle(36, 48, 43, 51), new Rectangle(52, 48, 59, 51)),
            new Tuple<>(new Rectangle(16, 52, 31, 63), new Rectangle(0, 52, 15, 63)),
            new Tuple<>(new Rectangle(32, 52, 47, 63), new Rectangle(48, 52, 63, 63))
    );

    public static int[][] create(int x, int y) {
        int[][] data = new int[x][y];
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                data[i][j] = 0;
        return data;
    }

    public static void upload(NativeImage texture, ResourceLocation id) {
        SimpleTexture skinTexture = new SimpleTexture(texture);
        skinTexture.upload(false, false);
        Minecraft.getInstance().getTextureManager().register(id, skinTexture);
    }

    public static void fillWithCondition(NativeImage image, int[][] source, Int2BooleanBiFunction allow) {
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 64; j++)
                if (allow.applyAsBoolean(i, j) && (source[i][j] & 0xFF000000) > 0)
                    image.setPixelRGBA(i, j, source[i][j]);
    }

    public static void removeDuplicateWithCondition(NativeImage image, int[][] source, Int2BooleanBiFunction allow) {
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 64; j++)
                if (allow.applyAsBoolean(i, j) && (source[i][j] & 0xFF000000) > 0)
                    image.setPixelRGBA(i, j, 0);
    }

    public static int interpolateColor(int color1, int color2, float t) {
        t = Mth.clamp(t, 0, 1);
        return FastColor.ARGB32.lerp(t, color1, color2);
    }

    public static void smooth(int[][] colorMap, int minX, int minY, int maxX, int maxY) {
        for (int i = minX; i < maxX; i++)
            for (int j = minY; j < maxY; j++) {
                if (isAlone(colorMap, i, j))
                    colorMap[i][j] = 0;
                else if (isHole(colorMap, i, j))
                    colorMap[i][j] = average(colorMap, i, j);
            }
    }

    public static IntList getAround(int[][] colorMap, int i, int j) {
        IntList list = new IntArrayList();
        if (i > 0) list.add(colorMap[i - 1][j]);
        if (j > 0) list.add(colorMap[i][j - 1]);
        if (i < colorMap.length - 1) list.add(colorMap[i + 1][j]);
        if (j < colorMap[i].length - 1) list.add(colorMap[i][j + 1]);
        return list;
    }

    public static boolean isAlone(int[][] colorMap, int i, int j) {
        return getAround(colorMap, i, j).intStream().allMatch(x -> (x & 0xFF000000) == 0);
    }

    public static boolean isHole(int[][] colorMap, int i, int j) {
        return getAround(colorMap, i, j).intStream().allMatch(x -> (x & 0xFF000000) > 0);
    }

    public static int average(int[][] colorMap, int i, int j) {
        IntList around = getAround(colorMap, i, j);
        return FastColor.ARGB32.color(
                around.intStream().map(FastColor.ARGB32::alpha).reduce(0, Integer::sum) / around.size(),
                around.intStream().map(FastColor.ARGB32::red).reduce(0, Integer::sum) / around.size(),
                around.intStream().map(FastColor.ARGB32::green).reduce(0, Integer::sum) / around.size(),
                around.intStream().map(FastColor.ARGB32::blue).reduce(0, Integer::sum) / around.size()
        );
    }

    public static boolean inFirstLayer(int i, int j) {
        if (isFirstFace(i, j)) return false;
        for (Tuple<Rectangle, Rectangle> pair : LAYER_MAPPING)
            if (pair.getA().xMin() <= i && i <= pair.getA().xMax() && pair.getA().yMin() <= j && j <= pair.getA().yMax())
                return true;
        return false;
    }

    public static boolean inSecondLayer(int i, int j) {
        if (isSecondFace(i, j)) return false;
        for (Tuple<Rectangle, Rectangle> pair : LAYER_MAPPING)
            if (pair.getB().xMin() <= i && i <= pair.getB().xMax() && pair.getB().yMin() <= j && j <= pair.getB().yMax())
                return true;
        return false;
    }

    public static boolean isFirstFace(int i, int j) {
        return 8 <= i && i <= 15 && 9 <= j && j <= 12 || 10 <= i && i <= 13 && 13 <= j && j <= 15;
    }

    private static boolean isSecondFace(int i, int j) {
        return 41 <= i && i <= 42 && 10 <= j && j <= 12 || 45 <= i && i <= 46 && 10 <= j && j <= 12;
    }

    public static void resolveCarve(int[][] carveColor, int[][] carve, int[][] firstLayer, int[][] secondLayer) {
        for (Tuple<Rectangle, Rectangle> pair : LAYER_MAPPING)
            for (int i = pair.getA().xMin(); i <= pair.getA().xMax(); i++)
                for (int j = pair.getA().yMin(); j <= pair.getA().yMax(); j++)
                    if ((carve[i][j] & 0xFF000000) > 0) firstLayer[i][j] = carveColor[i][j];
                    else
                        secondLayer[i - pair.getA().xMin() + pair.getB().xMin()][j - pair.getA().yMin() + pair.getB().yMin()] = carveColor[i][j];
    }

    public record Rectangle(int xMin, int yMin, int xMax, int yMax) {
    }

    @FunctionalInterface
    public interface Int2BooleanBiFunction {
        boolean applyAsBoolean(int i1, int i2);
    }
}
