package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.Proxies;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class RiaEntity extends AbstractArdoniEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/ria.png");
    public static final ResourceLocation TEXTURE_MARKER = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/ria_marker.png");
    public static final Color4i COLOR = new Color4i(136, 241, 255, 255);

    public RiaEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
        ItemStack stack = SowWeapons.SPEAR_IRON_4.toStack();
        this.setItemInHand(InteractionHand.MAIN_HAND, Proxies.reforgedStoneProxy.apply(stack, "aqua", true));
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
        return ArdoniType.SENDARIS;
    }

    @Override
    public boolean isFemale() {
        return true;
    }
}
