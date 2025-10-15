package com.iafenvoy.sow.entity.human;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class JalkarEntity extends AbstractHumanEntity {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/human/jalkar.png");

    public JalkarEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
        this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(SowWeapons.SWORD_IRON.get()));
    }

    @Override
    public ResourceLocation getTextureId() {
        return TEXTURE;
    }
}
