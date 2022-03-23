import com.github.javafaker.Faker;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

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

        /*
        List<Street> streetList = new LinkedList<>(Arrays.asList(streets));
        streetList.sort(Street::compareByLength);
        System.out.println(streetList);

        Set<Intersection> nodeSet = new HashSet<>(Arrays.asList(nodes));
        if(!nodeSet.add(nodes[0]))
            System.out.println("The set does not contain duplicates.");

        System.out.println(nodeSet);
        */

        Map<Intersection, List<Street>> cityMap = new HashMap<>();
        cityMap.put(nodes[0],Arrays.asList(streets[0],streets[1],streets[2]));
        cityMap.put(nodes[1],Arrays.asList(streets[0],streets[3],streets[5]));
        cityMap.put(nodes[2],Arrays.asList(streets[1],streets[3],streets[4],streets[6],streets[7]));
        cityMap.put(nodes[3],Arrays.asList(streets[2],streets[4],streets[8]));
        cityMap.put(nodes[4],Arrays.asList(streets[5],streets[9],streets[10],streets[11]));
        cityMap.put(nodes[5],Arrays.asList(streets[7],streets[8],streets[9],streets[12]));
        cityMap.put(nodes[6],Arrays.asList(streets[6],streets[13],streets[14]));
        cityMap.put(nodes[7],Arrays.asList(streets[10],streets[13],streets[15]));
        cityMap.put(nodes[8],Arrays.asList(streets[11],streets[12],streets[14],streets[15]));

        City city = new City(cityMap);

        Arrays.stream(streets)
                .filter(street -> street.getLength() > 2)
                .filter(street -> city.joinedStreets(street) >= 3)
                .forEach(System.out::print);

        Faker faker = new Faker();
        Arrays.stream(streets).forEach(s -> s.setName(faker.address().streetName()));
        Arrays.stream(nodes).forEach(n -> n.setName(faker.address().streetAddress()));
        System.out.println("\n\nStreet names:");
        for(Street s : streets)
            System.out.println(s.getName());
        System.out.println("\nIntersection names:");
        for(Intersection n : nodes)
            System.out.println(n.getName());

        DefaultUndirectedGraph<Intersection, DefaultWeightedEdge> g = new DefaultUndirectedWeightedGraph<>(DefaultWeightedEdge.class);
        Arrays.stream(nodes).forEach(g::addVertex);
        Arrays.stream(streets).forEach(s -> g.addEdge(s.getBegin(), s.getEnd()));
        Arrays.stream(streets).forEach(s -> g.setEdgeWeight(s.getBegin(), s.getEnd(), s.getLength()));

        System.out.println("\nSolution with JGraphT:");
        for(DefaultWeightedEdge e : new KruskalMinimumSpanningTree<>(g).getSpanningTree())
            System.out.println(e);

        System.out.println("\nPersonal solution:");
        Solution sol = new Solution(city);
        sol.solve();
    }
}