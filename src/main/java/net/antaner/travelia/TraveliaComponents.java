package net.antaner.travelia;

import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;

public class TraveliaComponents {

    public static final ComponentKey<TraveliaPlayerData> PLAYER_DATA =
            ComponentRegistry.getOrCreate(Identifier.of("travelia", "player_data"), TraveliaPlayerData.class);

}
