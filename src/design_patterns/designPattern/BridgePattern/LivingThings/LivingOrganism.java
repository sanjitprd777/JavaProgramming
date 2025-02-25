package BridgePattern.LivingThings;

import BridgePattern.BreatheImplementor.Breathe;

public abstract class LivingOrganism {

    Breathe breathe;

    public LivingOrganism(Breathe breathe) {
        this.breathe = breathe;
    }

    public void breatheProcess() {
        breathe.breathe();
    }
}
