package maktab74.practice11.org;

import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.utill.ApplicationContent;
import maktab74.practice11.org.utill.HibernateUtill;
import maktab74.practice11.org.utill.ShowMenu;
import maktab74.practice11.org.utill.UserBrif;


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
                // createTwitt();
            } else if (number == 2) {
                //showMyTwitt();

            } else if (number == 3) {
                // showAllTwitt();
            } else if (number == 4) {
                // editMyTwitt();
            } else if (number == 5) {
                // deletTwitt();
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
