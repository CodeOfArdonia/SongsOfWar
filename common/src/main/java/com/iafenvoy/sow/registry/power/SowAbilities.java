package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.type.AbstractAbility;
import com.iafenvoy.sow.item.block.AbstractSongCubeBlock;
import com.iafenvoy.sow.registry.SowItemGroups;
import dev.architectury.registry.CreativeTabRegistry;

public final class SowAbilities {
    public static void init() {
        AggressiumPowers.init();
        MobiliumPowers.init();
        ProtisiumPowers.init();
        SupportiumPowers.init();
        for (AbilityCategory category : SowAbilityCategories.ALL)
            for (AbstractAbility<?> power : category.getAbilities())
                CreativeTabRegistry.appendStack(SowItemGroups.POWER, () -> AbstractSongCubeBlock.getStack(power));
    }
}
