package dependency_inversion.good_code;

public class WiredKeyboard implements KeyBoard {
    @Override
    public void keyboard() {
        System.out.println("Wired Keyboard!");
    }
}
