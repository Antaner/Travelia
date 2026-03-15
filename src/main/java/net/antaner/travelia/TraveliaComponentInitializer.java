package net.antaner.travelia;

import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class TraveliaComponentInitializer implements EntityComponentInitializer {

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(TraveliaComponents.PLAYER_DATA, player -> new TraveliaPlayerData(), RespawnCopyStrategy.ALWAYS_COPY);
    }
}
