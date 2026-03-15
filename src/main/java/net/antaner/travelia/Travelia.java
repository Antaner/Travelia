package net.antaner.travelia;

import net.antaner.travelia.inventory.BoxScreenHandler;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Travelia implements ModInitializer {
	public static final String MOD_ID = "travelia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER,
			Identifier.of("travelia", "box_screen"), new ScreenHandlerType<>(BoxScreenHandler::new, FeatureSet.empty()));

	@Override
	public void onInitialize() {
		ModNetworking.registerServer();

		/*PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
			if (world.isClient()) return;
			player.openHandledScreen(new NamedScreenHandlerFactory() {
				@Override
				public Text getDisplayName() {
					return Text.of("OMG CUSTOM INV!!");
				}

				@Override
				public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
					return new BoxScreenHandler(syncId, playerInventory, rows);
				}
			});

			TraveliaPlayerData data = TraveliaComponents.PLAYER_DATA.get(player);
			data.setValue(data.getValue() + 1);

			player.sendMessage(Text.of("§6OMG DEINE VALUE IST BEI: §a" + data.getValue() + "§&!!!!!"), false);

		});*/
	}
}