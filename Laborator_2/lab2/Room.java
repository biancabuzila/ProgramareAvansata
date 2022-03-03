package lab2;

public class Room {
    private String name;
    private RoomType type;
    private int capacity;

    public Room(String name, RoomType type, int capacity) {
        this.name = name;
        this.type = type;
        if (capacity <= 0) {
            System.out.println("Capacity must be >0!");
            System.exit(-1);
        }
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public RoomType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Capacity must be >0!");
            System.exit(-1);
        }
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + "(cap=" + capacity + ", " + type + ")";
    }
}
