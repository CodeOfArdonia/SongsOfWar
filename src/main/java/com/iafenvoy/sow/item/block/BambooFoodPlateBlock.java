package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.registry.SowDelight;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.Supplier;

public class BambooFoodPlateBlock extends AbstractFoodPlateBlock<BambooFoodPlateBlock.BambooPlateFoodType> {
    private static final MapCodec<BambooFoodPlateBlock> CODEC = simpleCodec(x -> new BambooFoodPlateBlock());
    protected static final EnumProperty<BambooPlateFoodType> FOOD_TYPE = EnumProperty.create("food_type", BambooPlateFoodType.class);

    public BambooFoodPlateBlock() {
        super(p -> p);
    }

    @Override
    protected EnumProperty<BambooPlateFoodType> getFoodTypeProperty() {
        return FOOD_TYPE;
    }

    @Override
    protected BambooPlateFoodType getDefaultFoodType() {
        return BambooPlateFoodType.NONE;
    }

    @Override
    protected BambooPlateFoodType getFoodTypeFromItem(Item item) {
        return Arrays.stream(BambooPlateFoodType.values()).filter(x -> x.getItem() == item).findFirst().orElse(BambooPlateFoodType.NONE);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Shapes.box(0.09375, 0, 0.09375, 0.90625, 0.125, 0.90625);
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    protected enum BambooPlateFoodType implements FoodType {
        NONE("none", () -> Items.AIR, 0),
        PEAS_STEAMED_STUFFED_BUN("peas_steamed_stuffed_bun", SowDelight.PEAS_STEAMED_STUFFED_BUN, 5),
        PEAS_PASTRY("peas_pastry", SowDelight.PEAS_PASTRY, 4);

        private final String id;
        private final Supplier<Item> item;
        private final int maxPlacement;

        BambooPlateFoodType(String id, Supplier<Item> item, int maxPlacement) {
            this.id = id;
            this.item = item;
            this.maxPlacement = maxPlacement;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.id;
        }

        @Override
        public Item getItem() {
            return this.item.get();
        }

        @Override
        public int getMaxPlacement() {
            return this.maxPlacement;
        }
    }
}
