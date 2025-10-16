package com.iafenvoy.sow.registry.power;

import com.google.common.base.Suppliers;
import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.registry.NeptuneRegistries;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public final class SowAbilityCategories {
    public static final DeferredRegister<AbilityCategory> REGISTRY = DeferredRegister.create(NeptuneRegistries.ABILITY_CATEGORY, SongsOfWar.MOD_ID);
    public static final Supplier<List<AbilityCategory>> ALL = Suppliers.memoize(() -> REGISTRY.getEntries().stream().map(DeferredHolder::get).map(AbilityCategory.class::cast).toList());

    public static final DeferredHolder<AbilityCategory, AbilityCategory> AGGRESSIUM = REGISTRY.register("aggressium", () -> new AbilityCategory(new Color4i(237, 28, 36, 255), () -> true));
    public static final DeferredHolder<AbilityCategory, AbilityCategory> MOBILIUM = REGISTRY.register("mobilium", () -> new AbilityCategory(new Color4i(255, 242, 0, 255), () -> true));
    public static final DeferredHolder<AbilityCategory, AbilityCategory> PROTISIUM = REGISTRY.register("protisium", () -> new AbilityCategory(new Color4i(115, 251, 253, 255), () -> true));
    public static final DeferredHolder<AbilityCategory, AbilityCategory> SUPPORTIUM = REGISTRY.register("supportium", () -> new AbilityCategory(new Color4i(117, 249, 77, 255), () -> true));
}
