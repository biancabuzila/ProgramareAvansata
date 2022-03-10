package lab3;

public abstract class Node implements Comparable<Node> {
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "(" + name + ")";
    }

    @Override
    public int compareTo(Node o) {
        if (o.name == null) {
            System.out.println("Null object.");
            System.exit(-1);
        }
        return this.name.compareTo(o.name);
    }
}
