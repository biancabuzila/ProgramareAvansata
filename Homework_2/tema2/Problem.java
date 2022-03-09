package tema2;

/**
 * Describes an instance of the Room Assignment Problem.
 */
public class Problem {
    /**
     * the first part of the problem instance: events
     */
    private Event[] events;
    /**
     * the second part of the problem instance: rooms
     */
    private Room[] rooms;

    /**
     * Constructor that sets the events and the rooms of the problem instance.
     *
     * @param events the events implicated in the problem
     * @param rooms  the rooms implicated in the problem
     */
    public Problem(Event[] events, Room[] rooms) {
        this.events = events;
        this.rooms = rooms;
    }

    /**
     * Getter for the number of the events.
     *
     * @return the number of the events
     */
    public int getNrEvents() {
        return events.length;
    }

    /**
     * Getter for the event with the given index.
     *
     * @param index the index of the event
     * @return the event with the given index
     */
    public Event getEvent(int index) {
        return events[index];
    }

    /**
     * Getter for the number of rooms.
     *
     * @return the number of room
     */
    public int getNrRooms() {
        return rooms.length;
    }

    /**
     * Getter for the room with the given index.
     *
     * @param index the index of the room
     * @return the room with the given index
     */
    public Room getRoom(int index) {
        return rooms[index];
    }
}
