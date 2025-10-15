package com.iafenvoy.sow.entity.human;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class AlecEntity extends AbstractHumanEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/human/alec.png");

    public AlecEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
        this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.GOLDEN_SWORD));
    }

    @Override
    public ResourceLocation getTextureId() {
        return TEXTURE;
    }
}
