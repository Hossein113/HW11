package maktab74.practice11.org.utill;

import javax.persistence.EntityManager;

public class ApplicationContent {


    private static EntityManager entityManager;


    public EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = Hibernate.getentityManagerFactory().createEntityManager();
        }
        return entityManager;
    }
}
