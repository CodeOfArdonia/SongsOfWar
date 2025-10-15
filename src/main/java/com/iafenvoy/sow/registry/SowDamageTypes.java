package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public final class SowDamageTypes {
    public static final ResourceKey<DamageType> AGGRODETONATE = of("aggrodetonate");
    public static final ResourceKey<DamageType> AGGROQUAKE = of("aggroquake");
    public static final ResourceKey<DamageType> AGGROSPHERE = of("aggrosphere");
    public static final ResourceKey<DamageType> AGGROSTORM = of("aggrostorm");
    public static final ResourceKey<DamageType> AGGROSHARD = of("aggroshard");
    public static final ResourceKey<DamageType> AGGROBLAST = of("aggroblast");
    public static final ResourceKey<DamageType> AGGROBEAM = of("aggrobeam");

    private static ResourceKey<DamageType> of(String id) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, id));
    }
}
