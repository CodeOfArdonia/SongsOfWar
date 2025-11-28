package com.iafenvoy.sow.render.entity.feature;

import com.iafenvoy.neptune.compat.CuriosHelper;
import com.iafenvoy.sow.data.SkullManager;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.registry.SowBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PlayerHeadItem;

public final class ArdoniSkinHelper {
    public static ArdoniGraveItem.ArdoniData getMarkerTexture(Player player) {
        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        if (!(head.getItem() instanceof PlayerHeadItem))
            head = CuriosHelper.getEquippedForCosmetic(player).get(CuriosHelper.Place.HAT);
        if (head.getItem() instanceof PlayerHeadItem skull) {
            Tuple<ResourceLocation, Integer> pair = SkullManager.getMarkerTexture(skull);
            if (pair != null) return new ArdoniGraveItem.ArdoniData(pair.getA(), pair.getB());
        }
        if (head.is(SowBlocks.ARDONI_GRAVE.get().asItem()))
            return ArdoniGraveItem.resolveData(head);
        return null;
    }
}
