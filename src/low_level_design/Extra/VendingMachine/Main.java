package VendingMachine;

public class Main {

    public static void main(String[] args) {
        // Create Inventory
        Inventory inventory = createInventory();

        VendingMachine vendingMachine = new VendingMachine(inventory);

        vendingMachine.printState();

        vendingMachine.state.pressInsertCoinButton();

        vendingMachine.printState();

        vendingMachine.state.insertCoin();

        vendingMachine.state.pressProductSelectionButton();

        vendingMachine.printState();

        vendingMachine.state.productSelection();

        vendingMachine.printState();

        vendingMachine.state.dispenseProduct();

        vendingMachine.printState();
    }

    static Inventory createInventory() {
        Inventory inventory = new Inventory();
        ItemShelf itemShelf = new ItemShelf(1);
        itemShelf.addItem(new Item(101, ItemType.COKE, 40));
        itemShelf.addItem(new Item(101, ItemType.COKE, 40));
        itemShelf.addItem(new Item(101, ItemType.COKE, 40));
        itemShelf.addItem(new Item(102, ItemType.CASHEW, 50));
        itemShelf.addItem(new Item(102, ItemType.CASHEW, 50));

        inventory.addItemShelfToInventory(itemShelf);

        itemShelf = new ItemShelf(2);
        itemShelf.addItem(new Item(201, ItemType.FANTA, 35));
        itemShelf.addItem(new Item(201, ItemType.FANTA, 35));
        itemShelf.addItem(new Item(202, ItemType.MIXTURE, 5));
        itemShelf.addItem(new Item(202, ItemType.MIXTURE, 5));
        itemShelf.addItem(new Item(202, ItemType.MIXTURE, 5));

        inventory.addItemShelfToInventory(itemShelf);

        itemShelf = new ItemShelf(3);
        itemShelf.addItem(new Item(301, ItemType.KITKAT, 20));
        itemShelf.addItem(new Item(301, ItemType.KITKAT, 20));
        itemShelf.addItem(new Item(302, ItemType.OREO, 30));
        itemShelf.addItem(new Item(302, ItemType.OREO, 30));
        itemShelf.addItem(new Item(302, ItemType.OREO, 30));

        inventory.addItemShelfToInventory(itemShelf);

        return inventory;
    }
}
