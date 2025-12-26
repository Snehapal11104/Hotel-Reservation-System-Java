public class Room {
    int roomNumber;
    String type;
    double price;
    boolean available;

    Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.available = true;
    }
}
