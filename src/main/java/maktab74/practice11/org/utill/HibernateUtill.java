package maktab74.practice11.org.utill;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtill {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
