package maktab74.practice11.org.utill;

import maktab74.practice11.org.repository.CommentTwittRepository;
import maktab74.practice11.org.repository.LikeTwittRepository;
import maktab74.practice11.org.repository.TwittRepository;
import maktab74.practice11.org.repository.UserRepository;
import maktab74.practice11.org.repository.imple.CommentTwittRepositoryImple;
import maktab74.practice11.org.repository.imple.LikeTwittRepositoryImple;
import maktab74.practice11.org.repository.imple.TwittRepositoryImple;
import maktab74.practice11.org.repository.imple.UserRepositoryImple;
import maktab74.practice11.org.security.SecurityUser;
import maktab74.practice11.org.service.CommentTwittService;
import maktab74.practice11.org.service.Imple.CommentTwittServiceImple;
import maktab74.practice11.org.service.Imple.LikeTwittServiceImple;
import maktab74.practice11.org.service.Imple.TwittServiceImple;
import maktab74.practice11.org.service.Imple.UserServiceImple;
import maktab74.practice11.org.service.LikeTwittService;
import maktab74.practice11.org.service.TwittService;
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
    private TwittRepository twittRepository;
    private TwittService twittService;
    private LikeTwittRepository likeTwittRepository;
    private LikeTwittService likeTwittService;
    private CommentTwittRepository commentTwittRepository;
    private CommentTwittService commentTwittService;

    public CommentTwittService getCommentTwittService() {
        if (commentTwittService == null) {
            commentTwittService = new CommentTwittServiceImple(getCommentTwittRepository());
        }
        return commentTwittService;
    }

    public CommentTwittRepository getCommentTwittRepository() {
        if (commentTwittRepository == null) {
            commentTwittRepository = new CommentTwittRepositoryImple(entityManager);
        }


        return commentTwittRepository;
    }

    public LikeTwittService getLikeTwittService() {
        if (likeTwittService == null) {
            likeTwittService = new LikeTwittServiceImple(getLikeTwittRepository());
        }
        return likeTwittService;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public LikeTwittRepository getLikeTwittRepository() {
        if (likeTwittRepository == null) {
            likeTwittRepository = new LikeTwittRepositoryImple(entityManager);
        }
        return likeTwittRepository;
    }

    public TwittService getTwittService() {
        if (twittService == null) {
            twittService = new TwittServiceImple(getTwittRepository());
        }
        return twittService;
    }

    public TwittRepository getTwittRepository() {
        if (twittRepository == null) {
            twittRepository = new TwittRepositoryImple(entityManager);
        }
        return twittRepository;
    }

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