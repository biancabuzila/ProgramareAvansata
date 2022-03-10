package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Computer("Computer A", "72.167.51.193", 100));
        nodes.add(new Router("Router A", "190.177.45.215"));
        nodes.add(new Switch("Switch A"));
        nodes.add(new Switch("Switch B"));
        nodes.add(new Router("Router B", "190.177.17.344"));
        nodes.add(new Computer("Computer B", "177.158.4.203", 200));
        Network network = new Network(nodes);

        Collections.sort(nodes);
        System.out.println(network);
    }
}
