import java.util.ArrayList;
import java.util.List;

public class Room {
    private String typeOfRoom;
    private String personSleepingInRoom;
    private int numberOfFrontDoors;
    private int numberOfInsideDoors;
    private int numberOfWindows;
    private boolean hasMovementDetektor;
    private final boolean hasSmokeDetektor;
    SmokeDetektor smokeDetektor = new SmokeDetektor();
    private List<BurglaryDetektor> burglaryDetektors = new ArrayList<BurglaryDetektor>();


    public Room(String typeOfRoom, String personSleepingInRoom, int numberOfFrontDoors, int numberOfInsideDoors,
                int numberOfWindows, boolean hasMovementDetektor, boolean hasSmokeDetektor) {
        this.typeOfRoom = typeOfRoom;
        this.personSleepingInRoom = personSleepingInRoom;
        this.numberOfFrontDoors = numberOfFrontDoors;
        this.numberOfInsideDoors = numberOfInsideDoors;
        this.numberOfWindows = numberOfWindows;
        this.hasSmokeDetektor = hasSmokeDetektor;

        for (int i = 0; i < numberOfWindows; i++) {
            burglaryDetektors.add(new BurglaryDetektor("Window " + (1 + i)) {
            });
        }
        for (int i = 0; i < numberOfFrontDoors; i++) {
            burglaryDetektors.add(new BurglaryDetektor("Door " + (1 + i)) {
            });
        }
        if (hasMovementDetektor) {
            burglaryDetektors.add(new BurglaryDetektor("Movement detector") {
            });
        }
    }

    public BurglaryDetektor getBurglaryDetektor(int detektorNumber) {
        return getBurglaryDetektors().get(detektorNumber);
    }

    public void setSprinklerInRoom(boolean sprinklerOn) {
        smokeDetektor.setSprinklerOn(sprinklerOn);
    }

    public boolean getSprinklerInRoom() {
        return smokeDetektor.getSprinklerOn();
    }

    public void setSmokeDetectedInRoom(boolean smokeDetekted) {
        smokeDetektor.setDetected(smokeDetekted);
    }

    public boolean getSmokeDetectedInRoom() {
        return smokeDetektor.getDetected();
    }

    public List<BurglaryDetektor> getBurglaryDetektors() {
        return burglaryDetektors;
    }

    public void setBurglaryDetektors(List<BurglaryDetektor> burglaryDetektors) {
        this.burglaryDetektors = burglaryDetektors;
    }

    public boolean getHasSmokeDetektor() {
        return hasSmokeDetektor;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public String getPersonSleepingInRoom() {
        return personSleepingInRoom;
    }

    public void setPersonSleepingInRoom(String personSleepingInRoom) {
        this.personSleepingInRoom = personSleepingInRoom;
    }

    public int getNumberOfFrontDoors() {
        return numberOfFrontDoors;
    }

    public void setNumberOfFrontDoors(int numberOfFrontDoors) {
        this.numberOfFrontDoors = numberOfFrontDoors;
    }

    public int getNumberOfInsideDoors() {
        return numberOfInsideDoors;
    }

    public void setNumberOfInsideDoors(int numberOfInsideDoors) {
        this.numberOfInsideDoors = numberOfInsideDoors;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public boolean getHasMovementDetektor() {
        return hasMovementDetektor;
    }

    public void setHasMovementDetektor(boolean hasMovementDetektor) {
        this.hasMovementDetektor = hasMovementDetektor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "typeOfRoom='" + typeOfRoom + '\'' +
                ", personSleepingInRoom='" + personSleepingInRoom + '\'' +
                ", numberOfFrontDoors=" + numberOfFrontDoors +
                ", numberOfInsideDoors=" + numberOfInsideDoors +
                ", numberOfWindows=" + numberOfWindows +
                ", hasMovementDetektor=" + hasMovementDetektor +
                ", hasSmokeDetektor=" + hasSmokeDetektor +
                ", smokeDetektor=" + smokeDetektor +
                ", burglaryDetektors=" + burglaryDetektors +
                '}';
    }
}
