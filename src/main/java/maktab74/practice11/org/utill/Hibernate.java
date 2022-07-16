package maktab74.practice11.org.utill;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate {

    private static final EntityManagerFactory emf;


    static {
        emf = Persistence.createEntityManagerFactory("defult");
    }

    public static EntityManagerFactory getentityManagerFactory() {
        return emf;
    }
}
