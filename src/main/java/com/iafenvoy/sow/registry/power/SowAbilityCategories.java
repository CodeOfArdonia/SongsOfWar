package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.registry.NeptuneRegistries;
import com.iafenvoy.sow.SongsOfWar;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Locale;

public final class SowAbilityCategories {
    public static final DeferredRegister<AbilityCategory> REGISTRY = DeferredRegister.create(NeptuneRegistries.ABILITY_CATEGORY, SongsOfWar.MOD_ID);

    static {
        for (SowAbilityCategory category : SowAbilityCategory.values())
            REGISTRY.register(category.name().toLowerCase(Locale.ROOT), category::getCategory);
    }
}
