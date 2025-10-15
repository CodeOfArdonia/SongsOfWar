package com.iafenvoy.sow.entity.human.guard;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class KarthenGuardEntity extends AbstractGuardEntity {
    public KarthenGuardEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.Karthen;
    }

    @Override
    public int getVariantCount() {
        return 8;
    }
}
