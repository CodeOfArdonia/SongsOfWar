package com.iafenvoy.sow.entity.felina;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class YujukiEntity extends AbstractFelinaEntity {
    public static final Identifier TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/felina/yujuki.png");

    public YujukiEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setStackInHand(Hand.MAIN_HAND, new ItemStack(SowWeapons.SPEAR_IRON_1.get()));
    }

    @Override
    public Identifier getTextureId() {
        return TEXTURE;
    }

    @Override
    public float getScale() {
        return 0.95f;
    }
}
