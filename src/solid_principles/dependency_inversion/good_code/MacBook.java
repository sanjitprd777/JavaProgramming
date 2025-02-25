package dependency_inversion.good_code;

import dependency_inversion.bad_code.KeyBoard;
import dependency_inversion.bad_code.Mouse;

public class MacBook {
    // Note: This is now an interface.
    private final KeyBoard keyboard;

    // Note: This is now an interface.
    private final Mouse mouse;

    public MacBook(KeyBoard keyboard, Mouse mouse) {
        this.keyboard = keyboard; // We can pass any type of Keyboard object which impements 'keyboard' interface.
        this.mouse = mouse;
    }

    void details() {
        keyboard.keyboard();
        mouse.mouse();
    }
}
