package maktab74.practice11.org.utill;

import maktab74.practice11.org.domain.User;

public class ShowMenu {

    public static void menu() {
        System.out.println("=================");
        System.out.println("1. Login");
        System.out.println("2. Create Acount");
        System.out.println("3. Exit");
        System.out.println("=================");
    }

    public static void enterNumber() {
        System.out.println("Enter number ? ");
    }

    public static void wrontNumber() {
        System.out.println("wront Number !!!");

    }

    public static void enterFirstName() {
        System.out.println("Enter First Name :");
    }


    public static void enterLastName() {
        System.out.println("Enter Last Name :");
    }

    public static void enterUserName() {
        System.out.println("Enter User Name :");
    }

    public static void enterPassword() {
        System.out.println("Enter Password :");
    }

    public static void successfully() {
        System.out.println("***  Done Successfully ! ***");
    }

    public static void printWelcomeToProfile(User user) {
        System.out.println("***  Welcome To Profile" +
                "   " + user.getFirstName() + "  " + user.getLastName() + "   ***");
    }

    public static void wroungUserNameOrPassword() {
        System.out.println("wrong UserName or Password !");
    }

    public static void logOut() {
        System.out.println("Log out ...");
        System.out.println("Good By !");
    }

    public static void loginMenu() {
        System.out.println("=================");
        System.out.println("1. Account");
        System.out.println("2. Twitt");
        System.out.println("3. Log Out");
        System.out.println("=================");
    }

    public static void showAccounItem() {
        System.out.println("=================");
        System.out.println("1. Add Account");
        System.out.println("2. Show Account");
        System.out.println("3. Edit Acount");
        System.out.println("4. Delet Accounr");
        System.out.println("5. Back");
        System.out.println("=================");
    }

    public static void showAccounUser(User user) {
        System.out.println("=================");
        System.out.println("first Name : " + user.getFirstName());
        System.out.println("Last Name : " + user.getLastName());
        System.out.println("User Name : " + user.getUsertName());
        System.out.println("=================");
    }

    public static void twittItem() {

        System.out.println("=================");
        System.out.println("1. create Twitt");
        System.out.println("2. Show my Twitt");
        System.out.println("3. Show All Twitt");
        System.out.println("4. Edit Twitt");
        System.out.println("5. Delet Twitt");
        System.out.println("6. Back");
        System.out.println("=================");
    }
}