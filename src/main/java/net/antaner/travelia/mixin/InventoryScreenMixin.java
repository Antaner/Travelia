package net.antaner.travelia.mixin;

import net.antaner.travelia.widget.BackpackButtonWidget;
import net.antaner.travelia.widget.CraftingButtonWidget;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin extends HandledScreen<PlayerScreenHandler> {

	private PressableWidget traveliaCraftingButton;
	private static final int CRAFTING_BUTTON_X = 140;
	private static final int CRAFTING_BUTTON_Y = 61;


	protected InventoryScreenMixin(PlayerScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}

	@Inject(method = "init", at = @At("TAIL"))
	private void traveliaAddCraftingButton(CallbackInfo ci) {
		this.traveliaCraftingButton = new CraftingButtonWidget(this.x + CRAFTING_BUTTON_X, this.y + CRAFTING_BUTTON_Y, 20, 18);
		this.addDrawableChild(this.traveliaCraftingButton);
	}



	@Inject(method = "handledScreenTick", at = @At("TAIL"))
	private void traveliaUpdateButtonPosition(CallbackInfo ci) {
		if (this.traveliaCraftingButton != null) {
			this.traveliaCraftingButton.setPosition(
					this.x + CRAFTING_BUTTON_X,
					this.y + CRAFTING_BUTTON_Y
			);
		}

	}

}