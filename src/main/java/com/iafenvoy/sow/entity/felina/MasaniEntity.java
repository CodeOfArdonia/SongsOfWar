package com.iafenvoy.sow.entity.felina;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class MasaniEntity extends AbstractFelinaEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/felina/masani.png");

    public MasaniEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
        this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.BOW));
    }

    @Override
    public ResourceLocation getTextureId() {
        return TEXTURE;
    }

    @Override
    public float getScale() {
        return 0.95f;
    }
}
