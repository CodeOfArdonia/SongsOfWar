package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.render.SkullRenderRegistry;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.item.block.ArdoniGraveBlock;
import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowItemGroups;
import com.iafenvoy.sow.render.generator.ArdoniMarkerGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ArdoniGraveItem extends BlockItem implements SkullRenderRegistry.SkullTextureProvider {
    public ArdoniGraveItem(ArdoniGraveBlock block) {
        super(block, new Item.Settings().arch$tab(SowItemGroups.ITEMS));
    }

    public static ItemStack buildGrave(long seed, ArdoniType type, int age, boolean female) {
        NbtCompound nbt = new NbtCompound();
        nbt.putBoolean("fixed", false);
        nbt.putLong("seed", seed);
        nbt.putString("type", type.id());
        nbt.putInt("age", age);
        nbt.putBoolean("female", female);
        ItemStack stack = new ItemStack(SowBlocks.ARDONI_GRAVE.get());
        stack.setSubNbt("BlockEntityTag", nbt);
        return stack;
    }

    public static ItemStack buildGrave(Identifier texture, Color4i color) {
        NbtCompound nbt = new NbtCompound();
        nbt.putBoolean("fixed", true);
        nbt.putString("texturePath", texture.toString());
        nbt.putInt("color", color.getIntValue());
        ItemStack stack = new ItemStack(SowBlocks.ARDONI_GRAVE.get());
        stack.setSubNbt("BlockEntityTag", nbt);
        return stack;
    }

    @Override
    public Optional<Identifier> getTexture(ItemStack stack) {
        ArdoniData data = resolveData(stack);
        return Optional.ofNullable(Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_base%s.png".formatted(data != null && data.dark() ? "_dark" : "")));
    }

    @Nullable
    public static ArdoniData resolveData(ItemStack stack) {
        if (stack.getNbt() == null) return null;
        NbtCompound nbt = stack.getNbt().getCompound("BlockEntityTag");
        if (!nbt.contains("fixed", NbtElement.BYTE_TYPE)) return null;
        boolean fixed = nbt.getBoolean("fixed");
        if (fixed)
            return new ArdoniData(nbt.getString("texturePath"), nbt.getInt("color"));
        else
            return new ArdoniData(nbt.getLong("seed"), ArdoniType.byId(nbt.getString("type")), nbt.getInt("age"), nbt.getBoolean("female"));
    }

    public record ArdoniData(boolean fixed, long seed, Identifier marker, Color4i color, int age, boolean female,
                             boolean dark) {
        public ArdoniData(String texture, int color) {
            this(Identifier.tryParse(texture), new Color4i(color));
        }

        public ArdoniData(Identifier texture, Color4i color) {
            this(true, 0, texture, color, 0, false, false);
        }

        public ArdoniData(long seed, ArdoniType type, int age, boolean female) {
            this(false, seed, ArdoniMarkerGenerator.getOrCreate(seed).getForSkin(), type.getColor(seed), age, female, type.dark());
        }
    }
}
