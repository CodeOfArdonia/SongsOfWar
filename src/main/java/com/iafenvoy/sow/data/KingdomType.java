package com.iafenvoy.sow.data;

import com.iafenvoy.sow.registry.SowBanners;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public enum KingdomType {
    CONCHORD("conchord", SowBanners.CONCHORD, SowBanners.CONCHORD_SIMPLE),
    CROWN_PEAK("crown_peak", SowBanners.CROWN_PEAK, null),
    CYDONIA("cydonia", SowBanners.CYDONIA, SowBanners.CYDONIA_SIMPLE),
    ETHEREA("etherea", null, null),
    FELDEN("felden", SowBanners.FELDEN, SowBanners.FELDEN_SIMPLE),
    GENERAL("general", null, null),
    HYDRAPHEL("hydraphel", SowBanners.HYDRAPHEL, SowBanners.HYDRAPHEL_SIMPLE),
    KARTHEN("karthen", SowBanners.KARTHEN, SowBanners.KARTHEN_SIMPLE),
    NORTHWIND("northwind", SowBanners.NORTHWIND, SowBanners.NORTHWIND_SIMPLE);
    private final String id;
    @Nullable
    private final Function<HolderGetter<BannerPattern>, ItemStack> banner, bannerSmall;

    KingdomType(String id, @Nullable Function<HolderGetter<BannerPattern>, ItemStack> banner, @Nullable Function<HolderGetter<BannerPattern>, ItemStack> bannerSmall) {
        this.id = id;
        this.banner = banner;
        this.bannerSmall = bannerSmall;
    }

    public String getId() {
        return this.id;
    }

    public ItemStack getShield(HolderGetter<BannerPattern> getter) {
        ItemStack stack = new ItemStack(Items.SHIELD);
        if (this.banner == null) return stack;
        stack.set(DataComponents.BANNER_PATTERNS, this.banner.apply(getter).getOrDefault(DataComponents.BANNER_PATTERNS, new BannerPatternLayers(List.of())));
        return stack;
    }
}
