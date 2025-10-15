package com.iafenvoy.sow.entity.necromancer;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class XariaEntity extends AbstractNecromancerEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/necromancer/xaria.png");

    public XariaEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public ResourceLocation getTextureId() {
        return TEXTURE;
    }
}
