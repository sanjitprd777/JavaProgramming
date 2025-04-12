package AdapterPattern;

import AdapterPattern.Adapter.WeightAdapter;
import AdapterPattern.Adapter.WeightAdapterImpl;

public class Main {

    public static void main(String[] args) {
        WeightAdapter weightAdapter = new WeightAdapterImpl();
        System.out.println(weightAdapter.weight());
    }
}
