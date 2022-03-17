public class Street implements Comparable<Street> {
    private String name;
    private int length;
    private Intersection begin;
    private Intersection end;

    public Street(String name) {
        this.name = name;
    }

    public Street(String name, int length, Intersection begin, Intersection end) {
        this.name = name;
        this.length = length;
        this.begin = begin;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Intersection getBegin() {
        return begin;
    }

    public Intersection getEnd() {
        return end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setBegin(Intersection begin) {
        this.begin = begin;
    }

    public void setEnd(Intersection end) {
        this.end = end;
    }

    @Override
    public int compareTo(Street o) {
        if (o.name == null) {
            System.out.println("Null object.");
            System.exit(-1);
        }
        return this.name.compareTo(o.name);
    }

    public static int compareByLength(Street a, Street b) {
        return Integer.compare(a.getLength(), b.getLength());
    }

    @Override
    public String toString() {
        return "\nname=" + name + ", length=" + length + ", begin=" + begin + ", end=" + end;
    }
}