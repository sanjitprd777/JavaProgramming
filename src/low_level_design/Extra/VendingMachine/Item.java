package VendingMachine;

public class Item {
    int itemCode;
    ItemType itemType;

    int price;

    public Item(int code, ItemType type, int price) {
        this.itemCode = code;
        this.itemType = type;
        this.price = price;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
