package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.object.BannerUtil;
import com.iafenvoy.sow.SongsOfWar;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatterns;

import java.util.List;
import java.util.function.Function;

@SuppressWarnings("all")
public final class SowBanners {
    public static final Function<HolderGetter<BannerPattern>, ItemStack> CONCHORD = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".conchord", Items.GREEN_BANNER,
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.BROWN),
            new Pair<>(BannerPatterns.TRIANGLE_BOTTOM, DyeColor.BROWN),
            new Pair<>(BannerPatterns.CROSS, DyeColor.WHITE)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> CONCHORD_SIMPLE = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".conchord_simple", Items.BROWN_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.WHITE),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.GREEN)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> CROWN_PEAK = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".crown_peak", Items.GRAY_BANNER,
            new Pair<>(BannerPatterns.BRICKS, DyeColor.LIGHT_GRAY),
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.PURPLE),
            new Pair<>(BannerPatterns.BORDER, DyeColor.GRAY),
            new Pair<>(BannerPatterns.STRAIGHT_CROSS, DyeColor.WHITE),
            new Pair<>(BannerPatterns.RHOMBUS_MIDDLE, DyeColor.GRAY),
            new Pair<>(BannerPatterns.CIRCLE_MIDDLE, DyeColor.WHITE)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> CYDONIA = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".cydonia", Items.WHITE_BANNER,
            new Pair<>(BannerPatterns.HALF_HORIZONTAL, DyeColor.GRAY),
            new Pair<>(BannerPatterns.STRIPE_MIDDLE, DyeColor.ORANGE),
            new Pair<>(BannerPatterns.RHOMBUS_MIDDLE, DyeColor.ORANGE)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> CYDONIA_SIMPLE = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".cydonia_simple", Items.WHITE_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.GRAY),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.ORANGE)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> FELDEN = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".felden", Items.BLACK_BANNER,
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.GREEN),
            new Pair<>(BannerPatterns.STRIPE_CENTER, DyeColor.GREEN),
            new Pair<>(BannerPatterns.FLOWER, DyeColor.LIME),
            new Pair<>(BannerPatterns.RHOMBUS_MIDDLE, DyeColor.BLACK),
            new Pair<>(BannerPatterns.CIRCLE_MIDDLE, DyeColor.LIME)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> FELDEN_SIMPLE = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".felden_simple", Items.GREEN_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.LIME),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.BLACK)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> HYDRAPHEL = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".hydraphel", Items.GRAY_BANNER,
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.CROSS, DyeColor.WHITE),
            new Pair<>(BannerPatterns.TRIANGLE_BOTTOM, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.FLOWER, DyeColor.WHITE),
            new Pair<>(BannerPatterns.RHOMBUS_MIDDLE, DyeColor.WHITE),
            new Pair<>(BannerPatterns.CIRCLE_MIDDLE, DyeColor.GRAY)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> HYDRAPHEL_SIMPLE = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".hydraphel_simple", Items.LIGHT_BLUE_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.WHITE),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.GRAY)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> KARTHEN = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".karthen", Items.RED_BANNER,
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.BLACK),
            new Pair<>(BannerPatterns.TRIANGLE_BOTTOM, DyeColor.BLACK),
            new Pair<>(BannerPatterns.TRIANGLES_TOP, DyeColor.GRAY),
            new Pair<>(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.GRAY),
            new Pair<>(BannerPatterns.CURLY_BORDER, DyeColor.BLACK),
            new Pair<>(BannerPatterns.RHOMBUS_MIDDLE, DyeColor.GRAY)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> KARTHEN_SIMPLE = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".karthen_simple", Items.RED_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.GRAY),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.BLACK)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> NORTHWIND = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".northwind", Items.BLUE_BANNER,
            new Pair<>(BannerPatterns.GRADIENT_UP, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.TRIANGLES_TOP, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.WHITE),
            new Pair<>(BannerPatterns.FLOWER, DyeColor.WHITE)
    );
    public static final Function<HolderGetter<BannerPattern>, ItemStack> NORTHWIND_SIMPLE = BannerUtil.lazy("banner." + SongsOfWar.MOD_ID + ".northwind_simple", Items.WHITE_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.BLUE)
    );
    public static final List<Function<HolderGetter<BannerPattern>, ItemStack>> ALL = List.of(CONCHORD, CONCHORD_SIMPLE, CROWN_PEAK, CYDONIA, CYDONIA_SIMPLE, FELDEN, FELDEN_SIMPLE, HYDRAPHEL, HYDRAPHEL_SIMPLE, KARTHEN, KARTHEN_SIMPLE, NORTHWIND, NORTHWIND_SIMPLE);
}
