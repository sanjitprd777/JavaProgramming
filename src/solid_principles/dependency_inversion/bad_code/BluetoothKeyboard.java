package dependency_inversion.bad_code;

public class BluetoothKeyboard implements KeyBoard {
    @Override
    public void keyboard() {
        System.out.println("Bluetooth Keyboard!");
    }
}
