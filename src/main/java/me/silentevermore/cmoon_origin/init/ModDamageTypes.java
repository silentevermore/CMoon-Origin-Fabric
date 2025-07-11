package me.silentevermore.cmoon_origin.init;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import static me.silentevermore.cmoon_origin.CMoonOriginFabric.*;

public class ModDamageTypes{
    public static final RegistryKey<DamageType> INVERSED_LIMBS=RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(MOD_ID, "inversed_limbs"));

    public static RegistryEntry<DamageType> entryOf(World world, RegistryKey<DamageType> key){
        return world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key);
    }
}
