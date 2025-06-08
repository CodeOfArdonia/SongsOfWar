package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.type.AbstractAbility;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.SowItemGroups;
import dev.architectury.registry.CreativeTabRegistry;

public final class SowAbilities {
    public static void init() {
        AggressiumPowers.init();
        MobiliumPowers.init();
        ProtisiumPowers.init();
        SupportiumPowers.init();
        for (SowAbilityCategory category : SowAbilityCategory.values())
            for (AbstractAbility<?> power : category.getCategory().getAbilities())
                CreativeTabRegistry.appendStack(SowItemGroups.POWER, () -> SongCubeBlock.getStack(power));
    }
}
