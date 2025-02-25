package VendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemShelf {

    // The list contains total unique items in a shelf.
    List<Item> items;
    // The map contains count of each item in a shelf.
    Map<Integer, Integer> itemCountMap;
    int shelfCode;

    public ItemShelf(int code) {
        this.shelfCode = code;
        items = new ArrayList<>();
        itemCountMap = new HashMap<>();
    }

    public void addItem(Item item) {
        Integer itemCount = itemCountMap.get(item.itemCode);
        if (itemCount == null) {
            items.add(item);
            itemCount = 0;
        }
        itemCountMap.put(item.itemCode, itemCount + 1);
    }

    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            itemCountMap.remove(item.itemCode);
            System.out.println("Successfully cleared item: " + item.getItemType());
        }
        else {
            System.out.println("Item does not exist!");
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
