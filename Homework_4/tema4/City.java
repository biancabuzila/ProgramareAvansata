import java.util.List;
import java.util.Map;

public class City {
    private Map<Intersection, List<Street>> cityMap;

    public City(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    @Override
    public String toString() {
        return "City:\n" + cityMap;
    }

    public int joinedStreets(Street street) {
        int joinedStreets = 0;
        for (Intersection n : cityMap.keySet())
            if (street.getBegin().equals(n) || street.getEnd().equals(n))
                joinedStreets += cityMap.get(n).size() - 1;
        return joinedStreets;
    }
}
