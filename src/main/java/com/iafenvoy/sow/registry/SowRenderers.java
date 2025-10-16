package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.registry.NeptuneDataComponents;
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
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import com.iafenvoy.sow.render.block.ArdoniGraveBlockEntityRenderer;
import com.iafenvoy.sow.render.block.SongCubeBlockEntityRenderer;
import com.iafenvoy.sow.render.block.WallsOfTimeBlockEntityRenderer;
import com.iafenvoy.sow.render.entity.ArdoniEntityRenderer;
import com.iafenvoy.sow.render.entity.MagnoriteEntityRenderer;
import com.iafenvoy.sow.render.power.entity.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(Dist.CLIENT)
public final class SowRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        //Entity
        event.registerEntityRenderer(SowEntities.AGGRO_SPHERE.get(), AggroSphereRenderer::new);
        event.registerEntityRenderer(SowEntities.AGGRO_DETONATE.get(), AggroDetonateRenderer::new);
        event.registerEntityRenderer(SowEntities.AGGRO_SHARD.get(), AggroShardRenderer::new);
        event.registerEntityRenderer(SowEntities.PROTE_CLONE.get(), ProteCloneRenderer::new);
        event.registerEntityRenderer(SowEntities.SUPPORO_SPIKE.get(), SupporoSpikeRenderer::new);

        event.registerEntityRenderer(SowEntities.NONE_TYPE_ARDONI.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.VOLTARIS_ARDONI.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.SENDARIS_ARDONI.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MENDORIS_ARDONI.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.NESTORIS_ARDONI.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.KALTARIS_ARDONI.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.GRIM.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.GLACIAN.get(), CommonPlayerLikeEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.ACHILLEAN.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.INGRESSSUS.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.AEGUS.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.KALTARIS_MASTER.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MENDORIS_MASTER.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.SENDARIS_MASTER.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.HUBRIS.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.RIA.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.THALLEOUS.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.GALLEOUS.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.SENN.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.ZULIUS.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.TYGREN.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.OSIVIAN.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.LUCIDIUS.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.ZINAIDA.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.AURELIUS.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.HADION.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.VAL.get(), ArdoniEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.SIDERIAN.get(), ArdoniEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.FELDEN.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.KIYOSHI.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.NIIKA.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MASANI.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.NITSUKE.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.YUJUKI.get(), CommonPlayerLikeEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.ABBIGAIL.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.ALEC.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.BARTENDER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.CIVILIAN.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.DARLENE.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.EDDY.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.HAWKEN.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.HORSE_RIDER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.LUCAN.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MARCUS.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MARSHALL.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MRFINCH.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.SULLIMAN.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.ALLISTER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.DENNY.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.JALKAR.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.SAXON.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.TREVOR.get(), CommonPlayerLikeEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.IGNEOUS.get(), MagnoriteEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MAGNORITE.get(), MagnoriteEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.NECROMANCER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.NECROLORD.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.XARIA.get(), CommonPlayerLikeEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.NETHARAN.get(), CommonPlayerLikeWithMarkerEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.CHRONOS.get(), CommonPlayerLikeWithMarkerEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.PYTHUS.get(), CommonPlayerLikeWithMarkerEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.VULCANNUS.get(), CommonPlayerLikeWithMarkerEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.HUSK.get(), CommonPlayerLikeWithMarkerEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.STRAY.get(), CommonPlayerLikeWithMarkerEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.ZOMBIE.get(), CommonPlayerLikeWithMarkerEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.CONCHORD_GUARD.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.CROWN_PEAK_GUARD.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.CYDONIA_GUARD.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.ETHEREA_GUARD.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.FELDEN_GUARD.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.GENERAL_GUARD.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.HYDRAPHEL_GUARD.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.KARTHEN_GUARD.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.NORTHWIND_GUARD.get(), CommonPlayerLikeEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.CONCHORD_SOLDIER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.CROWN_PEAK_SOLDIER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.CYDONIA_SOLDIER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.ETHEREA_SOLDIER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.FELDEN_SOLDIER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.HYDRAPHEL_SOLDIER.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.NORTHWIND_SOLDIER.get(), CommonPlayerLikeEntityRenderer::new);

        event.registerEntityRenderer(SowEntities.ADVENTURER_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.BLACKSMITH_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.CHEF_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.FARMER_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.FEMALE_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.FISHER_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.LEATHER_WORKER_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MALE_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MERCHANT_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.MINER_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.OLD_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.POOR_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.SAILOR_FOLK.get(), CommonPlayerLikeEntityRenderer::new);
        event.registerEntityRenderer(SowEntities.SCHOLAR_FOLK.get(), CommonPlayerLikeEntityRenderer::new);

        //Block Entity
        event.registerBlockEntityRenderer(SowBlockEntities.ARDONI_GRAVE.get(), ctx -> new ArdoniGraveBlockEntityRenderer());
        event.registerBlockEntityRenderer(SowBlockEntities.WALLS_OF_TIME.get(), WallsOfTimeBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(SowBlockEntities.SONG_CUBE.get(), SongCubeBlockEntityRenderer::new);
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

    @SubscribeEvent
    public static void registerParticleRenderer(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(SowParticles.SONG_EFFECT.get(), SongEffectParticle::create);
        event.registerSpriteSet(SowParticles.AGGROBLAST.get(), AggroblastParticle::create);
        event.registerSpriteSet(SowParticles.LASER.get(), LaserParticle::create);
    }

    @SuppressWarnings("deprecation")
    public static void registerRenderType() {
        ItemBlockRenderTypes.setRenderLayer(SowDelight.PEAS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SowDelight.WOODEN_FOOD_PLATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SowDelight.BAMBOO_FOOD_PLATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SowBlocks.MOBILIBOUNCE_PLATFORM.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SowBlocks.PROTE_BARRIER.get(), RenderType.translucent());
    }

    public static void registerModelPredicate() {
        ItemProperties.registerGeneric(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, SongStoneItem.POWER_KEY), (stack, world, entity, seed) -> Optional.ofNullable(stack.get(NeptuneDataComponents.ABILITY_CATEGORY)).map(x -> SowAbilityCategories.ALL.get().indexOf(x)).orElse(-1) + 1.0F);
        ItemProperties.registerGeneric(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, AdjustedSongStoneItem.NEAR_KEY), (stack, world, entity, seed) -> stack.getOrDefault(SowDataComponents.SONG_STONE_NEAR, 0F));
    }
}
