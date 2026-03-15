package net.antaner.travelia;

import net.antaner.travelia.inventory.BoxScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class TraveliaModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(Travelia.BOX_SCREEN_HANDLER, BoxScreen::new);
    }
}
