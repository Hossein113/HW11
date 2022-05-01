package maktab74.practice11.org;

import maktab74.practice11.org.utill.HibernateUtill;

public class Application {
    public static void main(String[] args) {


        System.out.println("start");
        HibernateUtill.getEntityManagerFactory().createEntityManager();
        System.out.println("END");
    }
}
