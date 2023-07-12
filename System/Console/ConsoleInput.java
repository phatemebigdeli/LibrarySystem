package System.Console;

import System.Book.Book;
import System.User.LoginInformation;
import System.User.SingIn;
import System.Tools.Validate;

import java.util.Scanner;

public class ConsoleInput {

    public static LoginInformation loginReadInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String input = scanner.nextLine();
        String inputUsername = input.toLowerCase();

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
                if (menuNumber >= 0 && menuNumber <= 6) {
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
        boolean flag = false;

        Scanner scanner = new Scanner(System.in);


        String membershipNumber="";
        while (flag==false){
            try {
                System.out.println("Enter national Code (your membership) :");
                membershipNumber = scanner.nextLine();
                boolean check = Validate.validateMemberShip(membershipNumber);
                if (check==true){
                    break;
                }
            }catch (Exception e){
                System.out.println("Error"+e);
            }
        }


        System.out.println("Enter name :");
        String namee = scanner.nextLine();
        String name = namee.toLowerCase();


        String inputUsername="";
        while (flag==false){
            try {
                System.out.println("Enter username:");
                inputUsername = scanner.nextLine();
                boolean check = Validate.validateUsername(inputUsername);
                if (check==true){
                    break;
                }else {
                    System.out.println("*The length of username characters must be between 6 and 16*");
                }
            }catch (Exception e){
                System.out.println("Error"+e);
            }
        }




        System.out.println("Enter password:");
        String inputPassword = scanner.nextLine();


        String inputPhone = null;
        while (flag==false){
            try {
                System.out.println("Enter phoneNumber (without 0):");
                inputPhone = scanner.nextLine();
                boolean check = Validate.validatePhonNamber(inputPhone);
                if (check == true) {
                    break;
                }
            }catch (Exception e){
                System.out.println("Error"+e);
            }
        }

        scanner.nextLine();


        String dateOfBirth="";
        while (flag==false){
            try {
                System.out.println("Enter date of birth (yyyy/mm/dd)");
                dateOfBirth = scanner.nextLine();
                boolean check = Validate.validateBirth(dateOfBirth);
                if (check==true){
                    break;
                }else {
                    System.out.println("*Enter the date of birth in the given format*");
                }
            }catch (Exception e){
                System.out.println("Error"+e);
            }
        }



        String inputEmail = "";
        while (flag==false) {
            try {
                System.out.println("Enter email:");
                inputEmail = scanner.nextLine();
                boolean check =Validate.validateEmail(inputEmail);
                if (check==true){
                    break;
                }
            }catch (Exception e){
                System.out.println("Error"+e);
            }
        }

        return new SingIn(membershipNumber,name, inputUsername, inputPassword, inputEmail,inputPhone,dateOfBirth);
    }


    public static Book bookInformation(){
        boolean flag = false;

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter name of the book: ");
        String nameBook = reader.nextLine();
        String nameOfTheBook = nameBook.toLowerCase();

        int price=0;
        System.out.println("Enter the price: ");
        while (flag==false){
            try {
                Scanner scanner = new Scanner(System.in);

                String num = scanner.nextLine();
                price = Integer.parseInt(num);
                break;
            }catch (NumberFormatException e) {
                System.out.println("Again enter the price:");
            }
            }


        System.out.println("Enter the place of print: ");
        String place = reader.nextLine();
        String placeOfPrint =place.toLowerCase();

        System.out.println("Enter name of the author:" );
        String au = reader.nextLine();
        String author = au.toLowerCase();

        System.out.println("Enter genre: ");
        String gen = reader.nextLine();
        String genre = gen.toLowerCase();



        int year=0;
        System.out.println("Enter print year: ");
        while (flag==false){
        try {

            String num = reader.nextLine();
            year = Integer.parseInt(num);
            break;
        }catch (NumberFormatException e){
            System.out.println("Again enter print year: ");
        }
        }



        int number=0;
        System.out.println("Enter the number of available books: ");
        while (flag==false){
            try {
                Scanner sc = new Scanner(System.in);

                String num = sc.nextLine();
                number = Integer.parseInt(num);
                break;
            }catch (NumberFormatException e){
                System.out.println("Again enter the number of available books: ");
            }
        }



        String ISBN="";
        while (flag==false){
            try {
                System.out.println("Enter ISBN(13 digits): ");
                ISBN = reader.nextLine();
                boolean check = Validate.validateISBN(ISBN);
                if (check == true) {
                    break;
                }else {
                    System.out.println("Note that ISBN is 13 digits long...");
                }
            }catch (Exception e){
                System.out.println("Error"+e);
            }
        }




        return new Book(nameOfTheBook,price,placeOfPrint,author,genre,year,number,ISBN);
    }
}