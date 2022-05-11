package Repositories;

import java.io.Serializable;
import javax.persistence.EntityManager;
import lab9.PersistenceUtil;

public abstract class AbstractRepository<T, ID extends Serializable> {

    public final EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();;

    public void create(T entity) {
        persist(entity);
    }
    
    public T findById(ID id) {
        return (T) em.createNamedQuery("T.findById")
               .setParameter("id",id)
               .getSingleResult();
    }
    
    public T findByName(String name) {
        return (T) em.createNamedQuery("T.findByName")
               .setParameter("name",name)
               .getSingleResult();
    }

    public void persist(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            handleException(e);
            em.getTransaction().rollback();
        }
    }

    private void handleException(Exception e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void closeEntityManager() {
        em.close();
    }
}
