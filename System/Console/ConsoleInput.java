package System.Console;

import System.Book.Book;
import System.User.LoginInformation;
import System.User.SingIn;

import java.util.Scanner;

public class ConsoleInput {

    public static LoginInformation loginReadInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String inputUsername = scanner.nextLine();

        System.out.println("Enter password:");
        String inputPassword = scanner.nextLine();

        return new LoginInformation(inputUsername, inputPassword);
    }


    public static int userAndBookManagement(){
        Scanner read = new Scanner(System.in);
        int menuNumber = 0;
        while (menuNumber == 0)
            try {
                System.out.println("Enter menu number:");
                String inputMenuNumber = read.nextLine();
                menuNumber = Integer.parseInt(inputMenuNumber);
                if (menuNumber > 0 && menuNumber <= 4) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid menu number(" + e.getMessage() + ")");
            }
        return menuNumber;
    }


    public static int getMenuNumberAtStart() {
        Scanner scanner = new Scanner(System.in);
        int menuNumber = 0;
        while (menuNumber == 0)
            try {
                System.out.println("Enter menu number:");
                String inputMenuNumber = scanner.nextLine();
                menuNumber = Integer.parseInt(inputMenuNumber);
                if (menuNumber >= 0 && menuNumber <= 5) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid menu number(" + e.getMessage() + ")");
            }
        return menuNumber;
    }


    public static  int borrowedMenu(){
        Scanner scan = new Scanner(System.in);
        int menuNumber = 0;
        while (menuNumber == 0)
            try {
                System.out.println("Enter menu number:");
                String inputMenuNumber = scan.nextLine();
                menuNumber = Integer.parseInt(inputMenuNumber);
                if (menuNumber > 0 && menuNumber <= 3) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid menu number(" + e.getMessage() + ")");
            }
        return menuNumber;

    }


    public static SingIn singIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter national Code :");
        String membershipNumber = scanner.nextLine();

        System.out.println("Enter name :");
        String name = scanner.nextLine();

        System.out.println("Enter username:");
        String inputUsername = scanner.nextLine();

        System.out.println("Enter password:");
        String inputPassword = scanner.nextLine();

        System.out.println("Enter phoneNumber :");
        long inputPhone = scanner.nextLong();
        scanner.nextLine();
        System.out.println(" Enter date of birth");
        String dateOfBirth = scanner.nextLine();

        System.out.println("Enter email:");
        String inputEmail = scanner.nextLine();



        return new SingIn(membershipNumber,name, inputUsername, inputPassword, inputEmail,inputPhone,dateOfBirth);
    }


    public static Book bookInformation(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter name of the book: ");
        String nameOfTheBook = reader.nextLine();

        System.out.println("Enter the price: ");
        int price = reader.nextInt();
        reader.nextLine();

        System.out.println("Enter the place of print: ");
        String placeOfPrint = reader.nextLine();

        System.out.println("Enter name of the author:" );
        String author = reader.nextLine();

        System.out.println("Enter genre: ");
        String genre = reader.nextLine();

        System.out.println("Enter print year: ");
        int year = reader.nextInt();

        System.out.println("Enter the number of available books: ");
        int number = reader.nextInt();
        reader.nextLine();

        System.out.println("Enter ISBN: ");
        String ISBN = reader.nextLine();

        return new Book(nameOfTheBook,price,placeOfPrint,author,genre,year,number,ISBN);
    }
}