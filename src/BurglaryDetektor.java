public abstract class BurglaryDetektor implements Detector {

    private String name;
    private boolean burglaryDetected;
    private boolean burglaryDetectorActive = false;

    public BurglaryDetektor(String name) {
        this.name = name;
    }


    @Override
    public boolean getDetected() {
        return burglaryDetected;
    }


    @Override
    public void setDetected(boolean burglaryDetected) {
        this.burglaryDetected = burglaryDetected;

    }


    public boolean getBurglaryDetectorActive() {
        return burglaryDetectorActive;
    }

    public void setBurglaryDetectorActive(boolean burglaryDetectorActive) {
        this.burglaryDetectorActive = burglaryDetectorActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


