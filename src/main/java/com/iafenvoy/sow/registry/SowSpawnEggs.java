package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.item.SowSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public final class SowSpawnEggs {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SongsOfWar.MOD_ID);
    //Misc
    public static final DeferredItem<SowSpawnEggItem> NONE_TYPE_ARDONI_SPAWN_EGG = REGISTRY.register("none_type_ardoni_spawn_egg", () -> ArdoniType.NONE.createSpawnEgg(SowEntities.NONE_TYPE_ARDONI));
    public static final DeferredItem<SowSpawnEggItem> VOLTARIS_ARDONI_SPAWN_EGG = REGISTRY.register("voltaris_ardoni_spawn_egg", () -> ArdoniType.VOLTARIS.createSpawnEgg(SowEntities.VOLTARIS_ARDONI));
    public static final DeferredItem<SowSpawnEggItem> SENDARIS_ARDONI_SPAWN_EGG = REGISTRY.register("sendaris_ardoni_spawn_egg", () -> ArdoniType.SENDARIS.createSpawnEgg(SowEntities.SENDARIS_ARDONI));
    public static final DeferredItem<SowSpawnEggItem> NESTORIS_ARDONI_SPAWN_EGG = REGISTRY.register("nestoris_ardoni_spawn_egg", () -> ArdoniType.NESTORIS.createSpawnEgg(SowEntities.NESTORIS_ARDONI));
    public static final DeferredItem<SowSpawnEggItem> KALTARIS_ARDONI_SPAWN_EGG = REGISTRY.register("kaltaris_ardoni_spawn_egg", () -> ArdoniType.KALTARIS.createSpawnEgg(SowEntities.KALTARIS_ARDONI));
    public static final DeferredItem<SowSpawnEggItem> MENDORIS_ARDONI_SPAWN_EGG = REGISTRY.register("mendoris_ardoni_spawn_egg", () -> ArdoniType.MENDORIS.createSpawnEgg(SowEntities.MENDORIS_ARDONI));
    public static final DeferredItem<SowSpawnEggItem> GRIM_SPAWN_EGG = REGISTRY.register("grim_spawn_egg", SowSpawnEggItem.create(SowEntities.GRIM, 0xFF444444, 0xFF00FFFF));
    public static final DeferredItem<SowSpawnEggItem> GLACIAN_SPAWN_EGG = REGISTRY.register("glacian_spawn_egg", SowSpawnEggItem.create(SowEntities.GLACIAN, 0xFF1FFFFF, 0xFFFFFFFF));
    //Ardoni
    public static final DeferredItem<SowSpawnEggItem> ACHILLEAN_SPAWN_EGG = REGISTRY.register("achillean_spawn_egg", SowSpawnEggItem.create(SowEntities.ACHILLEAN, 0xFF888888, 0xFFFFFF00));
    public static final DeferredItem<SowSpawnEggItem> INGRESSSUS_SPAWN_EGG = REGISTRY.register("ingresssus_spawn_egg", SowSpawnEggItem.create(SowEntities.INGRESSSUS, 0xFF444444, 0xFFF05C4F));
    public static final DeferredItem<SowSpawnEggItem> AEGUS_SPAWN_EGG = REGISTRY.register("aegus_spawn_egg", SowSpawnEggItem.create(SowEntities.AEGUS, 0xFF444444, 0xFFFEE575));
    public static final DeferredItem<SowSpawnEggItem> KALTARIS_MASTER_SPAWN_EGG = REGISTRY.register("kaltaris_master_spawn_egg", SowSpawnEggItem.create(SowEntities.KALTARIS_MASTER, 0xFF444444, 0xFF65CD6B));
    public static final DeferredItem<SowSpawnEggItem> MENDORIS_MASTER_SPAWN_EGG = REGISTRY.register("mendoris_master_spawn_egg", SowSpawnEggItem.create(SowEntities.MENDORIS_MASTER, 0xFF444444, 0xFF7F7FFF));
    public static final DeferredItem<SowSpawnEggItem> SENDARIS_MASTER_SPAWN_EGG = REGISTRY.register("sendaris_master_spawn_egg", SowSpawnEggItem.create(SowEntities.SENDARIS_MASTER, 0xFF666666, 0xFF00FFFF));
    public static final DeferredItem<SowSpawnEggItem> HUBRIS_SPAWN_EGG = REGISTRY.register("hubris_spawn_egg", SowSpawnEggItem.create(SowEntities.HUBRIS, 0xFF888888, 0xFFFFFF00));
    public static final DeferredItem<SowSpawnEggItem> RIA_SPAWN_EGG = REGISTRY.register("ria_spawn_egg", SowSpawnEggItem.create(SowEntities.RIA, 0xFFAAAAAA, 0xFF88F1FF));
    public static final DeferredItem<SowSpawnEggItem> THALLEOUS_SPAWN_EGG = REGISTRY.register("thalleous_spawn_egg", SowSpawnEggItem.create(SowEntities.THALLEOUS, 0xFF888888, 0xFF00A2E8));
    public static final DeferredItem<SowSpawnEggItem> GALLEOUS_SPAWN_EGG = REGISTRY.register("galleous_spawn_egg", SowSpawnEggItem.create(SowEntities.GALLEOUS, 0xFF888888, 0xFF00A2E8));
    public static final DeferredItem<SowSpawnEggItem> SENN_SPAWN_EGG = REGISTRY.register("senn_spawn_egg", SowSpawnEggItem.create(SowEntities.SENN, 0xFF888888, 0xFFFFFFFF));
    public static final DeferredItem<SowSpawnEggItem> ZULIUS_SPAWN_EGG = REGISTRY.register("zulius_spawn_egg", SowSpawnEggItem.create(SowEntities.ZULIUS, 0xFF444444, 0xFF00FF00));
    public static final DeferredItem<SowSpawnEggItem> TYGREN_SPAWN_EGG = REGISTRY.register("tygren_spawn_egg", SowSpawnEggItem.create(SowEntities.TYGREN, 0xFF444444, 0xFFFF0000));
    public static final DeferredItem<SowSpawnEggItem> OSIVIAN_SPAWN_EGG = REGISTRY.register("osivian_spawn_egg", SowSpawnEggItem.create(SowEntities.OSIVIAN, 0xFF888888, 0xFF479AED));
    public static final DeferredItem<SowSpawnEggItem> LUCIDIUS_SPAWN_EGG = REGISTRY.register("lucidius_spawn_egg", SowSpawnEggItem.create(SowEntities.LUCIDIUS, 0xFF444444, 0xFFD15E5F));
    public static final DeferredItem<SowSpawnEggItem> ZINAIDA_SPAWN_EGG = REGISTRY.register("zinaida_spawn_egg", SowSpawnEggItem.create(SowEntities.ZINAIDA, 0xFF444444, 0xFFD15E5F));
    public static final DeferredItem<SowSpawnEggItem> AURELIUS_SPAWN_EGG = REGISTRY.register("aurelius_spawn_egg", SowSpawnEggItem.create(SowEntities.AURELIUS, 0xFF888888, 0xFFE3BC00));
    public static final DeferredItem<SowSpawnEggItem> HADION_SPAWN_EGG = REGISTRY.register("hadion_spawn_egg", SowSpawnEggItem.create(SowEntities.HADION, 0xFF444444, 0xFFE794FF));
    public static final DeferredItem<SowSpawnEggItem> VAL_SPAWN_EGG = REGISTRY.register("val_spawn_egg", SowSpawnEggItem.create(SowEntities.VAL, 0xFFAAAAAA, 0xFFFFA8F9));
    public static final DeferredItem<SowSpawnEggItem> SIDERIAN_SPAWN_EGG = REGISTRY.register("siderian_spawn_egg", SowSpawnEggItem.create(SowEntities.SIDERIAN, 0xFF888888, 0xFFcf6fcc));
    //Felina
    public static final DeferredItem<SowSpawnEggItem> FELDEN_SPAWN_EGG = REGISTRY.register("felden_spawn_egg", SowSpawnEggItem.create(SowEntities.FELDEN, 0xFF444444, 0xFFf9d4c9));
    public static final DeferredItem<SowSpawnEggItem> KIYOSHI_SPAWN_EGG = REGISTRY.register("kiyoshi_spawn_egg", SowSpawnEggItem.create(SowEntities.KIYOSHI, 0xFF006400, 0xFFf9d4c9));
    public static final DeferredItem<SowSpawnEggItem> NIIKA_SPAWN_EGG = REGISTRY.register("niika_spawn_egg", SowSpawnEggItem.create(SowEntities.NIIKA, 0xFF444444, 0xFFa52a2a));
    public static final DeferredItem<SowSpawnEggItem> MASANI_SPAWN_EGG = REGISTRY.register("masani_spawn_egg", SowSpawnEggItem.create(SowEntities.MASANI, 0xFFc80000, 0xFF6b357a));
    public static final DeferredItem<SowSpawnEggItem> NITSUKE_SPAWN_EGG = REGISTRY.register("nitsuke_spawn_egg", SowSpawnEggItem.create(SowEntities.NITSUKE, 0xFF6b2000, 0xFFffb1b1));
    public static final DeferredItem<SowSpawnEggItem> YUJUKI_SPAWN_EGG = REGISTRY.register("yujuki_spawn_egg", SowSpawnEggItem.create(SowEntities.YUJUKI, 0xFF125572, 0xFFf7ffff));
    //Human
    public static final DeferredItem<SowSpawnEggItem> ABBIGAIL_SPAWN_EGG = REGISTRY.register("abbigail_spawn_egg", SowSpawnEggItem.create(SowEntities.ABBIGAIL, 0xFFa52a2a, 0xFF301934));
    public static final DeferredItem<SowSpawnEggItem> ALEC_SPAWN_EGG = REGISTRY.register("alec_spawn_egg", SowSpawnEggItem.create(SowEntities.ALEC, 0xFF444444, 0xFFf9d4c9));
    public static final DeferredItem<SowSpawnEggItem> BARTENDER_SPAWN_EGG = REGISTRY.register("bartender_spawn_egg", SowSpawnEggItem.create(SowEntities.BARTENDER, 0xFF05243e, 0xFF575008));
    public static final DeferredItem<SowSpawnEggItem> CIVILIAN_SPAWN_EGG = REGISTRY.register("civilian_spawn_egg", SowSpawnEggItem.create(SowEntities.CIVILIAN, 0xFF345758, 0xFFd9d4b2));
    public static final DeferredItem<SowSpawnEggItem> DARLENE_SPAWN_EGG = REGISTRY.register("darlene_spawn_egg", SowSpawnEggItem.create(SowEntities.DARLENE, 0xFF3f2b20, 0xFFe0b476));
    public static final DeferredItem<SowSpawnEggItem> EDDY_SPAWN_EGG = REGISTRY.register("eddy_spawn_egg", SowSpawnEggItem.create(SowEntities.EDDY, 0xFF28231c, 0xFFf2cba8));
    public static final DeferredItem<SowSpawnEggItem> HAWKEN_SPAWN_EGG = REGISTRY.register("hawken_spawn_egg", SowSpawnEggItem.create(SowEntities.HAWKEN, 0xFF53464f, 0xFF3f332b));
    public static final DeferredItem<SowSpawnEggItem> HORSE_RIDER_SPAWN_EGG = REGISTRY.register("horse_rider_spawn_egg", SowSpawnEggItem.create(SowEntities.HORSE_RIDER, 0xFF152c43, 0xFFb7928c));
    public static final DeferredItem<SowSpawnEggItem> LUCAN_SPAWN_EGG = REGISTRY.register("lucan_spawn_egg", SowSpawnEggItem.create(SowEntities.LUCAN, 0xFF5e4941, 0xFFf0bf85));
    public static final DeferredItem<SowSpawnEggItem> MARCUS_SPAWN_EGG = REGISTRY.register("marcus_spawn_egg", SowSpawnEggItem.create(SowEntities.MARCUS, 0xFF5e4941, 0xFF2c1308));
    public static final DeferredItem<SowSpawnEggItem> MARSHALL_SPAWN_EGG = REGISTRY.register("marshall_spawn_egg", SowSpawnEggItem.create(SowEntities.MARSHALL, 0xFF53171f, 0xFFc88e71));
    public static final DeferredItem<SowSpawnEggItem> MRFINCH_SPAWN_EGG = REGISTRY.register("mrfinch_spawn_egg", SowSpawnEggItem.create(SowEntities.MRFINCH, 0xFF8f652c, 0xFFFFFFFF));
    public static final DeferredItem<SowSpawnEggItem> SULLIMAN_SPAWN_EGG = REGISTRY.register("sulliman_spawn_egg", SowSpawnEggItem.create(SowEntities.SULLIMAN, 0xFF480c09, 0xFF210e08));
    public static final DeferredItem<SowSpawnEggItem> ALLISTER_SPAWN_EGG = REGISTRY.register("allister_spawn_egg", SowSpawnEggItem.create(SowEntities.ALLISTER, 0xFF1e4ba0, 0xFFe8d06d));
    public static final DeferredItem<SowSpawnEggItem> DENNY_SPAWN_EGG = REGISTRY.register("denny_spawn_egg", SowSpawnEggItem.create(SowEntities.DENNY, 0xFF252c36, 0xFFc66328));
    public static final DeferredItem<SowSpawnEggItem> JALKAR_SPAWN_EGG = REGISTRY.register("jalkar_spawn_egg", SowSpawnEggItem.create(SowEntities.JALKAR, 0xFF050000, 0xFFa83524));
    public static final DeferredItem<SowSpawnEggItem> SAXON_SPAWN_EGG = REGISTRY.register("saxon_spawn_egg", SowSpawnEggItem.create(SowEntities.SAXON, 0xFF092631, 0xFF47392e));
    public static final DeferredItem<SowSpawnEggItem> TREVOR_SPAWN_EGG = REGISTRY.register("trevor_spawn_egg", SowSpawnEggItem.create(SowEntities.TREVOR, 0xFF746a4c, 0xFF0f0f0f));
    //Magnorite
    public static final DeferredItem<SowSpawnEggItem> IGNEOUS_SPAWN_EGG = REGISTRY.register("igneous_spawn_egg", SowSpawnEggItem.create(SowEntities.IGNEOUS, 0xFF444444, 0xFFFF0000));
    public static final DeferredItem<SowSpawnEggItem> MAGNORITE_SPAWN_EGG = REGISTRY.register("magnorite_spawn_egg", SowSpawnEggItem.create(SowEntities.MAGNORITE, 0xFF444444, 0xFFFF0000));
    //Necromancer
    public static final DeferredItem<SowSpawnEggItem> NECROMANCER_SPAWN_EGG = REGISTRY.register("necromancer_spawn_egg", SowSpawnEggItem.create(SowEntities.NECROMANCER, 0xFF222222, 0xFFBBBBBB));
    public static final DeferredItem<SowSpawnEggItem> NECROLORD_SPAWN_EGG = REGISTRY.register("necrolord_spawn_egg", SowSpawnEggItem.create(SowEntities.NECROLORD, 0xFF222222, 0xFFBBBBBB));
    public static final DeferredItem<SowSpawnEggItem> XARIA_SPAWN_EGG = REGISTRY.register("xaria_spawn_egg", SowSpawnEggItem.create(SowEntities.XARIA, 0xFF222222, 0xFFBBBBBB));
    //Netheran
    public static final DeferredItem<SowSpawnEggItem> NETHARAN_SPAWN_EGG = REGISTRY.register("netharan_spawn_egg", SowSpawnEggItem.create(SowEntities.NETHARAN, 0xFF222222, 0xFFFF0000));
    public static final DeferredItem<SowSpawnEggItem> CHRONOS_SPAWN_EGG = REGISTRY.register("chronos_spawn_egg", SowSpawnEggItem.create(SowEntities.CHRONOS, 0xFF222222, 0xFFFF0000));
    public static final DeferredItem<SowSpawnEggItem> PYTHUS_SPAWN_EGG = REGISTRY.register("pythus_spawn_egg", SowSpawnEggItem.create(SowEntities.PYTHUS, 0xFF222222, 0xFFd6350f));
    public static final DeferredItem<SowSpawnEggItem> VULCANNUS_SPAWN_EGG = REGISTRY.register("vulcannus_spawn_egg", SowSpawnEggItem.create(SowEntities.VULCANNUS, 0xFF222222, 0xFFd6350f));
    //Zombie
    public static final DeferredItem<SowSpawnEggItem> HUSK_SPAWN_EGG = REGISTRY.register("husk_spawn_egg", SowSpawnEggItem.create(SowEntities.HUSK, 7958625, 15125652));
    public static final DeferredItem<SowSpawnEggItem> STRAY_SPAWN_EGG = REGISTRY.register("stray_spawn_egg", SowSpawnEggItem.create(SowEntities.STRAY, 6387319, 14543594));
    public static final DeferredItem<SowSpawnEggItem> ZOMBIE_SPAWN_EGG = REGISTRY.register("zombie_spawn_egg", SowSpawnEggItem.create(SowEntities.ZOMBIE, 44975, 7969893));
    //Guard
    public static final DeferredItem<SowSpawnEggItem> CONCHORD_GUARD_SPAWN_EGG = REGISTRY.register("conchord_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.CONCHORD_GUARD, 0xff4a2e1d, 0xff575757));
    public static final DeferredItem<SowSpawnEggItem> CROWN_GUARD_PEAK_SPAWN_EGG = REGISTRY.register("crown_peak_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.CROWN_PEAK_GUARD, 0xffd9d8d9, 0xff30210e));
    public static final DeferredItem<SowSpawnEggItem> CYDONIA_GUARD_SPAWN_EGG = REGISTRY.register("cydonia_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.CYDONIA_GUARD, 0xffab6117, 0xff403a34));
    public static final DeferredItem<SowSpawnEggItem> ETHEREA_GUARD_SPAWN_EGG = REGISTRY.register("etherea_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.ETHEREA_GUARD, 0xff2b3d8d, 0xff342a21));
    public static final DeferredItem<SowSpawnEggItem> FELDEN_GUARD_SPAWN_EGG = REGISTRY.register("felden_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.FELDEN_GUARD, 0xff3e372f, 0xff914f2f));
    public static final DeferredItem<SowSpawnEggItem> GENERAL_GUARD_SPAWN_EGG = REGISTRY.register("general_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.GENERAL_GUARD, 0xffbcc5cc, 0xff121212));
    public static final DeferredItem<SowSpawnEggItem> HYDRAPHEL_GUARD_SPAWN_EGG = REGISTRY.register("hydraphel_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.HYDRAPHEL_GUARD, 0xffebedf1, 0xff823a04));
    public static final DeferredItem<SowSpawnEggItem> KARTHEN_GUARD_SPAWN_EGG = REGISTRY.register("karthen_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.KARTHEN_GUARD, 0xff2a2a2a, 0xff4a3f31));
    public static final DeferredItem<SowSpawnEggItem> NORTHWIND_GUARD_SPAWN_EGG = REGISTRY.register("northwind_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.NORTHWIND_GUARD, 0xff09417f, 0xffeec79a));
    //Soldier
    public static final DeferredItem<SowSpawnEggItem> CONCHORD_SOLDIER_SPAWN_EGG = REGISTRY.register("conchord_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.CONCHORD_SOLDIER, 0xff4a2e1d, 0xff575757));
    public static final DeferredItem<SowSpawnEggItem> CROWN_SOLDIER_PEAK_SPAWN_EGG = REGISTRY.register("crown_peak_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.CROWN_PEAK_SOLDIER, 0xffd9d8d9, 0xff30210e));
    public static final DeferredItem<SowSpawnEggItem> CYDONIA_SOLDIER_SPAWN_EGG = REGISTRY.register("cydonia_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.CYDONIA_SOLDIER, 0xffab6117, 0xff403a34));
    public static final DeferredItem<SowSpawnEggItem> ETHEREA_SOLDIER_SPAWN_EGG = REGISTRY.register("etherea_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.ETHEREA_SOLDIER, 0xff2b3d8d, 0xff342a21));
    public static final DeferredItem<SowSpawnEggItem> FELDEN_SOLDIER_SPAWN_EGG = REGISTRY.register("felden_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.FELDEN_SOLDIER, 0xff3e372f, 0xff914f2f));
    public static final DeferredItem<SowSpawnEggItem> HYDRAPHEL_SOLDIER_SPAWN_EGG = REGISTRY.register("hydraphel_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.HYDRAPHEL_SOLDIER, 0xffebedf1, 0xff823a04));
    public static final DeferredItem<SowSpawnEggItem> NORTHWIND_SOLDIER_SPAWN_EGG = REGISTRY.register("northwind_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.NORTHWIND_SOLDIER, 0xff09417f, 0xffeec79a));
    //Townsfolk
    public static final DeferredItem<SowSpawnEggItem> ADVENTURER_FOLK_SPAWN_EGG = REGISTRY.register("adventurer_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.ADVENTURER_FOLK, 0xff326b88, 0xff8b5a3b));
    public static final DeferredItem<SowSpawnEggItem> BLACKSMITH_FOLK_SPAWN_EGG = REGISTRY.register("blacksmith_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.BLACKSMITH_FOLK, 0xff4c4441, 0xff3e2305));
    public static final DeferredItem<SowSpawnEggItem> CHEF_FOLK_SPAWN_EGG = REGISTRY.register("chef_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.CHEF_FOLK, 0xff384200, 0xff1a1a1a));
    public static final DeferredItem<SowSpawnEggItem> FARMER_FOLK_SPAWN_EGG = REGISTRY.register("farmer_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.FARMER_FOLK, 0xff543e3b, 0xffca9668));
    public static final DeferredItem<SowSpawnEggItem> FEMALE_FOLK_SPAWN_EGG = REGISTRY.register("female_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.FEMALE_FOLK, 0xfffec38f, 0xff66462e));
    public static final DeferredItem<SowSpawnEggItem> FISHER_FOLK_SPAWN_EGG = REGISTRY.register("fisher_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.FISHER_FOLK, 0xff1f1c16, 0xff6f5b38));
    public static final DeferredItem<SowSpawnEggItem> LEATHER_WORKER_FOLK_SPAWN_EGG = REGISTRY.register("leather_worker_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.LEATHER_WORKER_FOLK, 0xff021c02, 0xff543013));
    public static final DeferredItem<SowSpawnEggItem> MALE_FOLK_SPAWN_EGG = REGISTRY.register("male_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.MALE_FOLK, 0xff5e4139, 0xff251d15));
    public static final DeferredItem<SowSpawnEggItem> MERCHANT_FOLK_SPAWN_EGG = REGISTRY.register("merchant_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.MERCHANT_FOLK, 0xff1d1d1d, 0xff3e2d25));
    public static final DeferredItem<SowSpawnEggItem> MINER_FOLK_SPAWN_EGG = REGISTRY.register("miner_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.MINER_FOLK, 0xff624430, 0xffe59a65));
    public static final DeferredItem<SowSpawnEggItem> OLD_FOLK_SPAWN_EGG = REGISTRY.register("old_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.OLD_FOLK, 0xff7c6247, 0xfffdc997));
    public static final DeferredItem<SowSpawnEggItem> POOL_FOLK_SPAWN_EGG = REGISTRY.register("poor_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.POOR_FOLK, 0xff9f8e6e, 0xff53483d));
    public static final DeferredItem<SowSpawnEggItem> SAILOR_FOLK_SPAWN_EGG = REGISTRY.register("sailor_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.SAILOR_FOLK, 0xff314670, 0xff212121));
    public static final DeferredItem<SowSpawnEggItem> SCHOLAR_FOLK_SPAWN_EGG = REGISTRY.register("scholar_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.SCHOLAR_FOLK, 0xff2f0c00, 0xff626262));
}
