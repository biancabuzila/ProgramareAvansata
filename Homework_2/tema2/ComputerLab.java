package tema2;

public class ComputerLab extends Room {
    /**
     * the operating system of the computers in the room
     */
    private String os;

    /**
     * Constructor that sets the operating system as Windows.
     */
    public ComputerLab() {
        os = "Windows";
    }

    /**
     * Constructor that sets the operating system.
     *
     * @param os the operating system of the computers in the room
     */
    public ComputerLab(String os) {
        this.os = os;
    }

    /**
     * Getter the operating system.
     *
     * @return the operating system of the computers in the room
     */
    public String getOs() {
        return os;
    }

    /**
     * Setter the operating system.
     *
     * @param os the operating system of the computers in the room
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * @return the properties of the object
     */
    @Override
    public String toString() {
        return name + "(cap=" + capacity + ", lab)";
    }
}
