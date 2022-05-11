package lab9;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static EntityManagerFactory emf = null;

    private PersistenceUtil() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            createEntityManager();
        }
        return emf;
    }

    private static void createEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("WorldPU");
        }
    }
    
    public static void closeEntityManagerFactory() {
        emf.close();
    }
}
