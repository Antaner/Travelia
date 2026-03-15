package net.antaner.travelia.widget;

import net.antaner.travelia.payload.OpenBackpackPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.input.AbstractInput;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BackpackButtonWidget extends PressableWidget {

    private static final Identifier BACKPACK_TEXTURE =
            Identifier.of("travelia", "textures/gui/sprites/backpack_button.png");
    private static final Identifier BACKPACK_TEXTURE_HOVERED =
            Identifier.of("travelia", "textures/gui/sprites/backpack_button_highlighted.png");

    public BackpackButtonWidget(int x, int y, int width, int height) {
        super(x, y, width, height, Text.empty());
    }

    @Override
    public void onPress(AbstractInput input) {
        ClientPlayNetworking.send(new OpenBackpackPayload());
    }

    @Override
    protected void drawIcon(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
            context.drawTexture(RenderPipelines.GUI_TEXTURED,
                    this.isHovered() ? BACKPACK_TEXTURE_HOVERED : BACKPACK_TEXTURE,
                    this.getX(),
                    this.getY(),
                    0,
                    0,
                    this.getWidth(),
                    this.getHeight(),
                    33,
                    32);
    }



    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {

    }
}
