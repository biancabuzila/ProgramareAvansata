package tema2;

import java.util.Objects;

/**
 * Manages the properties of a room: name, capacity.
 */
public abstract class Room {
    /**
     * the name of the room
     */
    protected String name;
    /**
     * the capacity of the room
     */
    protected int capacity;

    /**
     * Constructor that sets the properties to basic values
     */
    public Room() {
        name = "Room";
        capacity = 100;
    }

    /**
     * Constructor that sets all the properties to specific values.
     *
     * @param name     the name of the room
     * @param capacity the capacity of the room
     */
    public Room(String name, int capacity) {
        this.name = name;
        if (capacity <= 0) {
            System.out.println("Capacity must be >0!");
            System.exit(-1);
        }
        this.capacity = capacity;
    }

    /**
     * Getter for the name of the room.
     *
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the capacity of the room.
     *
     * @return the capacity of the room
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter for the name of the room.
     *
     * @param name the name of the room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the capacity of the room.
     *
     * @param capacity the capacity of the room
     */
    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Capacity must be >0!");
            System.exit(-1);
        }
        this.capacity = capacity;
    }

    /**
     * @return the properties of the event
     */
    @Override
    public String toString() {
        return name + "(cap=" + capacity + ')';
    }

    /**
     * Compares the object with the one given as a parameter.
     *
     * @param o the object with which it is compared
     * @return true if the objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity && Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity);
    }
}
