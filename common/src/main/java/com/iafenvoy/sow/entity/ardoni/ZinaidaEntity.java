package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public class ZinaidaEntity extends AbstractArdoniEntity {
    public static final Identifier TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/zinaida.png");
    public static final Identifier TEXTURE_MARKER = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/zinaida_marker.png");
    public static final Color4i COLOR = new Color4i(209, 94, 95, 255);

    public ZinaidaEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Identifier getTextureId() {
        return TEXTURE;
    }

    @Override
    public Optional<Identifier> getMarkerTextureId() {
        return Optional.ofNullable(TEXTURE_MARKER);
    }

    @Override
    public Color4i getColor() {
        return COLOR;
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.VOLTARIS;
    }
}
