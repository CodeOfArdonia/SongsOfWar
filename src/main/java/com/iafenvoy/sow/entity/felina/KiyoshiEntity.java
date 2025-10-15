package com.iafenvoy.sow.entity.felina;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class KiyoshiEntity extends AbstractFelinaEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/felina/kiyoshi.png");

    public KiyoshiEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
        this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(SowWeapons.HALBERD_IRON_2.get()));
    }

    @Override
    public ResourceLocation getTextureId() {
        return TEXTURE;
    }

    @Override
    public float getScale() {
        return 1.05f;
    }
}
