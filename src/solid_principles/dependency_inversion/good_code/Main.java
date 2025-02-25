package dependency_inversion.good_code;

import dependency_inversion.bad_code.BluetoothMouse;
import dependency_inversion.bad_code.WiredKeyboard;

public class Main {
    public static void main(String[] args) {
        MacBook macBook = new MacBook(new WiredKeyboard(), new BluetoothMouse());
        macBook.details();
    }
}
