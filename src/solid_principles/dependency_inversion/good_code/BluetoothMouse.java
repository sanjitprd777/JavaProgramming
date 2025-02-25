package dependency_inversion.good_code;

public class BluetoothMouse implements Mouse {
    @Override
    public void mouse() {
        System.out.println("Bluetooth Mouse!");
    }
}
