package com.iafenvoy.sow.entity.human.soldier;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class CrownPeakSoldierEntity extends AbstractSoldierEntity {
    public CrownPeakSoldierEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.CROWN_PEAK;
    }

    @Override
    public int getVariantCount() {
        return 10;
    }
}
