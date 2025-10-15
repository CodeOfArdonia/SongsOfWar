package com.iafenvoy.sow.entity.magnorite;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class IgneousEntity extends AbstractMagnoriteEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/magnorite/igneous.png");
    public static final ResourceLocation TEXTURE_MARKER = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/magnorite/igneous_marker.png");

    public IgneousEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public ResourceLocation getTextureId() {
        return TEXTURE;
    }

    @Override
    public Optional<ResourceLocation> getMarkerTextureId() {
        return Optional.ofNullable(TEXTURE_MARKER);
    }
}
