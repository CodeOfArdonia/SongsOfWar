package com.iafenvoy.sow.entity.ardoni.random;

import com.iafenvoy.sow.data.ArdoniType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class VoltarisArdoniEntity extends ArdoniEntity {
    public VoltarisArdoniEntity(EntityType<? extends ArdoniEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.VOLTARIS;
    }
}
