package com.iafenvoy.sow.entity.netharan;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class ChronosEntity extends AbstractNetheranEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/netharan/chronos.png");
    public static final ResourceLocation TEXTURE_MARKER = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/netharan/chronos_marker.png");

    public ChronosEntity(EntityType<? extends Monster> entityType, Level world) {
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
