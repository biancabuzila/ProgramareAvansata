package lab9;

import Entities.City;
import Entities.Country;
import Repositories.CityRepository;
import Repositories.CountryRepository;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        CityRepository cityRepo = new CityRepository();
        CountryRepository countryRepo = new CountryRepository();

        Country country = countryRepo.findByName("Romania");
        var cityNames = new ArrayList<>(Arrays.asList("Iasi", "Cluj-Napoca", "Timisoara", "Botosani", "Constanta", "Craiova", "Sibiu",
                "Brasov", "Galati", "Ploiesti", "Oradea", "Braila", "Arad", "Pitesti", "Bacau", "Targu Mures", "Baia Mare", "Buzau", "Suceava",
                "Satu Mare", "Piatra Neamt", "Focsani", "Bistrita", "Tulcea"));
        cityRepo.create(new City("Bucuresti", (short) 1, country));
        for (String cityName : cityNames) {
            cityRepo.create(new City(cityName, (short) 0, country));
        }

        cityRepo.closeEntityManager();
        PersistenceUtil.closeEntityManagerFactory();
    }
}
