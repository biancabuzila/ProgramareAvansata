import java.util.*;

public class Solution {
    private City city;

    public Solution(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    //Prim algorithm
    public void solve() {
        List<Intersection> nodes = new ArrayList<>(city.getCityMap().keySet());
        List<Street> edges = new ArrayList<>();
        Intersection first = city.getCityMap().keySet().stream().findFirst().get();

        Map<Intersection, Intersection> alfa = new HashMap<>();
        Map<Intersection, Integer> beta = new HashMap<>();
        for (Intersection n : nodes)
            if (!n.equals(first)) {
                alfa.put(n, first);
                beta.put(n, getStreet(first, n).getLength());
            }
        nodes.remove(first);
        while (nodes.size() != 0) {
            int min = Integer.MAX_VALUE;
            Intersection next = new Intersection("next");

            for (Intersection n : beta.keySet())
                if (nodes.contains(n) && beta.get(n) < min) {
                    min = beta.get(n);
                    next = n;
                }
            edges.add(getStreet(alfa.get(next), next));

            for (Intersection n : nodes)
                if (beta.get(n) > getStreet(next, n).getLength()) {
                    beta.replace(n, getStreet(next, n).getLength());
                    alfa.replace(n, next);
                }
            nodes.remove(next);
        }
        for (Street s : edges)
            System.out.println(s.getBegin() + " - " + s.getEnd());
    }

    public Street getStreet(Intersection begin, Intersection end) {
        Street s = new Street("x");
        for (List<Street> list : city.getCityMap().values())
            for (Street street : list)
                if ((street.getBegin().equals(begin) && street.getEnd().equals(end)) ||
                        (street.getBegin().equals(end) && street.getEnd().equals(begin)))
                    return street;
        s.setLength(Integer.MAX_VALUE);
        return s;
    }
}
