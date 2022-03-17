import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        var streets = IntStream.rangeClosed(0, 15)
                .mapToObj(i -> new Street("m" + i))
                .toArray(Street[]::new);

        streets[0].setBegin(nodes[0]);  streets[0].setEnd(nodes[1]); streets[0].setLength(2);
        streets[1].setBegin(nodes[0]);  streets[1].setEnd(nodes[2]); streets[1].setLength(2);
        streets[2].setBegin(nodes[0]);  streets[2].setEnd(nodes[3]); streets[2].setLength(2);
        streets[3].setBegin(nodes[1]);  streets[3].setEnd(nodes[2]); streets[3].setLength(2);
        streets[4].setBegin(nodes[2]);  streets[4].setEnd(nodes[3]); streets[4].setLength(1);
        streets[5].setBegin(nodes[1]);  streets[5].setEnd(nodes[4]); streets[5].setLength(3);
        streets[6].setBegin(nodes[2]);  streets[6].setEnd(nodes[6]); streets[6].setLength(2);
        streets[7].setBegin(nodes[2]);  streets[7].setEnd(nodes[5]); streets[7].setLength(2);
        streets[8].setBegin(nodes[3]);  streets[8].setEnd(nodes[5]); streets[8].setLength(3);
        streets[9].setBegin(nodes[4]);  streets[9].setEnd(nodes[5]); streets[9].setLength(1);
        streets[10].setBegin(nodes[4]);  streets[10].setEnd(nodes[7]); streets[10].setLength(1);
        streets[11].setBegin(nodes[4]);  streets[11].setEnd(nodes[8]); streets[11].setLength(2);
        streets[12].setBegin(nodes[5]);  streets[12].setEnd(nodes[8]); streets[12].setLength(3);
        streets[13].setBegin(nodes[6]);  streets[13].setEnd(nodes[7]); streets[13].setLength(1);
        streets[14].setBegin(nodes[6]);  streets[14].setEnd(nodes[8]); streets[14].setLength(1);
        streets[15].setBegin(nodes[7]);  streets[15].setEnd(nodes[8]); streets[15].setLength(1);

        List<Street> streetList = new LinkedList<>(Arrays.asList(streets));
        streetList.sort(Street::compareByLength);
        System.out.println(streetList);

        Set<Intersection> nodeSet = new HashSet<>(Arrays.asList(nodes));
        if(!nodeSet.add(nodes[0]))
            System.out.println("The set does not contain duplicates.");

        System.out.println(nodeSet);
    }
}