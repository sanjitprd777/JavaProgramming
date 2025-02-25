package dependency_inversion.good_code;

public class BluetoothKeyboard implements KeyBoard {
    @Override
    public void keyboard() {
        System.out.println("Bluetooth Keyboard!");
    }
}
