package net.antaner.travelia;

import net.antaner.travelia.inventory.BoxScreenHandler;
import net.antaner.travelia.payload.OpenBackpackPayload;
import net.antaner.travelia.payload.OpenPortableCraftingPayload;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.*;
import net.minecraft.text.Text;
import org.jspecify.annotations.Nullable;

public class ModNetworking {

    public static void registerServer() {

        PayloadTypeRegistry.playC2S().register(
                OpenPortableCraftingPayload.ID,
                OpenPortableCraftingPayload.CODEC
        );

        ServerPlayNetworking.registerGlobalReceiver(
                OpenPortableCraftingPayload.ID,
                (payload, context) -> {
                    context.player().openHandledScreen(
                            new SimpleNamedScreenHandlerFactory((syncId, inventory, player) ->
                                    new CraftingScreenHandler(syncId, inventory),
                                    Text.literal("Portable Crafting Table")
                            )
                    );
                }
        );


        PayloadTypeRegistry.playC2S().register(
                OpenBackpackPayload.ID,
                OpenBackpackPayload.CODEC
        );

        ServerPlayNetworking.registerGlobalReceiver(
                OpenBackpackPayload.ID,
                (payload, context) -> {
                    context.player().openHandledScreen(new NamedScreenHandlerFactory() {
                        @Override
                        public Text getDisplayName() {
                            return Text.of("Backpack");
                        }

                        @Override
                        public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                            return new GenericContainerScreenHandler(Travelia.BOX_SCREEN_HANDLER, syncId, playerInventory, new SimpleInventory(27), 3);
                        }

                        @Override
                        public boolean shouldCloseCurrentScreen() {
                            return false;
                        }
                    });
                }
        );
    }
}
