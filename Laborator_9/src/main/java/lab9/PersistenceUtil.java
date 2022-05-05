package lab9;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory emf = null;
    
    private PersistenceUtil(){}
    
    private static void createEntityManager() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("WorldPU");
    }
    
    public static EntityManagerFactory getEntityManager() {
        return emf;
    }
}
