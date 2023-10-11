public class SmokeDetektor implements Detector {
    private final boolean SMOKE_DETECTOR_ACTIVE = true;
    private boolean smokeDetected;
    private boolean sprinklerOn = false;

    public void sprinklerIsDripping() {
        if (sprinklerOn) {
            System.out.println("Drip drip, the sprinkler is on, drip drip");
        }
    }

    public void setSprinklerOn(boolean sprinklerOn) {
        this.sprinklerOn = sprinklerOn;
        if (sprinklerOn) {
            sprinklerIsDripping();
        }
    }


    @Override
    public boolean getDetected() {
        return smokeDetected;
    }

    @Override
    public void setDetected(boolean smokeDetected) {
        this.smokeDetected = smokeDetected;
        if (getDetected()) {
            setSprinklerOn(true);
        }
    }


    public boolean getSprinklerOn() {
        return sprinklerOn;
    }
}
























