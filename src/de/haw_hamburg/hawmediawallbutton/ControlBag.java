package de.haw_hamburg.hawmediawallbutton;

public class ControlBag {
	
	// All 10 bis -10
    private float boost;
    private float pitch;
    private float roll;

    
    private boolean reset;
    private boolean start;

    public ControlBag(float boost, float pitch, float roll) {
        new ControlBag(boost, pitch, roll, false, false);
    }

    public ControlBag(float boost, float pitch, float roll, boolean reset) {
        new ControlBag(boost, pitch, roll, reset, false);
    }

    public ControlBag(float boost, float pitch, float roll, boolean reset, boolean start) {
        this.boost = boost;
        this.pitch = pitch;
        this.roll = roll;
        this.reset = reset;
        this.start = start;
    }

    public float getBoost() {
        return boost;
    }

    public float getPitch() {
        return pitch;
    }

    public float getRoll() {
        return roll;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isReset() {
        return reset;
    }
}
