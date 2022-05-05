package lab9;

import Entities.Continent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("WorldPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Continent continent = new Continent("Asia");
        em.persist(continent);
        Continent c = (Continent)em.createQuery("select e from Continent e where e.name='Asia'").getSingleResult();
        c.setName("Africa");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
