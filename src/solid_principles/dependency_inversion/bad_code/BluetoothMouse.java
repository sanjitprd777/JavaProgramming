package dependency_inversion.bad_code;

public class BluetoothMouse implements Mouse {
    @Override
    public void mouse() {
        System.out.println("Bluetooth Mouse!");
    }
}
