package ATM;

public class ATMRoom {

    User user;
    AtmMachine atmMachine;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AtmMachine getAtmMachine() {
        return atmMachine;
    }

    public void setAtmMachine(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }
}
