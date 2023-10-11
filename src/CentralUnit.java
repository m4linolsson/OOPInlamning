import java.util.*;

public class CentralUnit {

    static List<Room> specificRoomList = new ArrayList<Room>() {{
        add(new Room("Bedroom 1", "Erlich Bachman", 0, 1, 2, false, true));
        add(new Room("Bedroom 2", "Jian Yang", 0, 1, 1, false, true));
        add(new Room("Bedroom 3", "Richard Hendricks", 0, 1, 1, false, true));
        add(new Room("Bedroom 4", "Bertram Gilfoyle", 0, 1, 2, false, true));
        add(new Room("Bedroom 5", "Dinesh Chutai", 0, 1, 1, false, true));
        add(new Room("Kitchen", "No one", 0, 0, 1, false, true));
        add(new Room("Garage", "Jared", 1, 1, 1, false, true));
        add(new Room("Hallway", "No one", 1, 0, 1, true, true));
        add(new Room("Livingroom", "No one", 1, 0, 2, true, true));
        add(new Room("Pool Area", "No one", 0, 0, 0, true, false));
    }};

    public static void alarmSimulator() {
        House casaDelBachman = new House(specificRoomList);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Before you start select a password for your alarm system");
        int personalCode = scanner.nextInt();
        System.out.println("Your code is: " + personalCode);

        boolean alarmSimulatorOn = true;
        AlarmMenu.menuAtStart();

        int choiceInMenu = scanner.nextInt();
        int enterCode;


        while (alarmSimulatorOn) {
            {
                int randomRoomNumberAllRooms = random.nextInt(casaDelBachman.getRoomList().size());
                int randomRoomWithSmokeDetektor = random.nextInt(casaDelBachman.getRoomListWithSmokeDetector().size());
                int randomDetektorNumber = random.nextInt(casaDelBachman.getRoom(randomRoomNumberAllRooms).getBurglaryDetektors().size());



                switch (choiceInMenu) {


                    case 1:
                        System.out.println(" ");

                        for (int i = 0; i < casaDelBachman.getRoomList().size(); i++) {
                            for (int j = 0; j < casaDelBachman.getRoom(i).getBurglaryDetektors().size(); j++) {
                                casaDelBachman.getRoom(i).getBurglaryDetektors().get(j).setBurglaryDetectorActive(true);
                            }
                        }

                        System.out.println("1. Alarm system activated");
                        AlarmMenu.menuAfterChoice();
                        choiceInMenu = scanner.nextInt();
                        break;

                    case 2:
                        System.out.println(" ");
                        System.out.println("2. Simulate fire");

                        casaDelBachman.simulateFire(randomRoomWithSmokeDetektor);

                        System.out.println("Smoke detected in room: " +
                                casaDelBachman.getRoom(randomRoomWithSmokeDetektor).getTypeOfRoom());

                        AlarmMenu.menuAfterChoice();
                        choiceInMenu = scanner.nextInt();
                        break;


                    case 3:
                        System.out.println(" ");
                        System.out.println("3. Simulate burglary");

                        if (casaDelBachman.getRoom(randomRoomNumberAllRooms).getBurglaryDetektors().get(randomDetektorNumber).getBurglaryDetectorActive()) {

                            casaDelBachman.simulateBurglary(randomRoomNumberAllRooms, randomDetektorNumber);

                            System.out.println("Burglary detected in " + casaDelBachman.getRoom(randomRoomNumberAllRooms).getTypeOfRoom() +
                                    " on " + casaDelBachman.getRoom(randomRoomNumberAllRooms).getBurglaryDetektor(randomDetektorNumber).getName());

                        } else {
                            System.out.println("Burglary detector inactive");
                        }

                        AlarmMenu.menuAfterChoice();
                        choiceInMenu = scanner.nextInt();
                        break;


                    case 4:
                        System.out.println(" ");
                        System.out.println("Check alarm status:");

                        //Smoke detector
                        for (int i = 0; i < casaDelBachman.getRoomListWithSmokeDetector().size(); i++) {
                            if (casaDelBachman.getRoomListWithSmokeDetector().get(i).getSmokeDetectedInRoom())
                                System.out.println("Smoke detected in " + casaDelBachman.getRoomListWithSmokeDetector().get(i).getTypeOfRoom()
                                        + ": " +
                                        casaDelBachman.getRoomListWithSmokeDetector().get(i).getSmokeDetectedInRoom());
                        }

                        //Sprinkler
                        for (int i = 0; i < casaDelBachman.getRoomListWithSmokeDetector().size(); i++) {
                            if (casaDelBachman.getRoomListWithSmokeDetector().get(i).getSprinklerInRoom())
                                System.out.println("Sprinkler on in " + casaDelBachman.getRoomListWithSmokeDetector().get(i).getTypeOfRoom()
                                        + ": " + casaDelBachman.getRoomListWithSmokeDetector().get(i).getSprinklerInRoom());
                        }

                        //Burglary
                        for (int i = 0; i < casaDelBachman.getRoomList().size(); i++) {

                            for (int j = 0; j < casaDelBachman.getRoom(i).getBurglaryDetektors().size(); j++) {

                                if (casaDelBachman.getRoom(i).getBurglaryDetektors().get(j).getDetected()) {
                                    System.out.println("Burglary detected in " + casaDelBachman.getRoom(i).getTypeOfRoom());
                                    System.out.println("on " + casaDelBachman.getRoom(i).getBurglaryDetektors().get(j).getName() +
                                            ": " + casaDelBachman.getRoom(i).getBurglaryDetektors().get(j).getDetected());
                                }
                            }
                        }

                        //Siren
                        if (casaDelBachman.getSirenOn()) {
                            System.out.print("Siren active: ");
                            System.out.println(casaDelBachman.getSirenOn());
                        } else System.out.println("No alarms have been set off");

                        AlarmMenu.menuAfterChoice();
                        choiceInMenu = scanner.nextInt();
                        break;


                    case 5:
                        System.out.println(" ");
                        System.out.println("Enter code to reset alarm");
                        enterCode = scanner.nextInt();
                        if (enterCode == personalCode) {
                            casaDelBachman.resetBurglaryAlarm();
                            casaDelBachman.resetFireAlarm();
                            System.out.println("The alarm has been reset");
                        } else {
                            System.out.println("Wrong code");
                        }

                        AlarmMenu.menuAfterChoice();
                        choiceInMenu = scanner.nextInt();
                        break;


                    case 6:
                        System.out.println(" ");
                        System.out.println("Enter code to deactivate alarm system");

                        enterCode = scanner.nextInt();
                        if (enterCode == personalCode) {

                            for (int i = 0; i < casaDelBachman.getRoomList().size(); i++) {
                                for (int j = 0; j < casaDelBachman.getRoom(i).getBurglaryDetektors().size(); j++) {
                                    casaDelBachman.getRoom(i).getBurglaryDetektors().get(j).setBurglaryDetectorActive(false);
                                }
                            }
                            System.out.println("Alarm system deactivated");
                        } else {
                            System.out.println("Wrong code");
                        }

                        AlarmMenu.menuAfterChoice();
                        choiceInMenu = scanner.nextInt();
                        break;


                    case 7:
                        System.out.println(" ");
                        System.out.println("Exiting simulation");
                        alarmSimulatorOn = false;
                        break;


                    default:
                        System.out.println(" ");
                        System.out.println("Error, invalid choice, enter a number between 1 and 7");
                        choiceInMenu = scanner.nextInt();
                        break;
                }


            }
        }


    }


}

