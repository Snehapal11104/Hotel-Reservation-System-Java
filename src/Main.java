import java.util.Scanner;

public class Main {

    static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HotelManager manager = new HotelManager();

        // Default rooms
        manager.addRoom(new Room(101, "Single", 1500));
        manager.addRoom(new Room(102, "Double", 2500));
        manager.addRoom(new Room(103, "Deluxe", 3500));

        while (true) {
            System.out.println(Colors.BLUE +
                    "\n===== HOTEL RESERVATION SYSTEM =====" + Colors.RESET);
            System.out.println(Colors.YELLOW + "1. User Login" + Colors.RESET);
            System.out.println(Colors.YELLOW + "2. Admin Login" + Colors.RESET);
            System.out.println(Colors.YELLOW + "3. Exit" + Colors.RESET);
            System.out.print("Choose option: ");

            int role = sc.nextInt();
            sc.nextLine();

            if (role == 1) {
                userMenu(sc, manager);
            } else if (role == 2) {
                System.out.print("Enter admin password: ");
                String pass = sc.nextLine();

                if (pass.equals(ADMIN_PASSWORD)) {
                    System.out.println(Colors.GREEN + "Admin access granted!" + Colors.RESET);
                    adminMenu(sc, manager);
                } else {
                    System.out.println(Colors.RED + "Wrong password!" + Colors.RESET);
                }
            } else if (role == 3) {
                System.out.println(Colors.GREEN + "Thank you for using the system!" + Colors.RESET);
                break;
            } else {
                System.out.println(Colors.RED + "Invalid choice!" + Colors.RESET);
            }
        }
        sc.close();
    }

    // USER MENU
    static void userMenu(Scanner sc, HotelManager manager) {
        while (true) {
            System.out.println(Colors.BLUE + "\n--- USER MENU ---" + Colors.RESET);
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Back");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                manager.viewRooms();
            } else if (choice == 2) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter room number: ");
                int roomNo = sc.nextInt();
                manager.bookRoom(roomNo, name);
            } else if (choice == 3) {
                System.out.print("Enter room number: ");
                int roomNo = sc.nextInt();
                manager.cancelBooking(roomNo);
            } else if (choice == 4) {
                break;
            } else {
                System.out.println(Colors.RED + "Invalid option!" + Colors.RESET);
            }
        }
    }

    // ADMIN MENU
    static void adminMenu(Scanner sc, HotelManager manager) {
        while (true) {
            System.out.println(Colors.BLUE + "\n--- ADMIN MENU ---" + Colors.RESET);
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Back");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {System.out.print("Room number: ");
                int no = sc.nextInt();
                sc.nextLine();
                System.out.print("Room type: ");
                String type = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                manager.addRoom(new Room(no, type, price));
            } else if (choice == 2) {
                manager.viewRooms();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println(Colors.RED + "Invalid option!" + Colors.RESET);
            }
        }
    }
}
