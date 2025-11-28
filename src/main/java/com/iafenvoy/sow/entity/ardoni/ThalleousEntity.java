package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.sow.Proxies;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.Anniversary;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.registry.SowDelight;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class ThalleousEntity extends AbstractArdoniEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/thalleous.png");
    public static final ResourceLocation TEXTURE_MARKER = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/thalleous_marker.png");
    public static final int COLOR = 0xFF00A2E8;

    public ThalleousEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
        ItemStack stack = new ItemStack(SowWeapons.SWORD_THALLEOUS.get());
        this.setItemInHand(InteractionHand.MAIN_HAND, Proxies.reforgedStoneProxy.apply(stack, "blue", true));
        if (Anniversary.shouldInvoke())
            this.setItemInHand(InteractionHand.OFF_HAND, SowDelight.PEAS_CAN.toStack());
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
    public int getColor() {
        return COLOR;
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.SENDARIS;
    }
}
