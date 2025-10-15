package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.util.EntityBuildHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.GlacianEntity;
import com.iafenvoy.sow.entity.GrimEntity;
import com.iafenvoy.sow.entity.ardoni.*;
import com.iafenvoy.sow.entity.ardoni.random.*;
import com.iafenvoy.sow.entity.felina.*;
import com.iafenvoy.sow.entity.human.*;
import com.iafenvoy.sow.entity.human.guard.*;
import com.iafenvoy.sow.entity.human.soldier.*;
import com.iafenvoy.sow.entity.human.townsfolk.*;
import com.iafenvoy.sow.entity.magnorite.IgneousEntity;
import com.iafenvoy.sow.entity.magnorite.MagnoriteEntity;
import com.iafenvoy.sow.entity.necromancer.NecrolordEntity;
import com.iafenvoy.sow.entity.necromancer.NecromancerEntity;
import com.iafenvoy.sow.entity.necromancer.XariaEntity;
import com.iafenvoy.sow.entity.netharan.ChronosEntity;
import com.iafenvoy.sow.entity.netharan.NetharanEntity;
import com.iafenvoy.sow.entity.netharan.PythusEntity;
import com.iafenvoy.sow.entity.netharan.VulcannusEntity;
import com.iafenvoy.sow.entity.power.*;
import com.iafenvoy.sow.entity.zombie.SowHuskEntity;
import com.iafenvoy.sow.entity.zombie.SowStrayEntity;
import com.iafenvoy.sow.entity.zombie.SowZombieEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber
public final class SowEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, SongsOfWar.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<AggroSphereEntity>> AGGRO_SPHERE = build("aggro_sphere", AggroSphereEntity::new, MobCategory.MISC, 64, 1, false, new EntityBuildHelper.Dimension(0.5F, 0.5F));
    public static final DeferredHolder<EntityType<?>, EntityType<AggroDetonateEntity>> AGGRO_DETONATE = build("aggro_detonate", AggroDetonateEntity::new, MobCategory.MISC, 64, 1, false, new EntityBuildHelper.Dimension(0.5F, 0.5F));
    public static final DeferredHolder<EntityType<?>, EntityType<AggroShardEntity>> AGGRO_SHARD = build("aggro_shard", AggroShardEntity::new, MobCategory.MISC, 64, 1, false, new EntityBuildHelper.Dimension(0.2F, 0.2F));
    public static final DeferredHolder<EntityType<?>, EntityType<ProteCloneEntity>> PROTE_CLONE = build("prote_clone", ProteCloneEntity::new, MobCategory.MISC, 64, 1, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<SupporoSpikeEntity>> SUPPORO_SPIKE = build("supporo_spike", SupporoSpikeEntity::new, MobCategory.MISC, 64, 1, false, new EntityBuildHelper.Dimension(1, 1));
    //Misc
    public static final DeferredHolder<EntityType<?>, EntityType<NoneTypeArdoniEntity>> NONE_TYPE_ARDONI = build("none_type_ardoni", NoneTypeArdoniEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<KaltarisArdoniEntity>> KALTARIS_ARDONI = build("kaltaris_ardoni", KaltarisArdoniEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<MendorisArdoniEntity>> MENDORIS_ARDONI = build("mendoris_ardoni", MendorisArdoniEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<NestorisArdoniEntity>> NESTORIS_ARDONI = build("nestoris_ardoni", NestorisArdoniEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<SendarisArdoniEntity>> SENDARIS_ARDONI = build("sendaris_ardoni", SendarisArdoniEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<VoltarisArdoniEntity>> VOLTARIS_ARDONI = build("voltaris_ardoni", VoltarisArdoniEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<GrimEntity>> GRIM = build("grim", GrimEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<GlacianEntity>> GLACIAN = build("glacian", GlacianEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(0.8f));
    //Ardoni
    public static final DeferredHolder<EntityType<?>, EntityType<AchilleanEntity>> ACHILLEAN = build("achillean", AchilleanEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<IngresssusEntity>> INGRESSSUS = build("ingresssus", IngresssusEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<AegusEntity>> AEGUS = build("aegus", AegusEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<KaltarisMasterEntity>> KALTARIS_MASTER = build("kaltaris_master", KaltarisMasterEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<MendorisMasterEntity>> MENDORIS_MASTER = build("mendoris_master", MendorisMasterEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<SendarisMasterEntity>> SENDARIS_MASTER = build("sendaris_master", SendarisMasterEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<HubrisEntity>> HUBRIS = build("hubris", HubrisEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<RiaEntity>> RIA = build("ria", RiaEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<ThalleousEntity>> THALLEOUS = build("thalleous", ThalleousEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<GalleousEntity>> GALLEOUS = build("galleous", GalleousEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<SennEntity>> SENN = build("senn", SennEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<ZuliusEntity>> ZULIUS = build("zulius", ZuliusEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<TygrenEntity>> TYGREN = build("tygren", TygrenEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<OsivianEntity>> OSIVIAN = build("osivian", OsivianEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<LucidiusEntity>> LUCIDIUS = build("lucidius", LucidiusEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<ZinaidaEntity>> ZINAIDA = build("zinaida", ZinaidaEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<AureliusEntity>> AURELIUS = build("aurelius", AureliusEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<HadionEntity>> HADION = build("hadion", HadionEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<ValEntity>> VAL = build("val", ValEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final DeferredHolder<EntityType<?>, EntityType<SiderianEntity>> SIDERIAN = build("siderian", SiderianEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    //Felina
    public static final DeferredHolder<EntityType<?>, EntityType<FeldenEntity>> FELDEN = build("felden", FeldenEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.05f));
    public static final DeferredHolder<EntityType<?>, EntityType<KiyoshiEntity>> KIYOSHI = build("kiyoshi", KiyoshiEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.05f));
    public static final DeferredHolder<EntityType<?>, EntityType<NiikaEntity>> NIIKA = build("niika", NiikaEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(0.95f));
    public static final DeferredHolder<EntityType<?>, EntityType<MasaniEntity>> MASANI = build("masani", MasaniEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(0.95f));
    public static final DeferredHolder<EntityType<?>, EntityType<NitsukeEntity>> NITSUKE = build("nitsuke", NitsukeEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(0.95f));
    public static final DeferredHolder<EntityType<?>, EntityType<YujukiEntity>> YUJUKI = build("yujuki", YujukiEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(0.95f));
    //Human
    public static final DeferredHolder<EntityType<?>, EntityType<AbbigailEntity>> ABBIGAIL = build("abbigail", AbbigailEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<AlecEntity>> ALEC = build("alec", AlecEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<BartenderEntity>> BARTENDER = build("bartender", BartenderEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<CivilianEntity>> CIVILIAN = build("civilian", CivilianEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<DarleneEntity>> DARLENE = build("darlene", DarleneEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<EddyEntity>> EDDY = build("eddy", EddyEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<HawkenEntity>> HAWKEN = build("hawken", HawkenEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<HorseRiderEntity>> HORSE_RIDER = build("horse_rider", HorseRiderEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<LucanEntity>> LUCAN = build("lucan", LucanEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<MarcusEntity>> MARCUS = build("marcus", MarcusEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<MarshallEntity>> MARSHALL = build("marchall", MarshallEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<MrfinchEntity>> MRFINCH = build("mrfinch", MrfinchEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<SullimanEntity>> SULLIMAN = build("sulliman", SullimanEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<AllisterEntity>> ALLISTER = build("allister", AllisterEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<DennyEntity>> DENNY = build("denny", DennyEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<JalkarEntity>> JALKAR = build("jalkar", JalkarEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<SaxonEntity>> SAXON = build("saxon", SaxonEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<TrevorEntity>> TREVOR = build("trevor", TrevorEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Magnorite
    public static final DeferredHolder<EntityType<?>, EntityType<IgneousEntity>> IGNEOUS = build("igneous", IgneousEntity::new, MobCategory.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.2f));
    public static final DeferredHolder<EntityType<?>, EntityType<MagnoriteEntity>> MAGNORITE = build("magnorite", MagnoriteEntity::new, MobCategory.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.2f));
    //Necromancer
    public static final DeferredHolder<EntityType<?>, EntityType<NecromancerEntity>> NECROMANCER = build("necromancer", NecromancerEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<NecrolordEntity>> NECROLORD = build("necrolord", NecrolordEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<XariaEntity>> XARIA = build("xaria", XariaEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Netheran
    public static final DeferredHolder<EntityType<?>, EntityType<NetharanEntity>> NETHARAN = build("netharan", NetharanEntity::new, MobCategory.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.15f));
    public static final DeferredHolder<EntityType<?>, EntityType<ChronosEntity>> CHRONOS = build("chronos", ChronosEntity::new, MobCategory.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.15f));
    public static final DeferredHolder<EntityType<?>, EntityType<PythusEntity>> PYTHUS = build("pythus", PythusEntity::new, MobCategory.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.15f));
    public static final DeferredHolder<EntityType<?>, EntityType<VulcannusEntity>> VULCANNUS = build("vulcannus", VulcannusEntity::new, MobCategory.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.15f));
    //Zombie
    public static final DeferredHolder<EntityType<?>, EntityType<SowHuskEntity>> HUSK = build("husk", SowHuskEntity::new, MobCategory.MONSTER, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<SowStrayEntity>> STRAY = build("stray", SowStrayEntity::new, MobCategory.MONSTER, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<SowZombieEntity>> ZOMBIE = build("zombie", SowZombieEntity::new, MobCategory.MONSTER, 64, 3, false, EntityBuildHelper.PLAYER);
    //Guard
    public static final DeferredHolder<EntityType<?>, EntityType<ConchordGuardEntity>> CONCHORD_GUARD = build("conchord_guard", ConchordGuardEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<CrownPeakGuardEntity>> CROWN_PEAK_GUARD = build("crown_peak_guard", CrownPeakGuardEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<CydoniaGuardEntity>> CYDONIA_GUARD = build("cydonia_guard", CydoniaGuardEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<EthereaGuardEntity>> ETHEREA_GUARD = build("etherea_guard", EthereaGuardEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<FeldenGuardEntity>> FELDEN_GUARD = build("felden_guard", FeldenGuardEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.05f));
    public static final DeferredHolder<EntityType<?>, EntityType<GeneralGuardEntity>> GENERAL_GUARD = build("general_guard", GeneralGuardEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<HydraphelGuardEntity>> HYDRAPHEL_GUARD = build("hydraphel_guard", HydraphelGuardEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<KarthenGuardEntity>> KARTHEN_GUARD = build("karthen_guard", KarthenGuardEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<NorthwindGuardEntity>> NORTHWIND_GUARD = build("northwind_guard", NorthwindGuardEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Soldier
    public static final DeferredHolder<EntityType<?>, EntityType<ConchordSoldierEntity>> CONCHORD_SOLDIER = build("conchord_soldier", ConchordSoldierEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<CrownPeakSoldierEntity>> CROWN_PEAK_SOLDIER = build("crown_peak_soldier", CrownPeakSoldierEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<CydoniaSoldierEntity>> CYDONIA_SOLDIER = build("cydonia_soldier", CydoniaSoldierEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<EthereaSoldierEntity>> ETHEREA_SOLDIER = build("etherea_soldier", EthereaSoldierEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<FeldenSoldierEntity>> FELDEN_SOLDIER = build("felden_soldier", FeldenSoldierEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.05f));
    public static final DeferredHolder<EntityType<?>, EntityType<HydraphelSoldierEntity>> HYDRAPHEL_SOLDIER = build("hydraphel_soldier", HydraphelSoldierEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<NorthwindSoldierEntity>> NORTHWIND_SOLDIER = build("northwind_soldier", NorthwindSoldierEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Townsfolk
    public static final DeferredHolder<EntityType<?>, EntityType<AdventurerFolkEntity>> ADVENTURER_FOLK = build("adventurer_folk", AdventurerFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<BlacksmithFolkEntity>> BLACKSMITH_FOLK = build("blacksmith_folk", BlacksmithFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<ChefFolkEntity>> CHEF_FOLK = build("chef_folk", ChefFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<FarmerFolkEntity>> FARMER_FOLK = build("farmer_folk", FarmerFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<FemaleFolkEntity>> FEMALE_FOLK = build("female_folk", FemaleFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<FisherFolkEntity>> FISHER_FOLK = build("fisher_folk", FisherFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<LeatherWorkerFolkEntity>> LEATHER_WORKER_FOLK = build("leather_worker_folk", LeatherWorkerFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<MaleFolkEntity>> MALE_FOLK = build("male_folk", MaleFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<MerchantFolkEntity>> MERCHANT_FOLK = build("merchant_folk", MerchantFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<MinerFolkEntity>> MINER_FOLK = build("miner_folk", MinerFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<OldFolkEntity>> OLD_FOLK = build("old_folk", OldFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<PoorFolkEntity>> POOR_FOLK = build("poor_folk", PoorFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<SailorFolkEntity>> SAILOR_FOLK = build("sailor_folk", SailorFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final DeferredHolder<EntityType<?>, EntityType<ScholarFolkEntity>> SCHOLAR_FOLK = build("scholar_folk", ScholarFolkEntity::new, MobCategory.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> build(String name, EntityType.EntityFactory<T> constructor, MobCategory category, int trackingRange, int updateInterval, boolean fireImmune, EntityBuildHelper.Dimension dimension) {
        return REGISTRY.register(name, EntityBuildHelper.build(name, constructor, category, trackingRange, updateInterval, fireImmune, dimension));
    }

    @SubscribeEvent
    public static void registerDefaultAttributes(EntityAttributeCreationEvent event) {
        event.put(PROTE_CLONE.get(), ProteCloneEntity.createMobAttributes().build());

        event.put(NONE_TYPE_ARDONI.get(), NoneTypeArdoniEntity.createAttributes().build());
        event.put(KALTARIS_ARDONI.get(), KaltarisArdoniEntity.createAttributes().build());
        event.put(MENDORIS_ARDONI.get(), MendorisArdoniEntity.createAttributes().build());
        event.put(NESTORIS_ARDONI.get(), NestorisArdoniEntity.createAttributes().build());
        event.put(SENDARIS_ARDONI.get(), SendarisArdoniEntity.createAttributes().build());
        event.put(VOLTARIS_ARDONI.get(), VoltarisArdoniEntity.createAttributes().build());
        event.put(GRIM.get(), GrimEntity.createAttributes().build());
        event.put(GLACIAN.get(), GlacianEntity.createAttributes().build());

        event.put(ACHILLEAN.get(), AchilleanEntity.createAttributes().build());
        event.put(INGRESSSUS.get(), IngresssusEntity.createAttributes().build());
        event.put(AEGUS.get(), AegusEntity.createAttributes().build());
        event.put(KALTARIS_MASTER.get(), KaltarisMasterEntity.createAttributes().build());
        event.put(MENDORIS_MASTER.get(), MendorisMasterEntity.createAttributes().build());
        event.put(SENDARIS_MASTER.get(), SendarisMasterEntity.createAttributes().build());
        event.put(HUBRIS.get(), HubrisEntity.createAttributes().build());
        event.put(RIA.get(), RiaEntity.createAttributes().build());
        event.put(THALLEOUS.get(), ThalleousEntity.createAttributes().build());
        event.put(GALLEOUS.get(), GalleousEntity.createAttributes().build());
        event.put(SENN.get(), SennEntity.createAttributes().build());
        event.put(ZULIUS.get(), ZuliusEntity.createAttributes().build());
        event.put(TYGREN.get(), TygrenEntity.createAttributes().build());
        event.put(OSIVIAN.get(), OsivianEntity.createAttributes().build());
        event.put(LUCIDIUS.get(), LucidiusEntity.createAttributes().build());
        event.put(ZINAIDA.get(), ZinaidaEntity.createAttributes().build());
        event.put(AURELIUS.get(), AureliusEntity.createAttributes().build());
        event.put(HADION.get(), HadionEntity.createAttributes().build());
        event.put(VAL.get(), ValEntity.createAttributes().build());
        event.put(SIDERIAN.get(), SiderianEntity.createAttributes().build());

        event.put(FELDEN.get(), FeldenEntity.createAttributes().build());
        event.put(KIYOSHI.get(), KiyoshiEntity.createAttributes().build());
        event.put(NIIKA.get(), NiikaEntity.createAttributes().build());
        event.put(MASANI.get(), MasaniEntity.createAttributes().build());
        event.put(NITSUKE.get(), NitsukeEntity.createAttributes().build());
        event.put(YUJUKI.get(), YujukiEntity.createAttributes().build());

        event.put(ABBIGAIL.get(), AbbigailEntity.createAttributes().build());
        event.put(ALEC.get(), AlecEntity.createAttributes().build());
        event.put(BARTENDER.get(), BartenderEntity.createAttributes().build());
        event.put(CIVILIAN.get(), CivilianEntity.createAttributes().build());
        event.put(DARLENE.get(), DarleneEntity.createAttributes().build());
        event.put(EDDY.get(), EddyEntity.createAttributes().build());
        event.put(HAWKEN.get(), HawkenEntity.createAttributes().build());
        event.put(HORSE_RIDER.get(), HorseRiderEntity.createAttributes().build());
        event.put(LUCAN.get(), LucanEntity.createAttributes().build());
        event.put(MARCUS.get(), MarcusEntity.createAttributes().build());
        event.put(MARSHALL.get(), MarshallEntity.createAttributes().build());
        event.put(MRFINCH.get(), MrfinchEntity.createAttributes().build());
        event.put(SULLIMAN.get(), SullimanEntity.createAttributes().build());
        event.put(ALLISTER.get(), AllisterEntity.createAttributes().build());
        event.put(DENNY.get(), DennyEntity.createAttributes().build());
        event.put(JALKAR.get(), JalkarEntity.createAttributes().build());
        event.put(SAXON.get(), SaxonEntity.createAttributes().build());
        event.put(TREVOR.get(), TrevorEntity.createAttributes().build());

        event.put(IGNEOUS.get(), IgneousEntity.createAttributes().build());
        event.put(MAGNORITE.get(), MagnoriteEntity.createAttributes().build());

        event.put(NECROMANCER.get(), NecrolordEntity.createAttributes().build());
        event.put(NECROLORD.get(), NecrolordEntity.createAttributes().build());
        event.put(XARIA.get(), XariaEntity.createAttributes().build());

        event.put(NETHARAN.get(), NetharanEntity.createAttributes().build());
        event.put(CHRONOS.get(), ChronosEntity.createAttributes().build());
        event.put(PYTHUS.get(), PythusEntity.createAttributes().build());
        event.put(VULCANNUS.get(), VulcannusEntity.createAttributes().build());

        event.put(HUSK.get(), SowHuskEntity.createAttributes().build());
        event.put(STRAY.get(), SowStrayEntity.createAttributes().build());
        event.put(ZOMBIE.get(), SowZombieEntity.createAttributes().build());

        event.put(CONCHORD_GUARD.get(), ConchordGuardEntity.createAttributes().build());
        event.put(CROWN_PEAK_GUARD.get(), CrownPeakGuardEntity.createAttributes().build());
        event.put(CYDONIA_GUARD.get(), CydoniaGuardEntity.createAttributes().build());
        event.put(ETHEREA_GUARD.get(), EthereaGuardEntity.createAttributes().build());
        event.put(FELDEN_GUARD.get(), FeldenGuardEntity.createAttributes().build());
        event.put(GENERAL_GUARD.get(), GeneralGuardEntity.createAttributes().build());
        event.put(HYDRAPHEL_GUARD.get(), HydraphelGuardEntity.createAttributes().build());
        event.put(KARTHEN_GUARD.get(), KarthenGuardEntity.createAttributes().build());
        event.put(NORTHWIND_GUARD.get(), NorthwindGuardEntity.createAttributes().build());

        event.put(CONCHORD_SOLDIER.get(), ConchordSoldierEntity.createAttributes().build());
        event.put(CROWN_PEAK_SOLDIER.get(), CrownPeakSoldierEntity.createAttributes().build());
        event.put(CYDONIA_SOLDIER.get(), CydoniaSoldierEntity.createAttributes().build());
        event.put(ETHEREA_SOLDIER.get(), EthereaSoldierEntity.createAttributes().build());
        event.put(FELDEN_SOLDIER.get(), FeldenSoldierEntity.createAttributes().build());
        event.put(HYDRAPHEL_SOLDIER.get(), HydraphelSoldierEntity.createAttributes().build());
        event.put(NORTHWIND_SOLDIER.get(), NorthwindSoldierEntity.createAttributes().build());

        event.put(ADVENTURER_FOLK.get(), AdventurerFolkEntity.createAttributes().build());
        event.put(BLACKSMITH_FOLK.get(), BlacksmithFolkEntity.createAttributes().build());
        event.put(CHEF_FOLK.get(), ChefFolkEntity.createAttributes().build());
        event.put(FARMER_FOLK.get(), FarmerFolkEntity.createAttributes().build());
        event.put(FEMALE_FOLK.get(), FemaleFolkEntity.createAttributes().build());
        event.put(FISHER_FOLK.get(), FisherFolkEntity.createAttributes().build());
        event.put(LEATHER_WORKER_FOLK.get(), LeatherWorkerFolkEntity.createAttributes().build());
        event.put(MALE_FOLK.get(), MaleFolkEntity.createAttributes().build());
        event.put(MERCHANT_FOLK.get(), MerchantFolkEntity.createAttributes().build());
        event.put(MINER_FOLK.get(), MinerFolkEntity.createAttributes().build());
        event.put(OLD_FOLK.get(), OldFolkEntity.createAttributes().build());
        event.put(POOR_FOLK.get(), PoorFolkEntity.createAttributes().build());
        event.put(SAILOR_FOLK.get(), SailorFolkEntity.createAttributes().build());
        event.put(SCHOLAR_FOLK.get(), ScholarFolkEntity.createAttributes().build());
    }
}
