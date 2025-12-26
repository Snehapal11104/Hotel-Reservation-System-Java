import java.util.ArrayList;

public class HotelManager {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    void addRoom(Room room) {
        rooms.add(room);
        System.out.println(Colors.GREEN + "Room added successfully!" + Colors.RESET);
    }

    void viewRooms() {
        System.out.println("\nRoom List:");
        for (Room r : rooms) {
            String status = r.available ? "Available" : "Booked";
            System.out.println("Room " + r.roomNumber +
                    " | " + r.type +
                    " | ₹" + r.price +
                    " | " + status);
        }
    }

    void bookRoom(int roomNumber, String name) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber && r.available) {
                r.available = false;
                customers.add(new Customer(name, roomNumber));
                System.out.println(Colors.GREEN + "Room booked successfully!" + Colors.RESET);
                return;
            }
        }
        System.out.println(Colors.RED + "Room not available!" + Colors.RESET);
    }

    void cancelBooking(int roomNumber) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber && !r.available) {
                r.available = true;
                System.out.println("Booking cancelled.");
                return;
            }
        }
        System.out.println("Invalid room number.");
    }
}
