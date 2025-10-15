package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlayerHeadItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class SowSkulls {
    public static final DeferredRegister.Blocks BLOCK_REGISTRY = DeferredRegister.createBlocks(SongsOfWar.MOD_ID);
    public static final DeferredRegister.Items ITEM_REGISTRY = DeferredRegister.createItems(SongsOfWar.MOD_ID);

    public static final DeferredBlock<Block> ABBIGAIL_HEAD = register("abbigail_head", () -> new SkullBlock(SkullType.ABBIGAIL, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ABBIGAIL_WALL_HEAD = register("abbigail_wall_head", () -> new WallSkullBlock(SkullType.ABBIGAIL, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ACHILLEAN_HEAD = register("achillean_head", () -> new SkullBlock(SkullType.ACHILLEAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ACHILLEAN_WALL_HEAD = register("achillean_wall_head", () -> new WallSkullBlock(SkullType.ACHILLEAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> AEGUS_HEAD = register("aegus_head", () -> new SkullBlock(SkullType.AEGUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> AEGUS_WALL_HEAD = register("aegus_wall_head", () -> new WallSkullBlock(SkullType.AEGUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ALEC_HEAD = register("alec_head", () -> new SkullBlock(SkullType.ALEC, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ALEC_WALL_HEAD = register("alec_wall_head", () -> new WallSkullBlock(SkullType.ALEC, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ALLISTER_HEAD = register("allister_head", () -> new SkullBlock(SkullType.ALLISTER, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ALLISTER_WALL_HEAD = register("allister_wall_head", () -> new WallSkullBlock(SkullType.ALLISTER, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> AURELIUS_HEAD = register("aurelius_head", () -> new SkullBlock(SkullType.AURELIUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> AURELIUS_WALL_HEAD = register("aurelius_wall_head", () -> new WallSkullBlock(SkullType.AURELIUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> CHRONOS_HEAD = register("chronos_head", () -> new SkullBlock(SkullType.CHRONOS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> CHRONOS_WALL_HEAD = register("chronos_wall_head", () -> new WallSkullBlock(SkullType.CHRONOS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DARLENE_HEAD = register("darlene_head", () -> new SkullBlock(SkullType.DARLENE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DARLENE_WALL_HEAD = register("darlene_wall_head", () -> new WallSkullBlock(SkullType.DARLENE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DENNY_HEAD = register("denny_head", () -> new SkullBlock(SkullType.DENNY, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DENNY_WALL_HEAD = register("denny_wall_head", () -> new WallSkullBlock(SkullType.DENNY, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> EDDY_HEAD = register("eddy_head", () -> new SkullBlock(SkullType.EDDY, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> EDDY_WALL_HEAD = register("eddy_wall_head", () -> new WallSkullBlock(SkullType.EDDY, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> GALLEOUS_HEAD = register("galleous_head", () -> new SkullBlock(SkullType.GALLEOUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> GALLEOUS_WALL_HEAD = register("galleous_wall_head", () -> new WallSkullBlock(SkullType.GALLEOUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> GRIM_HEAD = register("grim_head", () -> new SkullBlock(SkullType.GRIM, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> GRIM_WALL_HEAD = register("grim_wall_head", () -> new WallSkullBlock(SkullType.GRIM, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HADION_HEAD = register("hadion_head", () -> new SkullBlock(SkullType.HADION, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HADION_WALL_HEAD = register("hadion_wall_head", () -> new WallSkullBlock(SkullType.HADION, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HAWKEN_HEAD = register("hawken_head", () -> new SkullBlock(SkullType.HAWKEN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HAWKEN_WALL_HEAD = register("hawken_wall_head", () -> new WallSkullBlock(SkullType.HAWKEN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HUBRIS_HEAD = register("hubris_head", () -> new SkullBlock(SkullType.HUBRIS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HUBRIS_WALL_HEAD = register("hubris_wall_head", () -> new WallSkullBlock(SkullType.HUBRIS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> IGNEOUS_HEAD = register("igneous_head", () -> new SkullBlock(SkullType.IGNEOUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> IGNEOUS_WALL_HEAD = register("igneous_wall_head", () -> new WallSkullBlock(SkullType.IGNEOUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> INGRESSSUS_HEAD = register("ingresssus_head", () -> new SkullBlock(SkullType.INGRESSSUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> INGRESSSUS_WALL_HEAD = register("ingresssus_wall_head", () -> new WallSkullBlock(SkullType.INGRESSSUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> JALKAR_HEAD = register("jalkar_head", () -> new SkullBlock(SkullType.JALKAR, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> JALKAR_WALL_HEAD = register("jalkar_wall_head", () -> new WallSkullBlock(SkullType.JALKAR, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> KIYOSHI_HEAD = register("kiyoshi_head", () -> new SkullBlock(SkullType.KIYOSHI, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> KIYOSHI_WALL_HEAD = register("kiyoshi_wall_head", () -> new WallSkullBlock(SkullType.KIYOSHI, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> LUCAN_HEAD = register("lucan_head", () -> new SkullBlock(SkullType.LUCAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> LUCAN_WALL_HEAD = register("lucan_wall_head", () -> new WallSkullBlock(SkullType.LUCAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> LUCIDIUS_HEAD = register("lucidius_head", () -> new SkullBlock(SkullType.LUCIDIUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> LUCIDIUS_WALL_HEAD = register("lucidius_wall_head", () -> new WallSkullBlock(SkullType.LUCIDIUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MARCUS_HEAD = register("marcus_head", () -> new SkullBlock(SkullType.MARCUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MARCUS_WALL_HEAD = register("marcus_wall_head", () -> new WallSkullBlock(SkullType.MARCUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MARSHALL_HEAD = register("marshall_head", () -> new SkullBlock(SkullType.MARSHALL, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MARSHALL_WALL_HEAD = register("marshall_wall_head", () -> new WallSkullBlock(SkullType.MARSHALL, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MASANI_HEAD = register("masani_head", () -> new SkullBlock(SkullType.MASANI, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MASANI_WALL_HEAD = register("masani_wall_head", () -> new WallSkullBlock(SkullType.MASANI, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MRFINCH_HEAD = register("mrfinch_head", () -> new SkullBlock(SkullType.MRFINCH, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MRFINCH_WALL_HEAD = register("mrfinch_wall_head", () -> new WallSkullBlock(SkullType.MRFINCH, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> NECROLORD_HEAD = register("necrolord_head", () -> new SkullBlock(SkullType.NECROLORD, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> NECROLORD_WALL_HEAD = register("necrolord_wall_head", () -> new WallSkullBlock(SkullType.NECROLORD, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> NIIKA_HEAD = register("niika_head", () -> new SkullBlock(SkullType.NIIKA, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> NIIKA_WALL_HEAD = register("niika_wall_head", () -> new WallSkullBlock(SkullType.NIIKA, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> NITSUKE_HEAD = register("nitsuke_head", () -> new SkullBlock(SkullType.NITSUKE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> NITSUKE_WALL_HEAD = register("nitsuke_wall_head", () -> new WallSkullBlock(SkullType.NITSUKE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> OSIVIAN_HEAD = register("osivian_head", () -> new SkullBlock(SkullType.OSIVIAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> OSIVIAN_WALL_HEAD = register("osivian_wall_head", () -> new WallSkullBlock(SkullType.OSIVIAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> PYTHUS_HEAD = register("pythus_head", () -> new SkullBlock(SkullType.PYTHUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> PYTHUS_WALL_HEAD = register("pythus_wall_head", () -> new WallSkullBlock(SkullType.PYTHUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RIA_HEAD = register("ria_head", () -> new SkullBlock(SkullType.RIA, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RIA_WALL_HEAD = register("ria_wall_head", () -> new WallSkullBlock(SkullType.RIA, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SAXON_HEAD = register("saxon_head", () -> new SkullBlock(SkullType.SAXON, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SAXON_WALL_HEAD = register("saxon_wall_head", () -> new WallSkullBlock(SkullType.SAXON, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SENN_HEAD = register("senn_head", () -> new SkullBlock(SkullType.SENN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SENN_WALL_HEAD = register("senn_wall_head", () -> new WallSkullBlock(SkullType.SENN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SIDERIAN_HEAD = register("siderian_head", () -> new SkullBlock(SkullType.SIDERIAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SIDERIAN_WALL_HEAD = register("siderian_wall_head", () -> new WallSkullBlock(SkullType.SIDERIAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SULLIMAN_HEAD = register("sulliman_head", () -> new SkullBlock(SkullType.SULLIMAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SULLIMAN_WALL_HEAD = register("sulliman_wall_head", () -> new WallSkullBlock(SkullType.SULLIMAN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> THALLEOUS_HEAD = register("thalleous_head", () -> new SkullBlock(SkullType.THALLEOUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> THALLEOUS_WALL_HEAD = register("thalleous_wall_head", () -> new WallSkullBlock(SkullType.THALLEOUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TREVOR_HEAD = register("trevor_head", () -> new SkullBlock(SkullType.TREVOR, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TREVOR_WALL_HEAD = register("trevor_wall_head", () -> new WallSkullBlock(SkullType.TREVOR, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TYGREN_HEAD = register("tygren_head", () -> new SkullBlock(SkullType.TYGREN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TYGREN_WALL_HEAD = register("tygren_wall_head", () -> new WallSkullBlock(SkullType.TYGREN, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> VAL_HEAD = register("val_head", () -> new SkullBlock(SkullType.VAL, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> VAL_WALL_HEAD = register("val_wall_head", () -> new WallSkullBlock(SkullType.VAL, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> VULCANNUS_HEAD = register("vulcannus_head", () -> new SkullBlock(SkullType.VULCANNUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> VULCANNUS_WALL_HEAD = register("vulcannus_wall_head", () -> new WallSkullBlock(SkullType.VULCANNUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> XARIA_HEAD = register("xaria_head", () -> new SkullBlock(SkullType.XARIA, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> XARIA_WALL_HEAD = register("xaria_wall_head", () -> new WallSkullBlock(SkullType.XARIA, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> YUJUKI_HEAD = register("yujuki_head", () -> new SkullBlock(SkullType.YUJUKI, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> YUJUKI_WALL_HEAD = register("yujuki_wall_head", () -> new WallSkullBlock(SkullType.YUJUKI, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ZINAIDA_HEAD = register("zinaida_head", () -> new SkullBlock(SkullType.ZINAIDA, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ZINAIDA_WALL_HEAD = register("zinaida_wall_head", () -> new WallSkullBlock(SkullType.ZINAIDA, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ZULIUS_HEAD = register("zulius_head", () -> new SkullBlock(SkullType.ZULIUS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ZULIUS_WALL_HEAD = register("zulius_wall_head", () -> new WallSkullBlock(SkullType.ZULIUS, BlockBehaviour.Properties.of()));

    public static final DeferredItem<Item> ABBIGAIL_HEAD_ITEM = register("abbigail", ABBIGAIL_HEAD, ABBIGAIL_WALL_HEAD);
    public static final DeferredItem<Item> ACHILLEAN_HEAD_ITEM = register("achillean", ACHILLEAN_HEAD, ACHILLEAN_WALL_HEAD);
    public static final DeferredItem<Item> AEGUS_HEAD_ITEM = register("aegus", AEGUS_HEAD, AEGUS_WALL_HEAD);
    public static final DeferredItem<Item> ALEC_HEAD_ITEM = register("alec", ALEC_HEAD, ALEC_WALL_HEAD);
    public static final DeferredItem<Item> ALLISTER_HEAD_ITEM = register("allister", ALLISTER_HEAD, ALLISTER_WALL_HEAD);
    public static final DeferredItem<Item> AURELIUS_HEAD_ITEM = register("aurelius", AURELIUS_HEAD, AURELIUS_WALL_HEAD);
    public static final DeferredItem<Item> CHRONOS_HEAD_ITEM = register("chronos", CHRONOS_HEAD, CHRONOS_WALL_HEAD);
    public static final DeferredItem<Item> DARLENE_HEAD_ITEM = register("darlene", DARLENE_HEAD, DARLENE_WALL_HEAD);
    public static final DeferredItem<Item> DENNY_HEAD_ITEM = register("denny", DENNY_HEAD, DENNY_WALL_HEAD);
    public static final DeferredItem<Item> EDDY_HEAD_ITEM = register("eddy", EDDY_HEAD, EDDY_WALL_HEAD);
    public static final DeferredItem<Item> GALLEOUS_HEAD_ITEM = register("galleous", GALLEOUS_HEAD, GALLEOUS_WALL_HEAD);
    public static final DeferredItem<Item> GRIM_HEAD_ITEM = register("grim", GRIM_HEAD, GRIM_WALL_HEAD);
    public static final DeferredItem<Item> HADION_HEAD_ITEM = register("hadion", HADION_HEAD, HADION_WALL_HEAD);
    public static final DeferredItem<Item> HAWKEN_HEAD_ITEM = register("hawken", HAWKEN_HEAD, HAWKEN_WALL_HEAD);
    public static final DeferredItem<Item> HUBRIS_HEAD_ITEM = register("hubris", HUBRIS_HEAD, HUBRIS_WALL_HEAD);
    public static final DeferredItem<Item> IGNEOUS_HEAD_ITEM = register("igneous", IGNEOUS_HEAD, IGNEOUS_WALL_HEAD);
    public static final DeferredItem<Item> INGRESSSUS_HEAD_ITEM = register("ingresssus", INGRESSSUS_HEAD, INGRESSSUS_WALL_HEAD);
    public static final DeferredItem<Item> JALKAR_HEAD_ITEM = register("jalkar", JALKAR_HEAD, JALKAR_WALL_HEAD);
    public static final DeferredItem<Item> KIYOSHI_HEAD_ITEM = register("kiyoshi", KIYOSHI_HEAD, KIYOSHI_WALL_HEAD);
    public static final DeferredItem<Item> LUCAN_HEAD_ITEM = register("lucan", LUCAN_HEAD, LUCAN_WALL_HEAD);
    public static final DeferredItem<Item> LUCIDIUS_HEAD_ITEM = register("lucidius", LUCIDIUS_HEAD, LUCIDIUS_WALL_HEAD);
    public static final DeferredItem<Item> MARCUS_HEAD_ITEM = register("marcus", MARCUS_HEAD, MARCUS_WALL_HEAD);
    public static final DeferredItem<Item> MARSHALL_HEAD_ITEM = register("marshall", MARSHALL_HEAD, MARSHALL_WALL_HEAD);
    public static final DeferredItem<Item> MASANI_HEAD_ITEM = register("masani", MASANI_HEAD, MASANI_WALL_HEAD);
    public static final DeferredItem<Item> MRFINCH_HEAD_ITEM = register("mrfinch", MRFINCH_HEAD, MRFINCH_WALL_HEAD);
    public static final DeferredItem<Item> NECROLORD_HEAD_ITEM = register("necrolord", NECROLORD_HEAD, NECROLORD_WALL_HEAD);
    public static final DeferredItem<Item> NIIKA_HEAD_ITEM = register("niika", NIIKA_HEAD, NIIKA_WALL_HEAD);
    public static final DeferredItem<Item> NITSUKE_HEAD_ITEM = register("nitsuke", NITSUKE_HEAD, NITSUKE_WALL_HEAD);
    public static final DeferredItem<Item> OSIVIAN_HEAD_ITEM = register("osivian", OSIVIAN_HEAD, OSIVIAN_WALL_HEAD);
    public static final DeferredItem<Item> PYTHUS_HEAD_ITEM = register("pythus", PYTHUS_HEAD, PYTHUS_WALL_HEAD);
    public static final DeferredItem<Item> RIA_HEAD_ITEM = register("ria", RIA_HEAD, RIA_WALL_HEAD);
    public static final DeferredItem<Item> SAXON_HEAD_ITEM = register("saxon", SAXON_HEAD, SAXON_WALL_HEAD);
    public static final DeferredItem<Item> SENN_HEAD_ITEM = register("senn", SENN_HEAD, SENN_WALL_HEAD);
    public static final DeferredItem<Item> SIDERIAN_HEAD_ITEM = register("siderian", SIDERIAN_HEAD, SIDERIAN_WALL_HEAD);
    public static final DeferredItem<Item> SULLIMAN_HEAD_ITEM = register("sulliman", SULLIMAN_HEAD, SULLIMAN_WALL_HEAD);
    public static final DeferredItem<Item> THALLEOUS_HEAD_ITEM = register("thalleous", THALLEOUS_HEAD, THALLEOUS_WALL_HEAD);
    public static final DeferredItem<Item> TREVOR_HEAD_ITEM = register("trevor", TREVOR_HEAD, TREVOR_WALL_HEAD);
    public static final DeferredItem<Item> TYGREN_HEAD_ITEM = register("tygren", TYGREN_HEAD, TYGREN_WALL_HEAD);
    public static final DeferredItem<Item> VAL_HEAD_ITEM = register("val", VAL_HEAD, VAL_WALL_HEAD);
    public static final DeferredItem<Item> VULCANNUS_HEAD_ITEM = register("vulcannus", VULCANNUS_HEAD, VULCANNUS_WALL_HEAD);
    public static final DeferredItem<Item> XARIA_HEAD_ITEM = register("xaria", XARIA_HEAD, XARIA_WALL_HEAD);
    public static final DeferredItem<Item> YUJUKI_HEAD_ITEM = register("yujuki", YUJUKI_HEAD, YUJUKI_WALL_HEAD);
    public static final DeferredItem<Item> ZINAIDA_HEAD_ITEM = register("zinaida", ZINAIDA_HEAD, ZINAIDA_WALL_HEAD);
    public static final DeferredItem<Item> ZULIUS_HEAD_ITEM = register("zulius", ZULIUS_HEAD, ZULIUS_WALL_HEAD);

    private static DeferredBlock<Block> register(String name, Supplier<Block> block) {
        return BLOCK_REGISTRY.register(name, block);
    }

    private static DeferredItem<Item> register(String name, Supplier<Block> head, Supplier<Block> wallHead) {
        return ITEM_REGISTRY.register(name + "_head", () -> new PlayerHeadItem(head.get(), wallHead.get(), new Item.Properties()));
    }

    public enum SkullType implements SkullBlock.Type {
        ABBIGAIL, ACHILLEAN, AEGUS, ALEC, ALLISTER, AURELIUS, CHRONOS, DARLENE, DENNY, EDDY, GALLEOUS, GRIM, HADION,
        HAWKEN, HUBRIS, IGNEOUS, INGRESSSUS, JALKAR, KIYOSHI, LUCAN, LUCIDIUS, MARCUS, MARSHALL, MASANI, MRFINCH, NECROLORD, NIIKA,
        NITSUKE, OSIVIAN, PYTHUS, RIA, SAXON, SENN, SIDERIAN, SULLIMAN, THALLEOUS, TREVOR, TYGREN, VAL,
        VULCANNUS, XARIA, YUJUKI, ZINAIDA, ZULIUS;

        @Override
        public @NotNull String getSerializedName() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }
}
