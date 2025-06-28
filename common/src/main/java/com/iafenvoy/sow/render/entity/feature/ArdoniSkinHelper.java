package com.iafenvoy.sow.render.entity.feature;

import com.iafenvoy.neptune.accessory.AccessoryManager;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.data.SkullManager;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.registry.SowBlocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SkullItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

public final class ArdoniSkinHelper {
    public static ArdoniGraveItem.ArdoniData getMarkerTexture(PlayerEntity player) {
        ItemStack head = player.getEquippedStack(EquipmentSlot.HEAD);
        if (!(head.getItem() instanceof SkullItem))
            head = AccessoryManager.getEquipped(player, AccessoryManager.Place.HAT);
        if (head.getItem() instanceof SkullItem skull) {
            Pair<Identifier, Color4i> pair = SkullManager.getMarkerTexture(skull);
            if (pair != null) return new ArdoniGraveItem.ArdoniData(pair.getLeft(), pair.getRight());
        }
        if (head.isOf(SowBlocks.ARDONI_GRAVE.get().asItem()))
            return ArdoniGraveItem.resolveData(head);
        return null;
    }
}
