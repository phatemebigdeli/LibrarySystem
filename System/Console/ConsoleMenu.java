package System.Console;
import System.User.UserType;

public class ConsoleMenu {

        public static void menuPrint(UserType userType) {
            if (userType == UserType.ADMIN)
                menuForAdmin();
            else if (
                    userType == UserType.USER) {
                menuForUser();
            }
        }


        public static void menuForAdmin(){
            welcome();
            System.out.println("1. User Management");
            System.out.println("2. Book Management");
            System.out.println("3. Borrowed information");
            System.out.println("0. Exit");
        }


        public static void menuForUser(){
            welcome();
            System.out.println("1. Update and edit user information");
            System.out.println("2. Search books");
            System.out.println("3. Display the list of all books");
            System.out.println("4. Lending books");
            System.out.println("5. Displaying borrowed books for a specific user");
            System.out.println("0. Exit");
        }


        public static void welcome(){
            System.out.println();
            System.out.println("* * * * * * * * * * * * * * *");
            System.out.println("* Welcome to Library System *");
            System.out.println("* * * * * * * * * * * * * * *");
        }


        public static void userManagement(){
        System.out.println("1. Add user to the system");
        System.out.println("2. Update and edit user information");
        System.out.println("3. Search users");
        System.out.println("4. Display the list of all users");
    }


        public static void bookManagement(){
        System.out.println("1. Add book to the system");
        System.out.println("2. Update and edit book information");
        System.out.println("3. Search books");
        System.out.println("4. Display the list of all books");
    }


        public static void borrowedMenu(){
        System.out.println("1. Lending books");
        System.out.println("2. Borrowed books and their due dates");
        System.out.println("3. Displaying borrowed books for a specific user");
    }
}