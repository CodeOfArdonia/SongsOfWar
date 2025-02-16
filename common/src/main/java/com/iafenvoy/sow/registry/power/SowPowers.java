package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.power.type.AbstractPower;
import com.iafenvoy.sow.item.block.AbstractSongCubeBlock;
import com.iafenvoy.sow.registry.SowItemGroups;
import dev.architectury.registry.CreativeTabRegistry;

public final class SowPowers {
    public static void init() {
        AggressiumPowers.init();
        MobiliumPowers.init();
        ProtisiumPowers.init();
        SupportiumPowers.init();
        for (AbstractPower<?> power : AbstractPower.POWERS)
            CreativeTabRegistry.appendStack(SowItemGroups.POWER, () -> AbstractSongCubeBlock.getStack(power));
    }
}
