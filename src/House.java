import java.util.ArrayList;
import java.util.List;

public class House extends Siren {

    private List<Room> roomList = new ArrayList<>();
    private List<Room> roomListWithSmokeDetector = new ArrayList<>();


    public House(List<Room> roomList) {
        this.roomList = roomList;
        generateRoomListWhitSmokeSensor();
    }

    public void generateRoomListWhitSmokeSensor() {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getHasSmokeDetektor()) {
                roomListWithSmokeDetector.add(roomList.get(i));
            }
        }
    }

    public Room getRoom(int roomIndex) {
        return getRoomList().get(roomIndex);
    }

    public void simulateFire(int roomIndexWithSmokeDetector) {
        roomListWithSmokeDetector.get(roomIndexWithSmokeDetector).setSmokeDetectedInRoom(true);
        setSirenOn(true, true);
    }


    public void simulateBurglary(int roomNumber, int detektorNumber) {
        getRoom(roomNumber).getBurglaryDetektor(detektorNumber).setDetected(true);
        setSirenOn(true, false);
    }

    public void resetFireAlarm() {
        for (int i = 0; i < roomListWithSmokeDetector.size(); i++) {
            roomListWithSmokeDetector.get(i).setSmokeDetectedInRoom(false);
            roomListWithSmokeDetector.get(i).setSprinklerInRoom(false);
        }
        setSirenOn(false, true);
    }

    public void resetBurglaryAlarm() {
        for (int i = 0; i < roomList.size(); i++) {

            for (int j = 0; j < roomList.get(i).getBurglaryDetektors().size(); j++) {
                getRoom(i).getBurglaryDetektor(j).setDetected(false);
            }
        }
        setSirenOn(false, false);
    }

    public List<Room> getRoomListWithSmokeDetector() {
        return roomListWithSmokeDetector;
    }

    public void setRoomListWithSmokeDetector(List<Room> roomListWithSmokeDetector) {
        this.roomListWithSmokeDetector = roomListWithSmokeDetector;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

}
