import System.Book.Book;
import System.Book.BookManager;
import System.Book.BorrowingBooks;
import System.Book.EditInformationBook;
import System.Console.ConsoleInput;
import System.Console.ConsoleMenu;
import System.Operation.ShowLists;
import System.User.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {

    boolean fileEnable = true;

    UserManager userManager = new UserManager();
    BookManager bookManager = new BookManager();

    ShowLists show = new ShowLists();
    BorrowingBooks borrowing = new BorrowingBooks();


    SingIn allUsers;
    Book allBooks;


    List<SingIn> userList = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();



    public void start() throws IOException {
        SingIn u = new SingIn("1","a","1","a","a",1,"1");
        allUsers = userManager.addNewUsers(u);
        Book b = new Book("A",100,"A","A","A",123,123,"123");
        allBooks = bookManager.addNewBook(b);



            while (true) {
                LoginItem loginItem = login();

                systemDoFunction(loginItem.getUserName(), loginItem.getUserType(), loginItem.getUserPassword());
            }


    }

    public void systemDoFunction(String userName, UserType userType, String password) throws IOException {
        System.out.println("Welcome " + userName+" as "+userType);
        int menuNumber;
         do{
            ConsoleMenu.menuPrint(userType);
            menuNumber = ConsoleInput.getMenuNumberAtStart();

            switch (menuNumber) {
                case 1:
                    if (userType == UserType.ADMIN) {
                        ConsoleMenu.userManagement();
                        int num = ConsoleInput.userAndBookManagement();
                        switch (num){
                            case 1:

                                SingIn singIn = ConsoleInput.singIn();
                                if (fileEnable==true) {
                                    userManager.newUserStore(singIn.getMembershipNumber(), singIn.getUserName(), singIn.getUserPassword(), singIn.getName(), singIn.getPhoneNum(), singIn.getDateOfBirth(), singIn.getEmail());
                                }
                                allUsers = userManager.addNewUsers(singIn);
                                userList.add(allUsers);

                                break;
                            case 2:
                                EditInformation editInformation = new EditInformation();
                                if (fileEnable==true){
                                    editInformation.edit();}

                                else if(fileEnable==false){
                                    List<SingIn> editUser = editInformation.editList(userList);
                                    for (SingIn user :editUser) {
                                        System.out.println("Your new information : " + "\n" +
                                                "membershipNumber=" +user.getMembershipNumber()+ "\n" +
                                                "name :" + user.getName() + "\n" +
                                                "userName :" + user.getUserName() + "\n" +
                                                "userPassword :" + user.getUserPassword() + "\n" +
                                                "email :" + user.getEmail() + "\n" +
                                                "phoneNum :" + user.getPhoneNum() + "\n" +
                                                "dateOfBirth :" + user.getDateOfBirth());

                                        System.out.println("Your information has been updated...");
                                    }
                                }
                                break;


                            case 3:
                                Scanner scanner = new Scanner(System.in);

                                if (fileEnable==true){

                                    System.out.print("Enter the search option (membership, name, username) : ");
                                    String searchOption = scanner.nextLine();

                                    System.out.print("Enter the word you want to search :");
                                    String keyword = scanner.nextLine();

                                    List<SingIn> foundUser = userManager.searchUser(keyword, searchOption);

                                    for (SingIn users : foundUser){
                                        if (foundUser != null) {
                                            System.out.println("User found!");
                                            System.out.println("Name: " + users.getUserPassword());
                                            System.out.println("Username: " + users.getUserName());
                                            System.out.println("phone number: " + users.getPhoneNum());
                                            System.out.println("---------------------");
                                        } else {
                                            System.out.println("System.Tools.User not found!");
                                        }}

                                }else if (fileEnable==false){

                                    System.out.print("Enter the word you want to search :");
                                    String keyword = scanner.nextLine();

                                    String searchOption = "membership";
                                    List<SingIn> foundUser = userManager.searchUserInList(keyword, searchOption,userList);

                                for (SingIn users : foundUser){
                                    if (foundUser != null) {
                                        System.out.println("User found!");
                                        System.out.println("Name: " + users.getName());
                                        System.out.println("Username: " + users.getUserName());
                                        System.out.println("phone number: " + users.getPhoneNum());
                                        System.out.println("---------------------");
                                    }
                                    else {
                                        System.out.println("User not found!");
                                    }}}
                                break;

                            case 4:
                                if (fileEnable==true){
                                    userManager.allUsers();
                                } else if (fileEnable==false) {
                                    userManager.printTheListNow(userManager.users);
                                }
                                break;
                        }



                    } else if (userType == UserType.USER) {
                        EditInformation editInformation = new EditInformation();
                        if (fileEnable==true){
                            editInformation.edit();}

                        else if(fileEnable==false){
                            List<SingIn> editUser = editInformation.editList(userList);
                            for (SingIn user :editUser) {
                                System.out.println("Your new information : " + "\n" +
                                        "membershipNumber=" +user.getMembershipNumber()+ "\n" +
                                        "name :" + user.getName() + "\n" +
                                        "userName :" + user.getUserName() + "\n" +
                                        "userPassword :" + user.getUserPassword() + "\n" +
                                        "email :" + user.getEmail() + "\n" +
                                        "phoneNum :" + user.getPhoneNum() + "\n" +
                                        "dateOfBirth :" + user.getDateOfBirth());
                            }
                        }
                    }
                    break;
                case 2:
                    if (userType == UserType.ADMIN) {
                        ConsoleMenu.bookManagement();
                        int num = ConsoleInput.userAndBookManagement();
                        switch (num){
                            case 1:
                                Book book = ConsoleInput.bookInformation();
                                if (fileEnable==true) {
                                    bookManager.newBookStore(book.getNameOfTheBook(), book.getPrice(), book.getPlaceOfPrint(), book.getAuthor(), book.getGenre(), book.getPrintYear(), book.getNumber(), book.getISBN());
                                }
                                allBooks = bookManager.addNewBook(book);
                                bookList.add(allBooks);
                                break;


                            case  2:
                                EditInformationBook editInformationBook = new EditInformationBook();
                                if (fileEnable==true){
                                    editInformationBook.edit();
                                } else if (fileEnable==false) {
                                   List<Book> editBook = editInformationBook.editListBook(bookList);
                                    for (Book book1 : editBook){
                                        System.out.println("New information book :"+"\n"+
                                                "book name :"+book1.getNameOfTheBook()+"\n"+
                                                "price :"+book1.getPrice()+"\n"+
                                                "place of print :"+book1.getPlaceOfPrint()+"\n"+
                                                "author :"+book1.getAuthor()+"\n"+
                                                "genre :"+book1.getGenre()+"\n"+
                                                "print year :"+book1.getPrintYear()+"\n"+
                                                "number of book:"+book1.getNumber()+"\n"+
                                                "ISBN :"+book1.getISBN()+"\n" );

                                    }

                                }break;
                            case 3:
                                Scanner scanner = new Scanner(System.in);

                                if (fileEnable==true) {
                                    System.out.print("Enter the search option (ISBN,nameOfTheBook,author,genre): ");
                                    String searchOption = scanner.nextLine();

                                    System.out.print("Enter the word you want to search : ");
                                    String keyword = scanner.nextLine();

                                    List<Book> foundBook = bookManager.searchBook(keyword, searchOption);
                                    for (Book bookk : foundBook) {
                                        if (foundBook != null) {
                                            System.out.println("Book found!");
                                            System.out.println("name: " + bookk.getNameOfTheBook());
                                            System.out.println("author: " + bookk.getAuthor());
                                            System.out.println("number: " + bookk.getNumber());
                                            System.out.println("genre: " + bookk.getGenre());
                                            System.out.println("---------------------");

                                        }else{
                                            System.out.println("Book with this profile was not found...");
                                        }}
                                }
                                else if (fileEnable==false){
                                    System.out.print("Enter the word you want to search : ");
                                    String keyword = scanner.nextLine();

                                    String searchOption = "ISBN";
                                    List<Book> foundBook = bookManager.searchBookInList(keyword, searchOption, bookList);

                                    for (Book bookk : foundBook) {
                                        if (foundBook != null) {
                                            System.out.println("Book found!");
                                            System.out.println("name: " + bookk.getNameOfTheBook());
                                            System.out.println("author: " + bookk.getAuthor());
                                            System.out.println("number: " + bookk.getNumber());
                                            System.out.println("genre: " + bookk.getGenre());
                                            System.out.println("---------------------");

                                        }else{
                                            System.out.println("Book with this profile was not found...");
                                        }}
                                }break;

                            case 4:
                                if (fileEnable==true){
                                    bookManager.allBooks();
                                } else if (fileEnable==false) {
                                    bookManager.printTheListBookNow(bookManager.books);
                                }


                                break;
                        }


                    } else if (userType == UserType.USER) {
                        Scanner scanner = new Scanner(System.in);

                        if (fileEnable==true) {
                            System.out.print("Enter the search option (ISBN,nameOfTheBook,author,genre): ");
                            String searchOption = scanner.nextLine();

                            System.out.print("Enter the word you want to search : ");
                            String keyword = scanner.nextLine();

                            List<Book> foundBook = bookManager.searchBook(keyword, searchOption);
                            for (Book bookk : foundBook) {
                                if (foundBook != null) {
                                    System.out.println("Book found!");
                                    System.out.println("name: " + bookk.getNameOfTheBook());
                                    System.out.println("author: " + bookk.getAuthor());
                                    System.out.println("number: " + bookk.getNumber());
                                    System.out.println("genre: " + bookk.getGenre());
                                    System.out.println("---------------------");

                                }else{
                                    System.out.println("Book with this profile was not found...");
                                }}
                        }
                        else if (fileEnable==false){
                            System.out.print("Enter the word you want to search : ");
                            String keyword = scanner.nextLine();

                            String searchOption = "ISBN";
                            List<Book> foundBook = bookManager.searchBookInList(keyword, searchOption, bookList);

                            for (Book bookk : foundBook) {
                                if (foundBook != null) {
                                    System.out.println("Book found!");
                                    System.out.println("name: " + bookk.getNameOfTheBook());
                                    System.out.println("author: " + bookk.getAuthor());
                                    System.out.println("number: " + bookk.getNumber());
                                    System.out.println("genre: " + bookk.getGenre());
                                    System.out.println("---------------------");

                                }else {
                                    System.out.println("Book with this profile was not found...");
                                }}}}

                    break;
                case 3:
                    if (userType == UserType.ADMIN) {
                        ConsoleMenu.borrowedMenu();
                        int num = ConsoleInput.borrowedMenu();
                        switch (num){
                            case 1:
                                if (fileEnable==true){
                                borrowing.borrowing();}
                                else if (fileEnable==false){
                                    borrowing.borrowingInList(bookList);
                                }
                                break;
                            case 2:
                                show.borrowedBooks();
                                break;
                            case 3:
                                show.allBooksForSpecialUser();
                                break;
                        }

                    } else if (userType == UserType.USER) {
                        bookManager.allBooks();
                    }

                    break;
                case 4:
                    if (userType == UserType.ADMIN) {
                        System.out.println("Invalid choice. Please enter a valid choice.");
                        break;
                    } else if (userType == UserType.USER) {

                        if (fileEnable==true){
                            borrowing.borrowing();}
                        else if (fileEnable==false){
                            borrowing.borrowingInList(bookList);
                        }
                    }
                    break;
                case 5:
                    if (userType == UserType.ADMIN) {
                        System.out.println("Invalid choice. Please enter a valid choice.");
                        break;
                    } else if (userType == UserType.USER) {
                        show.allBooksForSpecialUser();
                    }
                    break;
                case 0:
                    System.out.println("Exiting Library System. Thank you for using our services!");
                    break;

                    default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }while (menuNumber!=0);
    }
    public LoginItem login() throws IOException {

        while (true) {
            LoginInformation loginReadInformation = ConsoleInput.loginReadInformation();

            LoginItem loginItem = Login.validate(loginReadInformation.getInputUsername(), loginReadInformation.getInputPassword());
            if (loginItem != null) {
                return loginItem;
            } else {
                System.out.println("*** Invalid username or password. ***\n");
                System.out.println("If you are using the library system for the first time, please create your account");
                System.out.println(" *~*~*~*~*~* sign in as a user *~*~*~*~*~*");
                SingIn singIn = ConsoleInput.singIn();
                userManager.newUserStore(singIn.getMembershipNumber(), singIn.getUserName(), singIn.getUserPassword(), singIn.getName(), singIn.getPhoneNum(), singIn.getDateOfBirth(), singIn.getEmail());
                userManager.addNewUsers(singIn);
                systemDoFunction(singIn.getUserName(), UserType.USER, singIn.getUserPassword());
            }
        }
    }
}