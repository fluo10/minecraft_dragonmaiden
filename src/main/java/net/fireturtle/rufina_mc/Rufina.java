package net.fireturtle.rufina_mc;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rufina implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("rufina_mc");
	public static final Item HALBERD = new Item(new FabricItemSettings());

	public static final EntityType<RufinaEntity> RUFINA = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier("fireturtle", "rufina"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RufinaEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM, new Identifier("rufina_mc", "halberd"), HALBERD);
		LOGGER.info("Hello Fabric world!");
		FabricDefaultAttributeRegistry.register(RUFINA, RufinaEntity.createMobAttributes());
	}
}