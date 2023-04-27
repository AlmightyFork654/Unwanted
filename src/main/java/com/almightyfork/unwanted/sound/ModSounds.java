package com.almightyfork.unwanted.sound;

import com.almightyfork.unwanted.Unwanted;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Unwanted.MODID);


    //sounds
    public static final RegistryObject<SoundEvent> DETECTOR_FOUND_ORE = registerSoundEvent("detector_found_ore");

    public static RegistryObject<SoundEvent> DARKNESS = registerSoundEvent("darkness");

    public static RegistryObject<SoundEvent> CAVE_WHISPERS = registerSoundEvent("cave_whispers");

    public static RegistryObject<SoundEvent> EMBARIUM_BREAK = registerSoundEvent("embarium_break");
    public static RegistryObject<SoundEvent> EMBARIUM_STEP = registerSoundEvent("embarium_step");
    public static RegistryObject<SoundEvent> EMBARIUM_PLACE = registerSoundEvent("embarium_place");
    public static RegistryObject<SoundEvent> EMBARIUM_HIT = registerSoundEvent("embarium_hit");
    public static RegistryObject<SoundEvent> EMBARIUM_FALL = registerSoundEvent("embarium_fall");

    public static final ForgeSoundType EMBARIUM_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.EMBARIUM_BREAK, ModSounds.EMBARIUM_STEP, ModSounds.EMBARIUM_PLACE,
            ModSounds.EMBARIUM_HIT, ModSounds.EMBARIUM_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Unwanted.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
