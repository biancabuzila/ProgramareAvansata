package Repositories;

import Entities.Country;

public class CountryRepository extends AbstractRepository<Country, Integer> {

    @Override
    public Country findByName(String name) {
        return (Country) em.createNamedQuery("Country.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public Country findById(Integer id) {
        return (Country) em.createNamedQuery("Country.findById")
                .setParameter("id", id)
                .getSingleResult();
    }
}
