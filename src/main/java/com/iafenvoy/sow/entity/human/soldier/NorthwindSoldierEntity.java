package com.iafenvoy.sow.entity.human.soldier;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class NorthwindSoldierEntity extends AbstractSoldierEntity {
    public NorthwindSoldierEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.Northwind;
    }

    @Override
    public int getVariantCount() {
        return 3;
    }
}
