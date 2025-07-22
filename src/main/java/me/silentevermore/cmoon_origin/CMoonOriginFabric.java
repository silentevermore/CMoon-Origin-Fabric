package me.silentevermore.cmoon_origin;

import io.github.apace100.origins.Origins;
import io.github.apace100.origins.component.OriginComponent;
import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.origin.OriginLayers;
import io.github.apace100.origins.registry.ModComponents;
import me.silentevermore.cmoon_origin.command.CMoonCommands;
import me.silentevermore.cmoon_origin.init.ModEffects;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class CMoonOriginFabric implements ModInitializer{
	public static final String MOD_ID = "cmoon_origin";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize(){
		LOGGER.info("Cujoh... Jolyne!");
		//register effects
		ModEffects.register();
		//register events
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult)->{
            //prevent player from hitting others, if it has C-Moon origin
			var originComponent = ModComponents.ORIGIN.get(player);
			var origin=originComponent.getOrigin(OriginLayers.getLayer(Identifier.of(Origins.MODID, "origin")));
			if (!player.getWorld().isClient() && origin!=null && origin.getIdentifier().equals(Identifier.of(MOD_ID, "cmoon"))){
				((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(ModEffects.INVERSED_LIMBS, 100, 1, false, false));
				return ActionResult.FAIL;
			}
			return ActionResult.PASS;
        });
		//register commands
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			CMoonCommands.register(dispatcher);
		});
	}
}