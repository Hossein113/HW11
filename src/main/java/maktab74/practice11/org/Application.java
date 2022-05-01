package maktab74.practice11.org;

import maktab74.practice11.org.domain.LikeTwitt;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.utill.ApplicationContent;
import maktab74.practice11.org.utill.HibernateUtill;
import maktab74.practice11.org.utill.ShowMenu;
import maktab74.practice11.org.utill.UserBrif;

import java.util.List;


public class Application {
    public static void main(String[] args) {

        ApplicationContent applicationContent = new ApplicationContent();
        System.out.println("start");
        HibernateUtill.getEntityManagerFactory().createEntityManager();
        System.out.println("END");

        menu(applicationContent);

    }

    private static void
    menu(ApplicationContent applicationContent) {


        try {
            ShowMenu.menu();
            ShowMenu.enterNumber();

            int number = applicationContent.getIntegerScanner().nextInt();
            if (number == 1) {
                login(applicationContent);
            } else if (number == 2) {
                creatAcount(applicationContent);
                menu(applicationContent);
            } else if (number == 3) {
                exitApp(applicationContent);

            } else {
                ShowMenu.wrontNumber();
                menu(applicationContent);
            }
        } catch (Exception e) {
            ShowMenu.wrontNumber();
            applicationContent.getIntegerScanner().next();
            menu(applicationContent);
        }
    }


    private static void exitApp(ApplicationContent applicationContent) {
        applicationContent.getSecurityUser().logOut();
        ShowMenu.logOut();
        menu(applicationContent);

    }

    private static void login(ApplicationContent applicationContent) {

        ShowMenu.enterUserName();
        String userName = applicationContent.getStringScanner().nextLine();
        ShowMenu.enterPassword();
        String password = applicationContent.getStringScanner().nextLine();
        UserBrif userBrif = new UserBrif(userName, password);

        User userCurent = applicationContent.getUserService().loginByUserNameAndPassword(userBrif);
        if (userCurent != null) {

            ShowMenu.printWelcomeToProfile(userCurent);
            applicationContent.getSecurityUser().setCurentUser(userCurent);
            loginMenu(applicationContent, userCurent);
        } else {
            ShowMenu.wroungUserNameOrPassword();
            menu(applicationContent);
        }

    }

    private static void loginMenu(ApplicationContent applicationContent, User user) {
        try {


            ShowMenu.loginMenu();
            ShowMenu.enterNumber();
            int number = applicationContent.getIntegerScanner().nextInt();
            if (number == 1) {
                account(applicationContent, user);
            } else if (number == 2) {
                twitt(applicationContent, user);
            } else if (number == 3) {
                exitApp(applicationContent);

            } else {
                ShowMenu.wrontNumber();
                loginMenu(applicationContent, user);
            }
        } catch (Exception e) {
            ShowMenu.wrontNumber();
            applicationContent.getIntegerScanner().next();
            loginMenu(applicationContent, user);
        }
    }

    private static void twitt(ApplicationContent applicationContent, User user) {
        try {
            ShowMenu.twittItem();
            int number = applicationContent.getIntegerScanner().nextInt();
            if (number == 1) {
                createTwitt(applicationContent, user);
                twitt(applicationContent, user);
            } else if (number == 2) {
                showMyTwitt(applicationContent, user);
                twitt(applicationContent, user);
            } else if (number == 3) {
                showAllTwitt(applicationContent);
                likeAndComment(applicationContent, user);

            } else if (number == 4) {
                editMyTwitt(applicationContent, user);
                twitt(applicationContent, user);
            } else if (number == 5) {
                deletTwitt(applicationContent, user);
                twitt(applicationContent, user);
            } else if (number == 6) {
                loginMenu(applicationContent, user);
            } else {
                ShowMenu.wrontNumber();
                twitt(applicationContent, user);
            }

        } catch (Exception e) {
            ShowMenu.wrontNumber();
            applicationContent.getIntegerScanner().next();
            twitt(applicationContent, user);
        }
    }

    private static void likeAndComment(ApplicationContent applicationContent, User user) {
        try {


            ShowMenu.showLikeAndComment();
            ShowMenu.enterNumber();
            int number = applicationContent.getIntegerScanner().nextInt();
            if (number == 1) {
                likeTwitt(applicationContent, user);
                likeAndComment(applicationContent, user);
            } else if (number == 2) {
                commentTwitt(applicationContent, user);
                likeAndComment(applicationContent, user);
            } else if (number == 3) {
                twitt(applicationContent, user);
            } else {
                ShowMenu.wrontNumber();

                likeAndComment(applicationContent, user);
            }
        } catch (Exception e) {
            ShowMenu.wrontNumber();
            applicationContent.getIntegerScanner().next();
            likeAndComment(applicationContent, user);
        }

    }

    private static void commentTwitt(ApplicationContent applicationContent, User user) {


        try {


            ShowMenu.commentItem();
            ShowMenu.enterNumber();
            int number = applicationContent.getIntegerScanner().nextInt();
            if (number == 1) {
                //creatComment(applicationContent);
                commentTwitt(applicationContent, user);
            } else if (number == 2) {

                // showComment(applicationContent, user);
            } else if (number == 3) {
                //   editComment(applicationContent, user);
            } else if (number == 4) {
                //  deletedComment(applicationContent, user);
                twitt(applicationContent, user);
            } else if (number == 5) {
                loginMenu(applicationContent, user);
            } else {
                ShowMenu.wrontNumber();
                commentTwitt(applicationContent, user);
            }
        } catch (Exception e) {
            ShowMenu.wrontNumber();
            applicationContent.getIntegerScanner().next();
            commentTwitt(applicationContent, user);
        }
    }

    private static void likeTwitt(ApplicationContent applicationContent, User user) {
        ShowMenu.showSelectIdTwitt();
        long numberId = applicationContent.getIntegerScanner().nextInt();

        Twitt twittFind = applicationContent.getEntityManager().find(Twitt.class, numberId);

        LikeTwitt likeTwitt = new LikeTwitt(1L, user, twittFind);

        LikeTwitt byUserTwittLike = applicationContent.getEntityManager().find(LikeTwitt.class, likeTwitt);
        if (byUserTwittLike != null) {
            applicationContent.getLikeTwittRepository().likeOrDislike(byUserTwittLike);

        } else {

            likeTwitt.setTwitt(twittFind);
            likeTwitt.setLikeTwitt(1L);
            likeTwitt.setUserLike(user);
            applicationContent.getLikeTwittRepository().saveAndEdit(likeTwitt);

        }
        ShowMenu.successfully();
    }

    private static void deletTwitt(ApplicationContent applicationContent, User user) {
        showMyTwitt(applicationContent, user);
        ShowMenu.showSelectId();
        long numberId = applicationContent.getIntegerScanner().nextInt();
        Twitt twitt = applicationContent.getEntityManager().find(Twitt.class, numberId);
        applicationContent.getTwittRepository().beginTransaction();
        applicationContent.getEntityManager().remove(twitt);
        applicationContent.getTwittRepository().commitTransaction();
        ShowMenu.successfully();

    }

    private static void showAllTwitt(ApplicationContent applicationContent) {
        List<Twitt> list = applicationContent.getTwittService().findAllTwitt();
        list.forEach(System.out::println);
    }

    private static void showMyTwitt(ApplicationContent applicationContent, User user) {
        List<Twitt> byUser = applicationContent.getTwittService().findByUser(user.getId());
        byUser.forEach(System.out::println);

    }

    private static void editMyTwitt(ApplicationContent applicationContent, User user) {
        showMyTwitt(applicationContent, user);
        ShowMenu.showSelectId();
        long numberId = applicationContent.getIntegerScanner().nextInt();
        Twitt selectTwitt = applicationContent.getEntityManager().find(Twitt.class, numberId);
        ShowMenu.showEnterTwitt();
        String twittWrite = applicationContent.getStringScanner().nextLine();
        if (twittWrite.equals("")) {
            selectTwitt.setWriteTwitt(selectTwitt.getWriteTwitt());
        } else {
            selectTwitt.setWriteTwitt(twittWrite);
        }
        selectTwitt.setUser(user);
        selectTwitt.setId(numberId);
        applicationContent.getTwittRepository().saveAndEdit(selectTwitt);
        ShowMenu.successfully();

    }

    private static void createTwitt(ApplicationContent applicationContent, User user) {

        ShowMenu.showEnterTwitt();
        String twittString = applicationContent.getStringScanner().nextLine();
        Twitt twitt = new Twitt(twittString, user);
        applicationContent.getTwittRepository().saveAndEdit(twitt);
        ShowMenu.successfully();

    }

    private static void account(ApplicationContent applicationContent, User user) {
        try {


            ShowMenu.showAccounItem();
            ShowMenu.enterNumber();
            int number = applicationContent.getIntegerScanner().nextInt();
            if (number == 1) {
                creatAcount(applicationContent);
                account(applicationContent, user);
            } else if (number == 2) {

                showAcount(applicationContent, user);
            } else if (number == 3) {
                editAccount(applicationContent, user);
            } else if (number == 4) {
                deletedAccount(applicationContent, user);

            } else if (number == 5) {
                loginMenu(applicationContent, user);
            } else {
                ShowMenu.wrontNumber();
                account(applicationContent, user);
            }
        } catch (Exception e) {
            ShowMenu.wrontNumber();
            applicationContent.getIntegerScanner().next();
            account(applicationContent, user);
        }
    }

    private static void deletedAccount(ApplicationContent applicationContent, User user) {
        applicationContent.getUserRepository().beginTransaction();
        applicationContent.getUserService().deletUser(user);
        applicationContent.getUserRepository().commitTransaction();
        // applicationContent.getUserRepository().delelt(user.getId());
        ShowMenu.successfully();
        exitApp(applicationContent);
        menu(applicationContent);

    }

    private static void editAccount(ApplicationContent applicationContent, User user) {
        ShowMenu.enterFirstName();
        String firstName = applicationContent.getStringScanner().nextLine();

        if (firstName.equals("")) {
            user.setFirstName(user.getFirstName());

        } else {
            user.setFirstName(firstName);

        }
        ShowMenu.enterLastName();
        String lastName = applicationContent.getStringScanner().nextLine();
        if (lastName.equals("")) {
            user.setLastName(user.getLastName());
        } else {
            user.setLastName(lastName);

        }
        ShowMenu.enterUserName();
        String userName = applicationContent.getStringScanner().nextLine();
        if (userName.equals("")) {
            user.setFirstName(user.getFirstName());
        } else {
            user.setUsertName(userName);

        }
        ShowMenu.enterPassword();
        String password = applicationContent.getStringScanner().nextLine();
        if (password.equals("")) {

            user.setPassword(user.getPassword());
        } else {
            user.setPassword(password);
        }
        user.setId(user.getId());
        applicationContent.getUserRepository().saveAndEdit(user);
        ShowMenu.successfully();
        showAcount(applicationContent, user);
        loginMenu(applicationContent, user);

    }

    private static void showAcount(ApplicationContent applicationContent, User user) {

        ShowMenu.showAccounUser(user);
        account(applicationContent, user);
    }


    private static void creatAcount(ApplicationContent applicationContent) {
        ShowMenu.enterFirstName();
        String firstName = applicationContent.getStringScanner().nextLine();
        ShowMenu.enterLastName();
        String lastName = applicationContent.getStringScanner().nextLine();
        ShowMenu.enterUserName();
        String userName = applicationContent.getStringScanner().nextLine();
        ShowMenu.enterPassword();
        String password = applicationContent.getStringScanner().nextLine();

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsertName(userName);
        user.setPassword(password);
        applicationContent.getUserRepository().saveAndEdit(user);
        ShowMenu.successfully();

    }
}
