package com.iafenvoy.sow.registry.power;

import com.google.common.base.Suppliers;
import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.registry.NeptuneRegistries;
import com.iafenvoy.sow.SongsOfWar;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public final class SowAbilityCategories {
    public static final DeferredRegister<AbilityCategory> REGISTRY = DeferredRegister.create(NeptuneRegistries.ABILITY_CATEGORY, SongsOfWar.MOD_ID);
    public static final Supplier<List<AbilityCategory>> ALL = Suppliers.memoize(() -> REGISTRY.getEntries().stream().map(DeferredHolder::get).map(AbilityCategory.class::cast).toList());

    public static final DeferredHolder<AbilityCategory, AbilityCategory> AGGRESSIUM = REGISTRY.register("aggressium", () -> new AbilityCategory(0xFFED1C24, () -> true));
    public static final DeferredHolder<AbilityCategory, AbilityCategory> MOBILIUM = REGISTRY.register("mobilium", () -> new AbilityCategory(0xFFFFF200, () -> true));
    public static final DeferredHolder<AbilityCategory, AbilityCategory> PROTISIUM = REGISTRY.register("protisium", () -> new AbilityCategory(0xFF73FBFD, () -> true));
    public static final DeferredHolder<AbilityCategory, AbilityCategory> SUPPORTIUM = REGISTRY.register("supportium", () -> new AbilityCategory(0xFF75F94D, () -> true));
}
