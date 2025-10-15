package com.iafenvoy.sow.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

import java.util.function.Function;

public class SowSwordItem extends SwordItem implements SowWeapon {
    public SowSwordItem(Tier toolMaterial, int attackDamage, float attackSpeed, Function<Properties, Properties> settings) {
        super(toolMaterial, settings.apply(new Properties().attributes(createAttributes(toolMaterial, attackDamage, attackSpeed))));
    }
}
