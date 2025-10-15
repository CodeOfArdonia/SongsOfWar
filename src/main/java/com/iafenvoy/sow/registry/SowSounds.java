package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

//FIXME::Constants
public final class SowSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, SongsOfWar.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> SOW_DEATH = register("sow_death");
    //song cube
    public static final DeferredHolder<SoundEvent, SoundEvent> AGGRESSIUM = register("aggressium");
    public static final DeferredHolder<SoundEvent, SoundEvent> MOBILIUM = register("mobilium");
    public static final DeferredHolder<SoundEvent, SoundEvent> PROTISIUM = register("protisium");
    public static final DeferredHolder<SoundEvent, SoundEvent> SUPPORTIUM = register("supportium");
    //power
    public static final DeferredHolder<SoundEvent, SoundEvent> AGGROBEAM = register("aggrobeam");
    public static final DeferredHolder<SoundEvent, SoundEvent> AGGROBLAST = register("aggroblast");
    public static final DeferredHolder<SoundEvent, SoundEvent> AGGRODETONATE = register("aggrodetonate");
    public static final DeferredHolder<SoundEvent, SoundEvent> AGGROQUAKE = register("aggroquake");
    public static final DeferredHolder<SoundEvent, SoundEvent> AGGROSPHERE = register("aggrosphere");
    public static final DeferredHolder<SoundEvent, SoundEvent> AGGROSHARD = register("aggroshard");
    public static final DeferredHolder<SoundEvent, SoundEvent> AGGROSTORM = register("aggrostorm");
    public static final DeferredHolder<SoundEvent, SoundEvent> MOBILIBOUNCE = register("mobilibounce");
    public static final DeferredHolder<SoundEvent, SoundEvent> MOBILIBURST = register("mobiliburst");
    public static final DeferredHolder<SoundEvent, SoundEvent> MOBILIFLASH = register("mobiliflash");
    public static final DeferredHolder<SoundEvent, SoundEvent> MOBILIGLIDE = register("mobiliglide");
    public static final DeferredHolder<SoundEvent, SoundEvent> MOBILILEAP = register("mobilileap");
    public static final DeferredHolder<SoundEvent, SoundEvent> MOBILIWINGS = register("mobiliwings");
    public static final DeferredHolder<SoundEvent, SoundEvent> PROTEARMOR = register("protearmor");
    public static final DeferredHolder<SoundEvent, SoundEvent> PROTEARMOR_UNAPPLY = register("protearmor_unapply");
    public static final DeferredHolder<SoundEvent, SoundEvent> PROTEBARRIER = register("protebarrier");
    public static final DeferredHolder<SoundEvent, SoundEvent> PROTECLONE = register("proteclone");
    public static final DeferredHolder<SoundEvent, SoundEvent> PROTEHEAL = register("proteheal");
    public static final DeferredHolder<SoundEvent, SoundEvent> PROTEPOINT = register("protepoint");
    public static final DeferredHolder<SoundEvent, SoundEvent> PROTESPHERE = register("protesphere");
    public static final DeferredHolder<SoundEvent, SoundEvent> PROTESPHERE_UNAPPLY = register("protesphere_unapply");
    public static final DeferredHolder<SoundEvent, SoundEvent> SUPPOREKESIS = register("supporekesis");
    public static final DeferredHolder<SoundEvent, SoundEvent> SUPPOROFORM = register("supporoform");
    public static final DeferredHolder<SoundEvent, SoundEvent> SUPPOROLIFT = register("supporolift");
    public static final DeferredHolder<SoundEvent, SoundEvent> SUPPOROSPIKE = register("supporospike");

    private static DeferredHolder<SoundEvent, SoundEvent> register(String id) {
        return REGISTRY.register(id, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, id)));
    }
}
