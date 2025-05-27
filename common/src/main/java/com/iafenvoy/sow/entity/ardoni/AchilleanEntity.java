package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.compat.ReforgeStoneApi;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public class AchilleanEntity extends AbstractArdoniEntity {
    public static final Identifier TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/achillean.png");
    public static final Identifier TEXTURE_MARKER = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/achillean_marker.png");

    public AchilleanEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        ItemStack stack = new ItemStack(SowWeapons.STAFF_ACHILLEAN.get());
        this.setStackInHand(Hand.MAIN_HAND, ReforgeStoneApi.apply(stack, "yellow", true));
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
        return new Color4i(255, 255, 0, 255);
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.NESTORIS;
    }
}
