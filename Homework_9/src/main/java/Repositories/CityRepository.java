package Repositories;

import Entities.City;

public class CityRepository extends AbstractRepository<City, Integer> {

    @Override
    public City findByName(String name) {
        return (City) em.createNamedQuery("City.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public City findById(Integer id) {
        return (City) em.createNamedQuery("City.findById")
                .setParameter("id", id)
                .getSingleResult();
    }
}
