package com.iafenvoy.sow.entity.human.soldier;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class FeldenSoldierEntity extends AbstractSoldierEntity {
    public FeldenSoldierEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.Felden;
    }

    @Override
    public int getVariantCount() {
        return 35;
    }

    @Override
    public float getScale() {
        return 1.05f;
    }
}
