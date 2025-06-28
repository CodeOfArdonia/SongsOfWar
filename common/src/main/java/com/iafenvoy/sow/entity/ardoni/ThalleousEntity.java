package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.compat.ReforgeStoneApi;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.Anniversary;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.registry.SowDelight;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public class ThalleousEntity extends AbstractArdoniEntity {
    public static final Identifier TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/thalleous.png");
    public static final Identifier TEXTURE_MARKER = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/thalleous_marker.png");
    public static final Color4i COLOR = new Color4i(0, 162, 232, 255);

    public ThalleousEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        ItemStack stack = new ItemStack(SowWeapons.SWORD_THALLEOUS.get());
        this.setStackInHand(Hand.MAIN_HAND, ReforgeStoneApi.apply(stack, "blue", true));
        if (Anniversary.shouldInvoke())
            this.setStackInHand(Hand.OFF_HAND, new ItemStack(SowDelight.PEAS_CAN.get()));
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
        return ArdoniType.SENDARIS;
    }
}
