package lab2;

public class Main {
    public static void main(String[] args) {
        Event event1 = new Event("C1", 100, 8, 10);
        Event event2 = new Event("C2", 100, 10, 12);
        Event event3 = new Event("L1", 30, 8, 10);
        Event event4 = new Event("L2", 30, 8, 10);
        Event event5 = new Event("L3", 30, 10, 12);

        Room room1 = new Room("401", RoomType.COMPUTER_LAB, 30);
        Room room2 = new Room("403", RoomType.COMPUTER_LAB, 30);
        Room room3 = new Room("405", RoomType.COMPUTER_LAB, 30);
        Room room4 = new Room("309", RoomType.LECTURE_HALL, 100);

        System.out.println("Events: " + event1 + ", " + event2 + ", " + event3 + ", " + event4 + ", " + event5);
        System.out.println("Rooms: " + room1 + ", " + room2 + ", " + room3 + ", " + room4);
    }
}
