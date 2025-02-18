package com.iafenvoy.sow.render.util;

import com.iafenvoy.neptune.render.SimpleTexture;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.neptune.util.function.Int2BooleanBiFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.MathHelper;

import java.util.LinkedList;
import java.util.List;

@Environment(EnvType.CLIENT)
public final class ImageRenderUtils {
    public static final int BODY_OFFSET_X = 0;
    public static final int BODY_OFFSET_Y = 20;
    public static final int LEGS_OFFSET_X = 16;
    public static final int LEGS_OFFSET_Y = 52;
    public static final List<Pair<Rectangle, Rectangle>> LAYER_MAPPING = List.of(
            new Pair<>(new Rectangle(8, 0, 23, 7), new Rectangle(40, 0, 55, 7)),
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

    public static Color4i[][] create(int x, int y) {
        Color4i[][] data = new Color4i[x][y];
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                data[i][j] = new Color4i(0, 0, 0, 0);
        return data;
    }

    public static void upload(NativeImage texture, Identifier id) {
        SimpleTexture skinTexture = new SimpleTexture(texture);
        skinTexture.upload(false, false);
        MinecraftClient.getInstance().getTextureManager().registerTexture(id, skinTexture);
    }

    public static void fillWithCondition(NativeImage image, Color4i[][] source, Int2BooleanBiFunction allow) {
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 64; j++)
                if (allow.applyAsBoolean(i, j) && source[i][j].a > 0)
                    image.setColor(i, j, source[i][j].getIntValue());
    }

    public static void removeDuplicateWithCondition(NativeImage image, Color4i[][] source, Int2BooleanBiFunction allow) {
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 64; j++)
                if (allow.applyAsBoolean(i, j) && source[i][j].a > 0)
                    image.setColor(i, j, 0);
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

    public static boolean inFirstLayer(int i, int j) {
        if (isFirstFace(i, j)) return false;
        for (Pair<Rectangle, Rectangle> pair : LAYER_MAPPING)
            if (pair.getLeft().xMin() <= i && i <= pair.getLeft().xMax() && pair.getLeft().yMin() <= j && j <= pair.getLeft().yMax())
                return true;
        return false;
    }

    public static boolean inSecondLayer(int i, int j) {
        if (isSecondFace(i, j)) return false;
        for (Pair<Rectangle, Rectangle> pair : LAYER_MAPPING)
            if (pair.getRight().xMin() <= i && i <= pair.getRight().xMax() && pair.getRight().yMin() <= j && j <= pair.getRight().yMax())
                return true;
        return false;
    }

    public static boolean isFirstFace(int i, int j) {
        return 8 <= i && i <= 15 && 9 <= j && j <= 12 || 10 <= i && i <= 13 && 13 <= j && j <= 15;
    }

    private static boolean isSecondFace(int i, int j) {
        return 41 <= i && i <= 42 && 10 <= j && j <= 12 || 45 <= i && i <= 46 && 10 <= j && j <= 12;
    }

    public static void resolveCarve(Color4i[][] carveColor, Color4i[][] carve, Color4i[][] firstLayer, Color4i[][] secondLayer) {
        for (Pair<Rectangle, Rectangle> pair : LAYER_MAPPING)
            for (int i = pair.getLeft().xMin(); i <= pair.getLeft().xMax(); i++)
                for (int j = pair.getLeft().yMin(); j <= pair.getLeft().yMax(); j++)
                    if (carve[i][j].a > 0) firstLayer[i][j] = carveColor[i][j];
                    else
                        secondLayer[i - pair.getLeft().xMin() + pair.getRight().xMin()][j - pair.getLeft().yMin() + pair.getRight().yMin()] = carveColor[i][j];
    }

    public record Rectangle(int xMin, int yMin, int xMax, int yMax) {
    }
}
