package com.iafenvoy.sow.power;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.power.type.AbstractSongPower;
import com.iafenvoy.sow.power.type.DummySongPower;
import com.iafenvoy.sow.registry.SowSounds;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;

import java.util.*;
import java.util.function.Supplier;

public enum PowerCategory {
    AGGRESSIUM("aggressium", new Color4i(237, 28, 36, 255), 231,SowSounds.AGGRESSIUM),
    MOBILIUM("mobilium", new Color4i(255, 242, 0, 255), 9035,SowSounds.MOBILIUM),
    PROTISIUM("protisium", new Color4i(115, 251, 253, 255), 4290,SowSounds.PROTISIUM),
    SUPPORTIUM("supportium", new Color4i(117, 249, 77, 255), 10,SowSounds.SUPPORTIUM);
    private final String id;
    private final Color4i color;
    private final long randomOffset;
    private final Supplier<SoundEvent> sound;
    private final List<AbstractSongPower<?>> powers = new ArrayList<>();
    private final Map<String, AbstractSongPower<?>> byId = new HashMap<>();

    PowerCategory(String id, Color4i color, long randomOffset, Supplier<SoundEvent> sound) {
        this.id = id;
        this.color = color;
        this.randomOffset = randomOffset;
        this.sound = sound;
    }

    public String getId() {
        return this.id;
    }

    public Color4i getColor() {
        return this.color;
    }

    public long getRandomOffset() {
        return this.randomOffset;
    }

    public SoundEvent getSound() {
        return this.sound.get();
    }

    public MutableText appendColor(MutableText text) {
        return text.fillStyle(Style.EMPTY.withColor(this.getColor().getIntValue()));
    }

    public void registerPower(AbstractSongPower<?> power) {
        this.powers.add(power);
        AbstractSongPower<?> p = this.byId.put(power.getId(), power);
        if (p != null)
            throw new IllegalArgumentException("Duplicated id " + p.getId() + " for song power type " + this.id + "!");
    }

    public AbstractSongPower<?> getPowerById(String id) {
        return this.powers.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(DummySongPower.EMPTY);
    }

    public AbstractSongPower<?> randomOne() {
        return RandomHelper.randomOne(this.powers);
    }

    public static Optional<PowerCategory> byId(String id) {
        return Arrays.stream(values()).filter(x -> x.getId().equals(id)).findFirst();
    }
}
