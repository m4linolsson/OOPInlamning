public class AlarmMenu {

    private static void baseMenu() {
        System.out.println("1. Activate alarm system");
        System.out.println("2. Simulate fire");
        System.out.println("3. Simulate burglary");
        System.out.println("4. Check alarmstatus");
        System.out.println("5. Reset alarm");
        System.out.println("6. Deactivate alarm system");
        System.out.println("7. Exit simulation");
        System.out.println("*******************************************************");
    }

    public static void menuAtStart() {
        System.out.println("*******************************************************");
        System.out.println("Welcome to your alarm-simulator, select your choice");
        baseMenu();
    }

    public static void menuAfterChoice() {
        System.out.println(" ");
        System.out.println("*******************************************************");
        System.out.println("Make a new choice");
        baseMenu();
    }
}
