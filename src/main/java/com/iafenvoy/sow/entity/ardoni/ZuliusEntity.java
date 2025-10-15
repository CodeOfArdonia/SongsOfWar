package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class ZuliusEntity extends AbstractArdoniEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/zulius.png");
    public static final ResourceLocation TEXTURE_MARKER = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/zulius_marker.png");
    public static final Color4i COLOR = new Color4i(0, 255, 0, 255);

    public ZuliusEntity(EntityType<? extends Monster> entityType, Level world) {
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

    @Override
    public Color4i getColor() {
        return COLOR;
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.KALTARIS;
    }
}
