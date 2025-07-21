package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.render.CommonPlayerLikeEntityRenderer;
import com.iafenvoy.neptune.render.CommonPlayerLikeWithMarkerEntityRenderer;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.SkullManager;
import com.iafenvoy.sow.entity.GrimEntity;
import com.iafenvoy.sow.entity.ardoni.*;
import com.iafenvoy.sow.entity.felina.*;
import com.iafenvoy.sow.entity.human.*;
import com.iafenvoy.sow.entity.magnorite.IgneousEntity;
import com.iafenvoy.sow.entity.necromancer.NecrolordEntity;
import com.iafenvoy.sow.entity.necromancer.XariaEntity;
import com.iafenvoy.sow.entity.netharan.ChronosEntity;
import com.iafenvoy.sow.entity.netharan.PythusEntity;
import com.iafenvoy.sow.entity.netharan.VulcannusEntity;
import com.iafenvoy.sow.item.AdjustedSongStoneItem;
import com.iafenvoy.sow.item.SongStoneItem;
import com.iafenvoy.sow.particle.AggroblastParticle;
import com.iafenvoy.sow.particle.LaserParticle;
import com.iafenvoy.sow.particle.SongEffectParticle;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import com.iafenvoy.sow.render.block.ArdoniGraveBlockEntityRenderer;
import com.iafenvoy.sow.render.block.SongCubeBlockEntityRenderer;
import com.iafenvoy.sow.render.block.WallsOfTimeBlockEntityRenderer;
import com.iafenvoy.sow.render.entity.ArdoniEntityRenderer;
import com.iafenvoy.sow.render.entity.MagnoriteEntityRenderer;
import com.iafenvoy.sow.render.power.entity.*;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public final class SowRenderers {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(SowEntities.AGGRO_SPHERE, AggroSphereRenderer::new);
        EntityRendererRegistry.register(SowEntities.AGGRO_DETONATE, AggroDetonateRenderer::new);
        EntityRendererRegistry.register(SowEntities.AGGRO_SHARD, AggroShardRenderer::new);
        EntityRendererRegistry.register(SowEntities.PROTE_CLONE, ProteCloneRenderer::new);
        EntityRendererRegistry.register(SowEntities.SUPPORO_SPIKE, SupporoSpikeRenderer::new);

        EntityRendererRegistry.register(SowEntities.NONE_TYPE_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.VOLTARIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SENDARIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MENDORIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NESTORIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KALTARIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.GRIM, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.GLACIAN, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.ACHILLEAN, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.INGRESSSUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.AEGUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KALTARIS_MASTER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MENDORIS_MASTER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SENDARIS_MASTER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HUBRIS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.RIA, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.THALLEOUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.GALLEOUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SENN, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ZULIUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.TYGREN, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.OSIVIAN, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.LUCIDIUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ZINAIDA, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.AURELIUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HADION, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.VAL, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SIDERIAN, ArdoniEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.FELDEN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KIYOSHI, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NIIKA, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MASANI, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NITSUKE, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.YUJUKI, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.ABBIGAIL, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ALEC, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.BARTENDER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CIVILIAN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.DARLENE, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.EDDY, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HAWKEN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HORSE_RIDER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.LUCAN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MARCUS, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MARSHALL, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MRFINCH, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SULLIMAN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ALLISTER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.DENNY, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.JALKAR, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SAXON, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.TREVOR, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.IGNEOUS, MagnoriteEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MAGNORITE, MagnoriteEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.NECROMANCER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NECROLORD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.XARIA, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.NETHARAN, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CHRONOS, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.PYTHUS, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.VULCANNUS, CommonPlayerLikeWithMarkerEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.HUSK, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.STRAY, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ZOMBIE, CommonPlayerLikeWithMarkerEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.CONCHORD_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CROWN_PEAK_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CYDONIA_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ETHEREA_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FELDEN_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.GENERAL_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HYDRAPHEL_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KARTHEN_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NORTHWIND_GUARD, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.CONCHORD_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CROWN_PEAK_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CYDONIA_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ETHEREA_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FELDEN_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HYDRAPHEL_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NORTHWIND_SOLDIER, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.ADVENTURER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.BLACKSMITH_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CHEF_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FARMER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FEMALE_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FISHER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.LEATHER_WORKER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MALE_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MERCHANT_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MINER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.OLD_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.POOR_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SAILOR_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SCHOLAR_FOLK, CommonPlayerLikeEntityRenderer::new);
    }

    public static void registerSkull() {
        SkullManager.registerSkull(SowSkulls.SkullType.ABBIGAIL, AbbigailEntity.TEXTURE, SowSkulls.ABBIGAIL_HEAD.get(), SowSkulls.ABBIGAIL_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.ACHILLEAN, AchilleanEntity.TEXTURE, AchilleanEntity.TEXTURE_MARKER, AchilleanEntity.COLOR, SowSkulls.ACHILLEAN_HEAD.get(), SowSkulls.ACHILLEAN_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.AEGUS, AegusEntity.TEXTURE, AegusEntity.TEXTURE_MARKER, AegusEntity.COLOR, SowSkulls.AEGUS_HEAD.get(), SowSkulls.AEGUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.ALEC, AlecEntity.TEXTURE, SowSkulls.ALEC_HEAD.get(), SowSkulls.ALEC_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.ALLISTER, AllisterEntity.TEXTURE, SowSkulls.ALLISTER_HEAD.get(), SowSkulls.ALLISTER_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.AURELIUS, AureliusEntity.TEXTURE, AureliusEntity.TEXTURE_MARKER, AureliusEntity.COLOR, SowSkulls.AURELIUS_HEAD.get(), SowSkulls.AURELIUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.CHRONOS, ChronosEntity.TEXTURE, SowSkulls.CHRONOS_HEAD.get(), SowSkulls.CHRONOS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.DARLENE, DarleneEntity.TEXTURE, SowSkulls.DARLENE_HEAD.get(), SowSkulls.DARLENE_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.DENNY, DennyEntity.TEXTURE, SowSkulls.DENNY_HEAD.get(), SowSkulls.DENNY_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.EDDY, EddyEntity.TEXTURE, SowSkulls.EDDY_HEAD.get(), SowSkulls.EDDY_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.GALLEOUS, GalleousEntity.TEXTURE, GalleousEntity.TEXTURE_MARKER, GalleousEntity.COLOR, SowSkulls.GALLEOUS_HEAD.get(), SowSkulls.GALLEOUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.GRIM, GrimEntity.TEXTURE, SowSkulls.GRIM_HEAD.get(), SowSkulls.GRIM_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.HADION, HadionEntity.TEXTURE, HadionEntity.TEXTURE_MARKER, HadionEntity.COLOR, SowSkulls.HADION_HEAD.get(), SowSkulls.HADION_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.HAWKEN, HawkenEntity.TEXTURE, SowSkulls.HAWKEN_HEAD.get(), SowSkulls.HAWKEN_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.HUBRIS, HubrisEntity.TEXTURE, HubrisEntity.TEXTURE_MARKER, HubrisEntity.COLOR, SowSkulls.HUBRIS_HEAD.get(), SowSkulls.HUBRIS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.IGNEOUS, IgneousEntity.TEXTURE, SowSkulls.IGNEOUS_HEAD.get(), SowSkulls.IGNEOUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.INGRESSSUS, IngresssusEntity.TEXTURE, IngresssusEntity.TEXTURE_MARKER, IngresssusEntity.COLOR, SowSkulls.INGRESSSUS_HEAD.get(), SowSkulls.INGRESSSUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.JALKAR, JalkarEntity.TEXTURE, SowSkulls.JALKAR_HEAD.get(), SowSkulls.JALKAR_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.KIYOSHI, KiyoshiEntity.TEXTURE, SowSkulls.KIYOSHI_HEAD.get(), SowSkulls.KIYOSHI_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.LUCAN, LucanEntity.TEXTURE, SowSkulls.LUCAN_HEAD.get(), SowSkulls.LUCAN_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.LUCIDIUS, LucidiusEntity.TEXTURE, LucidiusEntity.TEXTURE_MARKER, LucidiusEntity.COLOR, SowSkulls.LUCIDIUS_HEAD.get(), SowSkulls.LUCIDIUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.MARCUS, MarcusEntity.TEXTURE, SowSkulls.MARCUS_HEAD.get(), SowSkulls.MARCUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.MARSHALL, MarshallEntity.TEXTURE, SowSkulls.MARSHALL_HEAD.get(), SowSkulls.MARSHALL_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.MASANI, MasaniEntity.TEXTURE, SowSkulls.MASANI_HEAD.get(), SowSkulls.MASANI_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.MRFINCH, MrfinchEntity.TEXTURE, SowSkulls.MRFINCH_HEAD.get(), SowSkulls.MRFINCH_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.NECROLORD, NecrolordEntity.TEXTURE, SowSkulls.NECROLORD_HEAD.get(), SowSkulls.NECROLORD_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.NIIKA, NiikaEntity.TEXTURE, SowSkulls.NIIKA_HEAD.get(), SowSkulls.NIIKA_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.NITSUKE, NitsukeEntity.TEXTURE, SowSkulls.NITSUKE_HEAD.get(), SowSkulls.NITSUKE_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.OSIVIAN, OsivianEntity.TEXTURE, OsivianEntity.TEXTURE_MARKER, OsivianEntity.COLOR, SowSkulls.OSIVIAN_HEAD.get(), SowSkulls.OSIVIAN_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.PYTHUS, PythusEntity.TEXTURE, SowSkulls.PYTHUS_HEAD.get(), SowSkulls.PYTHUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.RIA, RiaEntity.TEXTURE, RiaEntity.TEXTURE_MARKER, RiaEntity.COLOR, SowSkulls.RIA_HEAD.get(), SowSkulls.RIA_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.SAXON, SaxonEntity.TEXTURE, SowSkulls.SAXON_HEAD.get(), SowSkulls.SAXON_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.SENN, SennEntity.TEXTURE, SennEntity.TEXTURE_MARKER, SennEntity.COLOR, SowSkulls.SENN_HEAD.get(), SowSkulls.SENN_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.SIDERIAN, SiderianEntity.TEXTURE, SiderianEntity.TEXTURE_MARKER, SiderianEntity.COLOR, SowSkulls.SIDERIAN_HEAD.get(), SowSkulls.SIDERIAN_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.SULLIMAN, SullimanEntity.TEXTURE, SowSkulls.SULLIMAN_HEAD.get(), SowSkulls.SULLIMAN_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.THALLEOUS, ThalleousEntity.TEXTURE, ThalleousEntity.TEXTURE_MARKER, ThalleousEntity.COLOR, SowSkulls.THALLEOUS_HEAD.get(), SowSkulls.THALLEOUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.TREVOR, TrevorEntity.TEXTURE, SowSkulls.TREVOR_HEAD.get(), SowSkulls.TREVOR_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.TYGREN, TygrenEntity.TEXTURE, TygrenEntity.TEXTURE_MARKER, TygrenEntity.COLOR, SowSkulls.TYGREN_HEAD.get(), SowSkulls.TYGREN_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.VAL, ValEntity.TEXTURE, ValEntity.TEXTURE_MARKER, ValEntity.COLOR, SowSkulls.VAL_HEAD.get(), SowSkulls.VAL_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.VULCANNUS, VulcannusEntity.TEXTURE, SowSkulls.PYTHUS_HEAD.get(), SowSkulls.PYTHUS_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.XARIA, XariaEntity.TEXTURE, SowSkulls.XARIA_HEAD.get(), SowSkulls.XARIA_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.YUJUKI, YujukiEntity.TEXTURE, SowSkulls.YUJUKI_HEAD.get(), SowSkulls.YUJUKI_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.ZINAIDA, ZinaidaEntity.TEXTURE, ZinaidaEntity.TEXTURE_MARKER, ZinaidaEntity.COLOR, SowSkulls.ZINAIDA_HEAD.get(), SowSkulls.ZINAIDA_WALL_HEAD.get());
        SkullManager.registerSkull(SowSkulls.SkullType.ZULIUS, ZuliusEntity.TEXTURE, ZuliusEntity.TEXTURE_MARKER, ZuliusEntity.COLOR, SowSkulls.ZULIUS_HEAD.get(), SowSkulls.ZULIUS_WALL_HEAD.get());
    }

    public static void registerParticleRenderer() {
        ParticleProviderRegistry.register(SowParticles.SONG_EFFECT, SongEffectParticle::create);
        ParticleProviderRegistry.register(SowParticles.AGGROBLAST, AggroblastParticle::create);
        ParticleProviderRegistry.register(SowParticles.LASER, LaserParticle::create);
    }

    public static void registerBlockEntityRenderer() {
        BlockEntityRendererRegistry.register(SowBlockEntities.ARDONI_GRAVE.get(), ctx -> new ArdoniGraveBlockEntityRenderer());
        BlockEntityRendererRegistry.register(SowBlockEntities.WALLS_OF_TIME.get(), WallsOfTimeBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(SowBlockEntities.SONG_CUBE.get(), SongCubeBlockEntityRenderer::new);
    }

    public static void registerRenderType() {
        RenderTypeRegistry.register(RenderLayer.getCutout(), SowBlocks.PEAS.get(), SowDelight.WOODEN_FOOD_PLATE.get(), SowDelight.BAMBOO_FOOD_PLATE.get());
        RenderTypeRegistry.register(RenderLayer.getTranslucent(), SowBlocks.MOBILIBOUNCE_PLATFORM.get(), SowBlocks.PROTE_BARRIER.get());
    }

    public static void registerModelPredicate() {
        ItemPropertiesRegistry.registerGeneric(Identifier.of(SongsOfWar.MOD_ID, SongStoneItem.POWER_KEY), (stack, world, entity, seed) -> (stack.hasNbt() && stack.getOrCreateNbt().contains(SongStoneItem.POWER_KEY, NbtElement.STRING_TYPE) ? AbilityCategory.byId(Identifier.tryParse(stack.getOrCreateNbt().getString(SongStoneItem.POWER_KEY))).map(x -> SowAbilityCategory.ALL.get().indexOf(x)).orElse(-1) + 1.0F : 0.0F) / SowAbilityCategory.values().length);
        ItemPropertiesRegistry.registerGeneric(Identifier.of(SongsOfWar.MOD_ID, AdjustedSongStoneItem.NEAR_KEY), (stack, world, entity, seed) -> stack.hasNbt() ? stack.getOrCreateNbt().getFloat(AdjustedSongStoneItem.NEAR_KEY) : 0);
    }
}
