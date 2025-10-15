package com.iafenvoy.sow.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

import java.util.function.Function;

public class SowAxeItem extends AxeItem implements SowWeapon {
    public SowAxeItem(Tier toolMaterial, int attackDamage, float attackSpeed, Function<Properties, Properties> settings) {
        super(toolMaterial, settings.apply(new Properties().attributes(createAttributes(toolMaterial, attackDamage, attackSpeed))));
    }
}
