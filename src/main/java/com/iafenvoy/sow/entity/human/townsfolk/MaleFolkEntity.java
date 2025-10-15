package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class MaleFolkEntity extends AbstractTownsFolkEntity {
    public MaleFolkEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "male";
    }

    @Override
    public int getVariantCount() {
        return 34;
    }
}
