package me.silentevermore.cmoon_origin.effect;

import me.silentevermore.cmoon_origin.init.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import static me.silentevermore.cmoon_origin.CMoonOriginFabric.*;

public class InversedLimbs extends StatusEffect{
    public InversedLimbs() {
        super(StatusEffectCategory.HARMFUL, 0xFFFFFF);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return duration%10==0;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier){
        if (entity.isAlive()) entity.damage(new DamageSource(ModDamageTypes.entryOf(entity.getWorld(), ModDamageTypes.INVERSED_LIMBS), entity.getPos()), 2);
    }
}
