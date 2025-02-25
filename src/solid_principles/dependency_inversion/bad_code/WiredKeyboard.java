package dependency_inversion.bad_code;

public class WiredKeyboard implements KeyBoard {
    @Override
    public void keyboard() {
        System.out.println("Wired Keyboard!");
    }
}
