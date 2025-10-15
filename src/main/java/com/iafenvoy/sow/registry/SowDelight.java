package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.PeasCanItem;
import com.iafenvoy.sow.item.PeasDelightItem;
import com.iafenvoy.sow.item.block.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.Shapes;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class SowDelight {
    public static final DeferredRegister.Items ITEM_REGISTRY = DeferredRegister.createItems(SongsOfWar.MOD_ID);
    public static final DeferredRegister.Blocks BLOCK_REGISTRY = DeferredRegister.createBlocks(SongsOfWar.MOD_ID);

    public static final DeferredBlock<PeasBlock> PEAS = register("peas", PeasBlock::new, block -> new BlockItem(block, new Item.Properties()));
    public static final DeferredItem<Item> PEAS_CAN = register("peas_can", PeasCanItem::new);

    public static final DeferredBlock<Block> WOODEN_FOOD_PLATE = register("wooden_food_plate", WoodenFoodPlateBlock::new, b -> new BlockItem(b, new Item.Properties()));
    public static final DeferredItem<Item> PEAS_STRING = register("peas_string", () -> new PeasDelightItem(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.75f).fast().build())));
    public static final DeferredItem<Item> PEAS_FLOUR_CAKE = register("peas_flour_cake", () -> new PeasDelightItem(p -> p.food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f).build())));
    public static final DeferredItem<Item> PEAS_STEWIE = register("peas_stewie", () -> new PeasDelightItem(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.33f).build())));
    public static final DeferredBlock<Block> PEAS_PIE = register("peas_pie", PeasPieBlock::new, b -> new BlockItem(b, new Item.Properties()));
    public static final DeferredBlock<Block> PEAS_PIZZA = register("peas_pizza", PeasPizzaBlock::new, b -> new BlockItem(b, new Item.Properties()));
    public static final DeferredBlock<Block> PEAS_BURGER = register("peas_burger", () -> new SimplePickableFoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), Shapes.box(0, 0, 0, 1, 0.875, 1)), b -> new BlockItem(b, new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1).build())));
    public static final DeferredBlock<Block> PEAS_CAKE = register("peas_cake", () -> new SimplePickableFoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), Shapes.box(0.125, 0, 0.125, 0.875, 0.125, 0.875)), b -> new BlockItem(b, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.75f).build())));
    public static final DeferredBlock<Block> BAMBOO_FOOD_PLATE = register("bamboo_food_plate", BambooFoodPlateBlock::new, b -> new BlockItem(b, new Item.Properties()));
    public static final DeferredItem<Item> PEAS_STEAMED_STUFFED_BUN = register("peas_steamed_stuffed_bun", () -> new PeasDelightItem(p -> p.food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f).build())));
    public static final DeferredItem<Item> PEAS_PASTRY = register("peas_pastry", () -> new PeasDelightItem(p -> p.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.33f).build())));
    public static final DeferredItem<Item> PEAS_ICE_BAR = register("peas_ice_bar", () -> new PeasDelightItem(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.33f).build())));
    public static final DeferredItem<Item> PEAS_ICE_CREAM = register("peas_ice_cream", () -> new PeasDelightItem(p -> p.food(new FoodProperties.Builder().nutrition(4).saturationModifier(1).build())));
    public static final DeferredItem<Item> PEAS_MILK_TEA = register("peas_milk_tea", () -> new PeasDelightItem(p -> p.food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f).build())));

    private static <T extends Item> DeferredItem<T> register(String id, Supplier<T> obj) {
        return ITEM_REGISTRY.register(id, obj);
    }

    private static <T extends Block> DeferredBlock<T> register(String id, Supplier<T> obj, Function<Block, Item> itemConstructor) {
        DeferredBlock<T> r = BLOCK_REGISTRY.register(id, obj);
        ITEM_REGISTRY.register(id, () -> itemConstructor.apply(r.get()));
        return r;
    }
}
