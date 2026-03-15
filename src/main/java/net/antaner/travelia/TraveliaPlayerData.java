package net.antaner.travelia;


import lombok.Getter;
import lombok.Setter;
import net.minecraft.item.ItemStack;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import org.ladysnake.cca.api.v3.component.Component;

import java.util.ArrayList;
import java.util.List;

public class TraveliaPlayerData implements Component {

    @Getter
    @Setter
    public List<ItemStack> backpack;

    @Override
    public void readData(ReadView readView) {
        ReadView.ListReadView list = readView.getListReadView("backpack");
        if(list.isEmpty()) backpack = new ArrayList<>();
        else {

        }
    }

    @Override
    public void writeData(WriteView writeView) {
        
    }
}
