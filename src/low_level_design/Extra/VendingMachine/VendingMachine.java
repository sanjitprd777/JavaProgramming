package VendingMachine;

import VendingMachine.VendingStates.Idle;
import VendingMachine.VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    State state;
    Inventory inventory;
    List<Coin> coins;

    public VendingMachine(Inventory inventory) {
        coins = new ArrayList<>();
        this.inventory = inventory;
        state = new Idle(this);
    }

    public void getState() {
        System.out.println(this.state.toString());
    }

    public void setState(State state) {
        this.state = state;
    }

    public void printState() {
        System.out.println(this.state.toString());
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
