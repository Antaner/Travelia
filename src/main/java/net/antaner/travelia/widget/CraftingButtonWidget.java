package net.antaner.travelia.widget;

import net.antaner.travelia.payload.OpenPortableCraftingPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.input.AbstractInput;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CraftingButtonWidget extends PressableWidget {

    private static final Identifier PORTABLE_CRAFTING_TEXTURE =
            Identifier.of("travelia", "textures/gui/sprites/portable_crafting_button.png");
    private static final Identifier PORTABLE_CRAFTING_TEXTURE_HOVERED =
            Identifier.of("travelia", "textures/gui/sprites/portable_crafting_button_highlighted.png");

    public CraftingButtonWidget(int x, int y, int width, int height) {
        super(x, y, width, height, Text.empty());
    }

    @Override
    public void onPress(AbstractInput input) {
        ClientPlayNetworking.send(new OpenPortableCraftingPayload());
    }

    @Override
    protected void drawIcon(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
            context.drawTexture(RenderPipelines.GUI_TEXTURED,
                    this.isHovered() ? PORTABLE_CRAFTING_TEXTURE_HOVERED : PORTABLE_CRAFTING_TEXTURE,
                    this.getX(),
                    this.getY(),
                    0,
                    0,
                    this.getWidth(),
                    this.getHeight(),
                    20,
                    18);
    }



    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {

    }
}
