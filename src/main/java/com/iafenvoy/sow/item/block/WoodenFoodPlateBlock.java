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

public class WoodenFoodPlateBlock extends AbstractFoodPlateBlock<WoodenFoodPlateBlock.WoodenPlateFoodType> {
    private static final MapCodec<WoodenFoodPlateBlock> CODEC = simpleCodec(x -> new WoodenFoodPlateBlock());

    protected static final EnumProperty<WoodenPlateFoodType> FOOD_TYPE = EnumProperty.create("food_type", WoodenPlateFoodType.class);

    public WoodenFoodPlateBlock() {
        super(p -> p);
    }

    @Override
    protected EnumProperty<WoodenPlateFoodType> getFoodTypeProperty() {
        return FOOD_TYPE;
    }

    @Override
    protected WoodenPlateFoodType getDefaultFoodType() {
        return WoodenPlateFoodType.NONE;
    }

    @Override
    protected WoodenPlateFoodType getFoodTypeFromItem(Item item) {
        return Arrays.stream(WoodenPlateFoodType.values()).filter(x -> x.getItem() == item).findFirst().orElse(WoodenPlateFoodType.NONE);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Shapes.box(0, 0, 0, 1, 0.125, 1);
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    protected enum WoodenPlateFoodType implements FoodType {
        NONE("none", () -> Items.AIR, 0),
        PEAS_STRING("peas_string", SowDelight.PEAS_STRING, 3),
        PEAS_FLOUR_CAKE("peas_flour_cake", SowDelight.PEAS_FLOUR_CAKE, 4),
        PEAS_STEWIE("peas_stewie", SowDelight.PEAS_STEWIE, 4);

        private final String id;
        private final Supplier<Item> item;
        private final int maxPlacement;

        WoodenPlateFoodType(String id, Supplier<Item> item, int maxPlacement) {
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
