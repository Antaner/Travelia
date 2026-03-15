package net.antaner.travelia.payload;

import net.antaner.travelia.Travelia;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record OpenBackpackPayload() implements CustomPayload {

    public static final Id<OpenBackpackPayload> ID = new Id<>(Identifier.of(Travelia.MOD_ID, "open_backpack"));

    public static final PacketCodec<RegistryByteBuf, OpenBackpackPayload> CODEC = PacketCodec.unit(new OpenBackpackPayload());

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
