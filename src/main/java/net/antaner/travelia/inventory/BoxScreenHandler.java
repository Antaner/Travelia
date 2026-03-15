package net.antaner.travelia.inventory;

import lombok.Getter;
import net.antaner.travelia.Travelia;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class BoxScreenHandler extends ScreenHandler{

    @Getter
    private final Inventory inventory;
    @Getter
    private final int rows;

    public BoxScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, 3);
    }

    public BoxScreenHandler(int syncId, PlayerInventory playerInventory, int rows) {
        this(syncId, playerInventory, new SimpleInventory(rows * 9), rows);
    }

    public BoxScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, int rows) {
        super(Travelia.BOX_SCREEN_HANDLER, syncId);
        checkSize(inventory, rows * 9);
        this.inventory = inventory;
        this.rows = rows;
        inventory.onOpen(playerInventory.player);
        int i = 18;
        this.addInventorySlots(inventory, 8, 18);
        int j = 18 + this.rows * 18 + 13;
        this.addPlayerSlots(playerInventory, 8, j);
    }

    private void addInventorySlots(Inventory inventory, int left, int top) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(inventory, j + i * 9, left + j * 18, top + i * 18));
            }
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot < this.rows * 9) {
                if (!this.insertItem(itemStack2, this.rows * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 0, this.rows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }
        }

        return itemStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
