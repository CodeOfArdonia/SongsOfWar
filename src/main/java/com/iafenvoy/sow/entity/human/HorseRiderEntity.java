package com.iafenvoy.sow.entity.human;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class HorseRiderEntity extends AbstractHumanEntity {
    public HorseRiderEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public ResourceLocation getTextureId() {
        return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/human/horse_rider.png");
    }
}
