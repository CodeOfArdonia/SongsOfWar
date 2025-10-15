package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.render.SkullRenderRegistry;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.item.block.ArdoniGraveBlock;
import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.render.generator.ArdoniMarkerGenerator;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ArdoniGraveItem extends BlockItem implements SkullRenderRegistry.SkullTextureProvider {
    public ArdoniGraveItem(ArdoniGraveBlock block) {
        super(block, new Item.Properties());
    }

    public static ItemStack buildGrave(long seed, ArdoniType type, int age, boolean female) {
        CompoundTag nbt = new CompoundTag();
        nbt.putBoolean("fixed", false);
        nbt.putLong("seed", seed);
        nbt.putString("type", type.id());
        nbt.putInt("age", age);
        nbt.putBoolean("female", female);
        ItemStack stack = new ItemStack(SowBlocks.ARDONI_GRAVE.get());
        stack.set(DataComponents.BLOCK_ENTITY_DATA, CustomData.of(nbt));
        return stack;
    }

    public static ItemStack buildGrave(ResourceLocation texture, Color4i color) {
        CompoundTag nbt = new CompoundTag();
        nbt.putBoolean("fixed", true);
        nbt.putString("texturePath", texture.toString());
        nbt.putInt("color", color.getIntValue());
        ItemStack stack = new ItemStack(SowBlocks.ARDONI_GRAVE.get());
        stack.set(DataComponents.BLOCK_ENTITY_DATA, CustomData.of(nbt));
        return stack;
    }

    @Override
    public Optional<SkullRenderRegistry.SkinInfo> getTexture(ItemStack stack) {
        ArdoniData data = resolveData(stack);
        return Optional.of(new SkullRenderRegistry.SkinInfo(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_base%s.png".formatted(data != null && data.dark() ? "_dark" : "")), PlayerSkin.Model.WIDE));
    }

    @Nullable
    public static ArdoniData resolveData(ItemStack stack) {
        CustomData data = stack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (data == null) return null;
        CompoundTag nbt = data.copyTag();
        if (!nbt.contains("fixed", Tag.TAG_BYTE)) return null;
        boolean fixed = nbt.getBoolean("fixed");
        if (fixed)
            return new ArdoniData(nbt.getString("texturePath"), nbt.getInt("color"));
        else
            return new ArdoniData(nbt.getLong("seed"), ArdoniType.byId(nbt.getString("type")), nbt.getInt("age"), nbt.getBoolean("female"));
    }

    public record ArdoniData(boolean fixed, long seed, ResourceLocation marker, Color4i color, int age, boolean female,
                             boolean dark) {
        public ArdoniData(String texture, int color) {
            this(ResourceLocation.tryParse(texture), new Color4i(color));
        }

        public ArdoniData(ResourceLocation texture, Color4i color) {
            this(true, 0, texture, color, 0, false, false);
        }

        public ArdoniData(long seed, ArdoniType type, int age, boolean female) {
            this(false, seed, ArdoniMarkerGenerator.getOrCreate(seed).getForSkin(), type.getColor(seed), age, female, type.dark());
        }
    }
}
