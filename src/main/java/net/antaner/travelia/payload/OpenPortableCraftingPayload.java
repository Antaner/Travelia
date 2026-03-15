package net.antaner.travelia.payload;

import net.antaner.travelia.Travelia;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record OpenPortableCraftingPayload() implements CustomPayload {

    public static final Id<OpenPortableCraftingPayload> ID = new Id<>(Identifier.of(Travelia.MOD_ID, "open_portable_crafting"));

    public static final PacketCodec<RegistryByteBuf, OpenPortableCraftingPayload> CODEC = PacketCodec.unit(new OpenPortableCraftingPayload());

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
