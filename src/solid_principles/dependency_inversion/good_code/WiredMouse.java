package dependency_inversion.good_code;

public class WiredMouse implements Mouse {
    @Override
    public void mouse() {
        System.out.println("Wired Mouse!");
    }
}
