package VendingMachine.VendingStates;

public interface State {

    void pressInsertCoinButton();

    void insertCoin();

    void pressProductSelectionButton();

    void productSelection();

    void getChange(int amount);

    void dispenseProduct();

    void cancelOrRefund();

    void updateInventory();
}
