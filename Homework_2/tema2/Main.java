package tema2;

/**
 * @author Bianca Buzilă
 */

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Event[] events = new Event[5];
        events[0] = new Event("C1", 100, 8, 10);
        events[1] = new Event("C2", 100, 10, 12);
        events[2] = new Event("L1", 30, 8, 10);
        events[3] = new Event("L2", 30, 8, 10);
        events[4] = new Event("L3", 30, 10, 12);

        Room[] rooms = new Room[4];
        rooms[0] = new ComputerLab();
        rooms[1] = new ComputerLab("Linux");
        rooms[2] = new ComputerLab();
        rooms[3] = new LectureHall(true);

        rooms[0].setName("401");
        rooms[0].setCapacity(30);
        rooms[1].setName("403");
        rooms[1].setCapacity(30);
        rooms[2].setName("405");
        rooms[2].setCapacity(30);
        rooms[3].setName("309");
        rooms[3].setCapacity(100);

        Problem pb = new Problem(events, rooms);
        Algorithm alg = new Algorithm(pb);
        Solution sol = alg.solve();

        System.out.println("Number of used rooms: " + sol.computeUsedRooms());
        System.out.println(sol);
    }
}
