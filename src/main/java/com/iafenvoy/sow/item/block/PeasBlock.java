package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.registry.SowDelight;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.NotNull;

public class PeasBlock extends CropBlock {
    public PeasBlock() {
        super(Properties.of().noOcclusion().noCollission().randomTicks().instabreak().sound(SoundType.CROP));
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return SowDelight.PEAS.get();
    }
}
