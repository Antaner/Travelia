package net.antaner.travelia;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Travelia implements ModInitializer {
	public static final String MOD_ID = "travelia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[Travelia] Initializing");
	}
}