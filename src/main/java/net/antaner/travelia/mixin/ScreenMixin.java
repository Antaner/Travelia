package net.antaner.travelia.mixin;

import net.antaner.travelia.Travelia;
import net.antaner.travelia.inventory.BoxScreenHandler;
import net.antaner.travelia.widget.BackpackButtonWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreen.class)
public abstract class ScreenMixin<T extends ScreenHandler> extends Screen {

    @Shadow protected int x;
    @Shadow protected int y;
    @Shadow protected int backgroundHeight;
    @Shadow protected int backgroundWidth;
    @Shadow protected T handler;

    private PressableWidget traveliaBackpackButton;

    protected ScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void traveliaAddBackpackButton(CallbackInfo ci) {
        this.traveliaBackpackButton = new BackpackButtonWidget(this.x, this.y + backgroundHeight - (handler instanceof GenericContainerScreenHandler || handler instanceof BoxScreenHandler ? 4:3), 33, 32);
        this.addDrawableChild(this.traveliaBackpackButton);
    }

    @Inject(method = "handledScreenTick", at = @At("TAIL"))
    private void traveliaUpdateButtonPosition(CallbackInfo ci) {
        if(this.traveliaBackpackButton != null) {
            this.traveliaBackpackButton.setPosition(
                    this.x,
                    this.y + backgroundHeight - (handler instanceof GenericContainerScreenHandler || handler instanceof BoxScreenHandler ? 4:3)
            );
        }

    }
}
