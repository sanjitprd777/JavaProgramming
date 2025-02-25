package dependency_inversion.bad_code;

public class MacBook {
    // concrete class. this is wrong. This should be an interface.
    private final WiredKeyboard keyboard;

    // concrete class. this is wrong. This should be an interface.
    private final WiredMouse mouse;

    public MacBook() {
        keyboard = new WiredKeyboard(); // If we want use bluetooth, we have to change this code, which is bad.
        mouse = new WiredMouse();
    }

    void details() {
        keyboard.keyboard();
        mouse.mouse();
    }
}
