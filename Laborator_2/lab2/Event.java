package lab2;

public class Event {
    private String name;
    private int size;
    private int start;
    private int end;

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
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        if (size <= 0) {
            System.out.println("Size must be >0!");
            System.exit(-1);
        }
        this.size = size;
    }

    public void setStart(int start) {
        if (start < 0 || start > 24) {
            System.out.println("Start time must be >=0 and <=24!");
            System.exit(-1);
        }
        this.start = start;
    }

    public void setEnd(int end) {
        if (start < 0 || start > 24) {
            System.out.println("End time must be >=0 and <=24!");
            System.exit(-1);
        }
        this.end = end;
    }

    @Override
    public String toString() {
        return name + "(size=" + size + ", start=" + start + ", end=" + end + ')';
    }
}
