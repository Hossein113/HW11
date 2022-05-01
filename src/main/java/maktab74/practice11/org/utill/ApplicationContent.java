package maktab74.practice11.org.utill;

import maktab74.practice11.org.repository.UserRepository;
import maktab74.practice11.org.repository.imple.UserRepositoryImple;
import maktab74.practice11.org.security.SecurityUser;
import maktab74.practice11.org.service.Imple.UserServiceImple;
import maktab74.practice11.org.service.UserService;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ApplicationContent {


    private static EntityManager entityManager = HibernateUtill.getEntityManagerFactory().createEntityManager();
    private Scanner stringScanner;
    private Scanner integerScanner;
    private SecurityUser securityUser;
    private UserRepository userRepository;
    private UserService userService;

    public UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImple(entityManager);
        }
        return userRepository;
    }

    public Scanner getStringScanner() {
        if (stringScanner == null) {
            stringScanner = new Scanner(System.in);
        }
        return stringScanner;
    }

    public Scanner getIntegerScanner() {
        if (integerScanner == null) {
            integerScanner = new Scanner(System.in);
        }
        return integerScanner;

    }

    public SecurityUser getSecurityUser() {
        if (securityUser == null) {
            securityUser = new SecurityUser();
        }
        return securityUser;

    }

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImple(getUserRepository());
        }
        return userService;
    }
}