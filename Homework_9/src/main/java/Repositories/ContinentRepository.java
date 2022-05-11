package Repositories;

import Entities.Continent;

public class ContinentRepository extends AbstractRepository<Continent, Integer> {

    @Override
    public Continent findByName(String name) {
        return (Continent) em.createNamedQuery("Continent.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public Continent findById(Integer id) {
        return (Continent) em.createNamedQuery("Continent.findById")
                .setParameter("id", id)
                .getSingleResult();
    }
}
