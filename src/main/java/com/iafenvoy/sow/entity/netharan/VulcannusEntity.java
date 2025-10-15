package com.iafenvoy.sow.entity.netharan;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class VulcannusEntity extends AbstractNetheranEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/netharan/vulcannus.png");
    public static final ResourceLocation TEXTURE_MARKER = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/netharan/vulcannus_marker.png");

    public VulcannusEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public ResourceLocation getTextureId() {
        return TEXTURE;
    }

    @Override
    public Optional<ResourceLocation> getMarkerTextureId() {
        return Optional.of(TEXTURE_MARKER);
    }
}
