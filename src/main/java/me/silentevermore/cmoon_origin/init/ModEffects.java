package me.silentevermore.cmoon_origin.init;

import me.silentevermore.cmoon_origin.effect.InversedLimbs;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static me.silentevermore.cmoon_origin.CMoonOriginFabric.MOD_ID;

public class ModEffects{
    public static final StatusEffect INVERSED_LIMBS=new InversedLimbs();

    public static void register(){
        Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "inversed_limbs"), INVERSED_LIMBS);
    }
}
