package Repositories;

import javax.persistence.EntityManager;

public class Continent {
   private EntityManager em;
   
   public Entities.Continent findByName(String name) {
       return (Entities.Continent) em.createNamedQuery("Entities.Continent.findByName")
               .setParameter("name",name)
               .getSingleResult();
   }
}
