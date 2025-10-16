package com.iafenvoy.sow.entity.human.guard;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class FeldenGuardEntity extends AbstractGuardEntity {
    public FeldenGuardEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.FELDEN;
    }

    @Override
    public int getVariantCount() {
        return 10;
    }

    @Override
    public float getScale() {
        return 1.05f;
    }
}
