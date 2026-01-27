package com.iafenvoy.sow.config;

import com.iafenvoy.jupiter.config.container.AutoInitConfigContainer;
import com.iafenvoy.jupiter.config.entry.*;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resources.ResourceLocation;

public class SowCommonConfig extends AutoInitConfigContainer {
    public static final SowCommonConfig INSTANCE = new SowCommonConfig();
    public final CommonConfig common = new CommonConfig();
    public final AggressiumPowerConfig aggressium = new AggressiumPowerConfig();
    public final MobiliumPowerConfig mobilium = new MobiliumPowerConfig();
    public final ProtisiumPowerConfig protisium = new ProtisiumPowerConfig();
    public final SupporiumPowerConfig supportium = new SupporiumPowerConfig();

    public SowCommonConfig() {
        super(ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "sow_config"), "config.sow.server.title", "./config/sow/songs-of-war.json");
    }

    public static class CommonConfig extends AutoInitConfigCategoryBase {
        public final BooleanEntry enableBeaconTp = BooleanEntry.builder("config.sow.common.enableBeaconTp", true).key("enableBeaconTp").build();
        public final IntegerEntry songChunkRarity = IntegerEntry.builder("config.sow.common.songChunkRarity", 64).key("songChunkRarity").min(1).build();
        public final IntegerEntry songChunkDetectRange = IntegerEntry.builder("config.sow.common.songChunkDetectRange", 2).key("songChunkDetectRange").range(0, 10).build();
        public final BooleanEntry songChunkRegen = BooleanEntry.builder("config.sow.common.songChunkRegen", true).key("songChunkRegen").build();
        public final EnumEntry<Anniversary.InvokeType> anniversary = EnumEntry.builder("???", Anniversary.InvokeType.NORMAL).key("anniversary").build();
        public final DoubleEntry specialFishChance = DoubleEntry.builder("config.sow.common.specialFishChance", 0.001).key("specialFishChance").range(0, 1).build();

        public CommonConfig() {
            super("common", "config.sow.category.common");
        }
    }

    @SuppressWarnings("unused")
    public static class AggressiumPowerConfig extends AutoInitConfigCategoryBase {
        public final DoubleEntry aggrobeamExhaustion = DoubleEntry.builder("config.sow.power.aggrobeam.exhaustion", 0.4).min(0).key("aggrobeam.exhaustion").build();
        public final DoubleEntry aggrobeamDamage = DoubleEntry.builder("config.sow.power.aggrobeam.damage", 2).min(0).key("aggrobeam.damage").build();
        public final DoubleEntry aggrobeamMaxDistance = DoubleEntry.builder("config.sow.power.aggrobeam.maxDistance", 50).min(0).key("aggrobeam.maxDistance").build();
        public final SeparatorEntry s1 = SeparatorEntry.builder().build();
        public final IntegerEntry aggroblastPrimaryCooldown = IntegerEntry.builder("config.sow.power.aggroblast.cooldown.primary", 20).min(0).key("aggroblast.cooldown.primary").build();
        public final IntegerEntry aggroblastSecondaryCooldown = IntegerEntry.builder("config.sow.power.aggroblast.cooldown.secondary", 20).min(0).key("aggroblast.cooldown.secondary").build();
        public final DoubleEntry aggroblastExhaustion = DoubleEntry.builder("config.sow.power.aggroblast.exhaustion", 2).min(0).key("aggroblast.exhaustion").build();
        public final DoubleEntry aggroblastSpeed = DoubleEntry.builder("config.sow.power.aggroblast.speed", 1).min(0).key("aggroblast.speed").build();
        public final DoubleEntry aggroblastRange = DoubleEntry.builder("config.sow.power.aggroblast.range", 5).min(0).key("aggroblast.range").build();
        public final DoubleEntry aggroblastDamage = DoubleEntry.builder("config.sow.power.aggroblast.damage", 4).min(0).key("aggroblast.damage").build();
        public final SeparatorEntry s2 = SeparatorEntry.builder().build();
        public final IntegerEntry aggrodetonatePrimaryCooldown = IntegerEntry.builder("config.sow.power.aggrodetonate.cooldown.primary", 30).min(0).key("aggrodetonate.cooldown.primary").build();
        public final IntegerEntry aggrodetonateSecondaryCooldown = IntegerEntry.builder("config.sow.power.aggrodetonate.cooldown.secondary", 50).min(0).key("aggrodetonate.cooldown.secondary").build();
        public final DoubleEntry aggrodetonateExhaustion = DoubleEntry.builder("config.sow.power.aggrodetonate.exhaustion", 2).min(0).key("aggrodetonate.exhaustion").build();
        public final DoubleEntry aggrodetonatePower = DoubleEntry.builder("config.sow.power.aggrodetonate.power", 1).min(0).key("aggrodetonate.power").build();
        public final DoubleEntry aggrodetonateSpeed = DoubleEntry.builder("config.sow.power.aggrodetonate.speed", 2).min(0).key("aggrodetonate.speed").build();
        public final SeparatorEntry s3 = SeparatorEntry.builder().build();
        public final IntegerEntry aggroquakePrimaryCooldown = IntegerEntry.builder("config.sow.power.aggroquake.cooldown.primary", 300).min(0).key("aggroquake.cooldown.primary").build();
        public final IntegerEntry aggroquakeSecondaryCooldown = IntegerEntry.builder("config.sow.power.aggroquake.cooldown.secondary", 200).min(0).key("aggroquake.cooldown.secondary").build();
        public final DoubleEntry aggroquakeExhaustion = DoubleEntry.builder("config.sow.power.aggroquake.exhaustion", 4).min(0).key("aggroquake.exhaustion").build();
        public final DoubleEntry aggroquakeRange = DoubleEntry.builder("config.sow.power.aggroquake.range", 10).min(0).key("aggroquake.range").build();
        public final DoubleEntry aggroquakeDamage = DoubleEntry.builder("config.sow.power.aggroquake.damage", 5).min(0).key("aggroquake.damage").build();
        public final SeparatorEntry s4 = SeparatorEntry.builder().build();
        public final IntegerEntry aggroshardPrimaryCooldown = IntegerEntry.builder("config.sow.power.aggroshard.cooldown.primary", 60).min(0).key("aggroshard.cooldown.primary").build();
        public final IntegerEntry aggroshardSecondaryCooldown = IntegerEntry.builder("config.sow.power.aggroshard.cooldown.secondary", 100).min(0).key("aggroshard.cooldown.secondary").build();
        public final DoubleEntry aggroshardExhaustion = DoubleEntry.builder("config.sow.power.aggroshard.exhaustion", 5).min(0).key("aggroshard.exhaustion").build();
        public final DoubleEntry aggroshardDamage = DoubleEntry.builder("config.sow.power.aggroshard.damage", 1).min(0).key("aggroshard.damage").build();
        public final DoubleEntry aggroshardSpeed = DoubleEntry.builder("config.sow.power.aggroshard.speed", 1.5).min(0).key("aggroshard.speed").build();
        public final IntegerEntry aggroshardCount = IntegerEntry.builder("config.sow.power.aggroshard.count", 20).min(0).key("aggroshard.count").build();
        public final SeparatorEntry s5 = SeparatorEntry.builder().build();
        public final IntegerEntry aggroshockPrimaryCooldown = IntegerEntry.builder("config.sow.power.aggroshock.cooldown.primary", 300).min(0).key("aggroshock.cooldown.primary").build();
        public final IntegerEntry aggroshockSecondaryCooldown = IntegerEntry.builder("config.sow.power.aggroshock.cooldown.secondary", 300).min(0).key("aggroshock.cooldown.secondary").build();
        public final DoubleEntry aggroshockExhaustion = DoubleEntry.builder("config.sow.power.aggroshock.exhaustion", 4).min(0).key("aggroshock.exhaustion").build();
        public final IntegerEntry aggroshockDistance = IntegerEntry.builder("config.sow.power.aggroshock.distance", 8).min(0).key("aggroshock.distance").build();
        public final SeparatorEntry s6 = SeparatorEntry.builder().build();
        public final IntegerEntry aggrospherePrimaryCooldown = IntegerEntry.builder("config.sow.power.aggrosphere.cooldown.primary", 10).min(0).key("aggrosphere.cooldown.primary").build();
        public final IntegerEntry aggrosphereSecondaryCooldown = IntegerEntry.builder("config.sow.power.aggrosphere.cooldown.secondary", 10).min(0).key("aggrosphere.cooldown.secondary").build();
        public final DoubleEntry aggrosphereExhaustion = DoubleEntry.builder("config.sow.power.aggrosphere.exhaustion", 1).min(0).key("aggrosphere.exhaustion").build();
        public final DoubleEntry aggrosphereSpeed = DoubleEntry.builder("config.sow.power.aggrosphere.speed", 3).min(0).key("aggrosphere.speed").build();
        public final DoubleEntry aggrosphereDamage = DoubleEntry.builder("config.sow.power.aggrosphere.damage", 5).min(0).key("aggrosphere.damage").build();
        public final SeparatorEntry s7 = SeparatorEntry.builder().build();
        public final DoubleEntry aggrostormExhaustion = DoubleEntry.builder("config.sow.power.aggrostorm.exhaustion", 4).min(0).key("aggrostorm.exhaustion").build();
        public final DoubleEntry aggrostormStrength = DoubleEntry.builder("config.sow.power.aggrostorm.strength", 0.02).min(0).key("aggrostorm.strength").build();
        public final DoubleEntry aggrostormRange = DoubleEntry.builder("config.sow.power.aggrostorm.range", 15).min(0).key("aggrostorm.range").build();
        public final DoubleEntry aggrostormDamage = DoubleEntry.builder("config.sow.power.aggrostorm.damage", 1).min(0).key("aggrostorm.damage").build();

        public AggressiumPowerConfig() {
            super("aggressium", "config.sow.category.power.aggressium");
        }
    }

    @SuppressWarnings("unused")
    public static class MobiliumPowerConfig extends AutoInitConfigCategoryBase {
        public final IntegerEntry mobilibouncePrimaryCooldown = IntegerEntry.builder("config.sow.power.mobilibounce.cooldown.primary", 50).min(0).key("mobilibounce.cooldown.primary").build();
        public final IntegerEntry mobilibounceSecondaryCooldown = IntegerEntry.builder("config.sow.power.mobilibounce.cooldown.secondary", 50).min(0).key("mobilibounce.cooldown.secondary").build();
        public final DoubleEntry mobilibounceExhaustion = DoubleEntry.builder("config.sow.power.mobilibounce.exhaustion", 0.5).min(0).key("mobilibounce.exhaustion").build();
        public final IntegerEntry mobilibounceExistTime = IntegerEntry.builder("config.sow.power.mobilibounce.exist_time", 5).min(0).key("mobilibounce.exist_time").build();
        public final SeparatorEntry s1 = SeparatorEntry.builder().build();
        public final IntegerEntry mobiliburstPrimaryCooldown = IntegerEntry.builder("config.sow.power.mobiliburst.cooldown.primary", 40).min(0).key("mobiliburst.cooldown.primary").build();
        public final IntegerEntry mobiliburstSecondaryCooldown = IntegerEntry.builder("config.sow.power.mobiliburst.cooldown.secondary", 80).min(0).key("mobiliburst.cooldown.secondary").build();
        public final DoubleEntry mobiliburstExhaustion = DoubleEntry.builder("config.sow.power.mobiliburst.exhaustion", 4).min(0).key("mobiliburst.exhaustion").build();
        public final DoubleEntry mobiliburstSpeed = DoubleEntry.builder("config.sow.power.mobiliburst.speed", 8).range(0, 50).key("mobiliburst.speed").build();
        public final SeparatorEntry s2 = SeparatorEntry.builder().build();
        public final IntegerEntry mobiliflashPrimaryCooldown = IntegerEntry.builder("config.sow.power.mobiliflash.cooldown.primary", 40).min(0).key("mobiliflash.cooldown.primary").build();
        public final IntegerEntry mobiliflashSecondaryCooldown = IntegerEntry.builder("config.sow.power.mobiliflash.cooldown.secondary", 40).min(0).key("mobiliflash.cooldown.secondary").build();
        public final DoubleEntry mobiliflashExhaustion = DoubleEntry.builder("config.sow.power.mobiliflash.exhaustion", 2).min(0).key("mobiliflash.exhaustion").build();
        public final DoubleEntry mobiliflashSpeed = DoubleEntry.builder("config.sow.power.mobiliflash.speed", 8).range(0, 50).key("mobiliflash.speed").build();
        public final SeparatorEntry s3 = SeparatorEntry.builder().build();
        public final DoubleEntry mobiliglideExhaustion = DoubleEntry.builder("config.sow.power.mobiliglide.exhaustion", 0.2).min(0).key("mobiliglide.exhaustion").build();
        public final SeparatorEntry s4 = SeparatorEntry.builder().build();
        public final DoubleEntry mobilileapExhaustion = DoubleEntry.builder("config.sow.power.mobilileap.exhaustion", 0.2).min(0).key("mobilileap.exhaustion").build();
        public final SeparatorEntry s5 = SeparatorEntry.builder().build();
        public final DoubleEntry mobiliwingsExhaustion = DoubleEntry.builder("config.sow.power.mobiliwings.exhaustion", 0.1).min(0).key("mobiliwings.exhaustion").build();

        public MobiliumPowerConfig() {
            super("mobilium", "config.sow.category.power.mobilium");
        }
    }

    @SuppressWarnings("unused")
    public static class ProtisiumPowerConfig extends AutoInitConfigCategoryBase {
        public final IntegerEntry protearmorPrimaryCooldown = IntegerEntry.builder("config.sow.power.protearmor.cooldown.primary", 40).min(0).key("protearmor.cooldown.primary").build();
        public final IntegerEntry protearmorSecondaryCooldown = IntegerEntry.builder("config.sow.power.protearmor.cooldown.secondary", 80).min(0).key("protearmor.cooldown.secondary").build();
        public final DoubleEntry protearmorExhaustion = DoubleEntry.builder("config.sow.power.protearmor.exhaustion", 0.2).min(0).key("protearmor.exhaustion").build();
        public final DoubleEntry protearmorMaxReduceDamage = DoubleEntry.builder("config.sow.power.protearmor.maxReduceDamage", 20).min(0).key("protearmor.maxReduceDamage").build();
        public final SeparatorEntry s1 = SeparatorEntry.builder().build();
        public final IntegerEntry protebarrierPrimaryCooldown = IntegerEntry.builder("config.sow.power.protebarrier.cooldown.primary", 200).min(0).key("protebarrier.cooldown.primary").build();
        public final IntegerEntry protebarrierSecondaryCooldown = IntegerEntry.builder("config.sow.power.protebarrier.cooldown.secondary", 200).min(0).key("protebarrier.cooldown.secondary").build();
        public final DoubleEntry protebarrierExhaustion = DoubleEntry.builder("config.sow.power.protebarrier.exhaustion", 5).min(0).key("protebarrier.exhaustion").build();
        public final IntegerEntry protebarrierExistTime = IntegerEntry.builder("config.sow.power.protebarrier.existTime", 8).min(0).key("protebarrier.existTime").build();
        public final SeparatorEntry s2 = SeparatorEntry.builder().build();
        public final IntegerEntry proteclonePrimaryCooldown = IntegerEntry.builder("config.sow.power.proteclone.cooldown.primary", 60).min(0).key("proteclone.cooldown.primary").build();
        public final IntegerEntry protecloneSecondaryCooldown = IntegerEntry.builder("config.sow.power.proteclone.cooldown.secondary", 100).min(0).key("proteclone.cooldown.secondary").build();
        public final DoubleEntry protecloneExhaustion = DoubleEntry.builder("config.sow.power.proteclone.exhaustion", 4).min(0).key("proteclone.exhaustion").build();
        public final SeparatorEntry s3 = SeparatorEntry.builder().build();
        public final IntegerEntry protehealPrimaryCooldown = IntegerEntry.builder("config.sow.power.proteheal.cooldown.primary", 100).min(0).key("proteheal.cooldown.primary").build();
        public final IntegerEntry protehealSecondaryCooldown = IntegerEntry.builder("config.sow.power.proteheal.cooldown.secondary", 200).min(0).key("proteheal.cooldown.secondary").build();
        public final DoubleEntry protehealExhaustion = DoubleEntry.builder("config.sow.power.proteheal.exhaustion", 2).min(0).key("proteheal.exhaustion").build();
        public final SeparatorEntry s4 = SeparatorEntry.builder().build();
        public final DoubleEntry protepointExhaustion = DoubleEntry.builder("config.sow.power.protepoint.exhaustion", 0.1).min(0).key("protepoint.exhaustion").build();
        public final SeparatorEntry s5 = SeparatorEntry.builder().build();
        public final DoubleEntry protesphereExhaustion = DoubleEntry.builder("config.sow.power.protesphere.exhaustion", 0.2).min(0).key("protesphere.exhaustion").build();

        public ProtisiumPowerConfig() {
            super("protisium", "config.sow.category.power.protisium");
        }
    }

    @SuppressWarnings("unused")
    public static class SupporiumPowerConfig extends AutoInitConfigCategoryBase {
        public final IntegerEntry supporekesisPrimaryCooldown = IntegerEntry.builder("config.sow.power.supporekesis.cooldown.primary", 50).min(0).key("supporekesis.cooldown.primary").build();
        public final IntegerEntry supporekesisSecondaryCooldown = IntegerEntry.builder("config.sow.power.supporekesis.cooldown.secondary", 150).min(0).key("supporekesis.cooldown.secondary").build();
        public final DoubleEntry supporekesisExhaustion = DoubleEntry.builder("config.sow.power.supporekesis.exhaustion", 2).min(0).key("supporekesis.exhaustion").build();
        public final DoubleEntry supporekesisRange = DoubleEntry.builder("config.sow.power.supporekesis.range", 20).range(0, 16 * 16).key("supporekesis.range").build();
        public final BooleanEntry supporekesisControlSelf = BooleanEntry.builder("config.sow.power.supporekesis.control_self", false).key("supporekesis.control_self").build();
        public final SeparatorEntry s1 = SeparatorEntry.builder().build();
        public final IntegerEntry supporoformPrimaryCooldown = IntegerEntry.builder("config.sow.power.supporoform.cooldown.primary", 40).min(0).key("supporoform.cooldown.primary").build();
        public final IntegerEntry supporoformSecondaryCooldown = IntegerEntry.builder("config.sow.power.supporoform.cooldown.secondary", 160).min(0).key("supporoform.cooldown.secondary").build();
        public final DoubleEntry supporoformExhaustion = DoubleEntry.builder("config.sow.power.supporoform.exhaustion", 4).min(0).key("supporoform.exhaustion").build();
        public final SeparatorEntry s2 = SeparatorEntry.builder().build();
        public final IntegerEntry supporoliftPrimaryCooldown = IntegerEntry.builder("config.sow.power.supporolift.cooldown.primary", 100).min(0).key("supporolift.cooldown.primary").build();
        public final IntegerEntry supporoliftSecondaryCooldown = IntegerEntry.builder("config.sow.power.supporolift.cooldown.secondary", 200).min(0).key("supporolift.cooldown.secondary").build();
        public final DoubleEntry supporoliftExhaustion = DoubleEntry.builder("config.sow.power.supporolift.exhaustion", 2).min(0).key("supporolift.exhaustion").build();
        public final DoubleEntry supporoliftRange = DoubleEntry.builder("config.sow.power.supporolift.range", 20).range(0, 16 * 16).key("supporolift.range").build();
        public final SeparatorEntry s3 = SeparatorEntry.builder().build();
        public final IntegerEntry supporospikePrimaryCooldown = IntegerEntry.builder("config.sow.power.supporospike.cooldown.primary", 50).min(0).key("supporospike.cooldown.primary").build();
        public final IntegerEntry supporospikeSecondaryCooldown = IntegerEntry.builder("config.sow.power.supporospike.cooldown.secondary", 100).min(0).key("supporospike.cooldown.secondary").build();
        public final DoubleEntry supporospikeExhaustion = DoubleEntry.builder("config.sow.power.supporospike.exhaustion", 3).min(0).key("supporospike.exhaustion").build();
        public final DoubleEntry supporospikeRange = DoubleEntry.builder("config.sow.power.supporospike.range", 10).range(0, 16 * 16).key("supporospike.range").build();

        public SupporiumPowerConfig() {
            super("supportium", "config.sow.category.power.supportium");
        }
    }
}
