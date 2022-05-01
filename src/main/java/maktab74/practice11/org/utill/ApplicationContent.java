package maktab74.practice11.org.utill;

import javax.persistence.EntityManager;

public class ApplicationContent {


    private static EntityManager entityManager = HibernateUtill.getEntityManagerFactory().createEntityManager();


}
