package VendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<ItemShelf> itemShelves;
    Map<Integer, Integer> itemPrice;

    public Inventory() {
        itemShelves = new ArrayList<>();
        itemPrice = new HashMap<>();
    }

    public void addItemShelfToInventory(ItemShelf itemShelf) {
        itemShelves.add(itemShelf);
        for (Item item : itemShelf.getItems()) {
            itemPrice.put(item.itemCode, item.price);
        }
    }

    public void removeItemFromShelf(int itemCode) {
        for (ItemShelf itemShelf : itemShelves) {
            for (Item item : itemShelf.getItems()) {
                if (item.getItemCode() == itemCode) {
                    itemShelf.removeItem(item);
                    break;
                }
            }
        }
    }

    public void clearInventory() {
        itemShelves.clear();
    }

    public Map<Integer, Integer> getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Map<Integer, Integer> itemPrice) {
        this.itemPrice = itemPrice;
    }
}
