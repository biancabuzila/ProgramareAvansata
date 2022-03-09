package tema2;

import java.util.Objects;

/**
 * Manages the properties of an event: name, size, start time and end time.
 */
public class Event {
    /**
     * the name of the event
     */
    private String name;
    /**
     * the number of participants
     */
    private int size;
    /**
     * the time the event starts
     */
    private int start;
    /**
     * the time the event ends
     */
    private int end;

    /**
     * Constructor that sets all the properties to specific values.
     *
     * @param name  the name of the event
     * @param size  the number of participants
     * @param start the time the event starts
     * @param end   the time the event ends
     */
    public Event(String name, int size, int start, int end) {
        this.name = name;
        if (size <= 0) {
            System.out.println("Size must be >0!");
            System.exit(-1);
        }
        this.size = size;
        if (start < 0 || start > 24) {
            System.out.println("Start time must be >=0 and <=24!");
            System.exit(-1);
        }
        this.start = start;
        if (end < 0 || end > 24) {
            System.out.println("End time must be >=0 and <=24!");
            System.exit(-1);
        }
        if (end < start) {
            System.out.println("End time must be greater than start time!");
            System.exit(-1);
        }
        this.end = end;
    }

    /**
     * @return the number of the participants at the event
     */
    public String getName() {
        return name;
    }

    /**
     * @return the number of the participants at the event
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the time the event starts
     */
    public int getStart() {
        return start;
    }

    /**
     * @return the time the event ends
     */
    public int getEnd() {
        return end;
    }

    /**
     * Setter for the name of the event.
     *
     * @param name the name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for  the number of the participants at the event.
     *
     * @param size the number of participants
     */
    public void setSize(int size) {
        if (size <= 0) {
            System.out.println("Size must be >0!");
            System.exit(-1);
        }
        this.size = size;
    }

    /**
     * Setter for the time the event starts.
     *
     * @param start the time the event starts
     */
    public void setStart(int start) {
        if (start < 0 || start > 24) {
            System.out.println("Start time must be >=0 and <=24!");
            System.exit(-1);
        }
        this.start = start;
    }

    /**
     * Setter for the time the event ends.
     *
     * @param end the time the event ends
     */
    public void setEnd(int end) {
        if (start < 0 || start > 24) {
            System.out.println("End time must be >=0 and <=24!");
            System.exit(-1);
        }
        this.end = end;
    }

    /**
     * @return the properties of the event
     */
    @Override
    public String toString() {
        return name + "(size=" + size + ", start=" + start + ", end=" + end + ')';
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
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return size == event.size && start == event.start && end == event.end &&
                Objects.equals(name, event.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, start, end);
    }
}
