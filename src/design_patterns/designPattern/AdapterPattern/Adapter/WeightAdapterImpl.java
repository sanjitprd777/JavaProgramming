package AdapterPattern.Adapter;

import AdapterPattern.Adaptee.WeightAdaptee;
import AdapterPattern.Adaptee.WeightAdapteeImpl;

public class WeightAdapterImpl implements WeightAdapter {

    WeightAdaptee weightAdaptee;

    public WeightAdapterImpl() {
        weightAdaptee = new WeightAdapteeImpl();
    }

    @Override
    public double weight() {
        return weightAdaptee.weight() * 0.45;
    }
}
