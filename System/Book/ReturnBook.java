package System.Book;

import System.Tools.FileTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReturnBook {

    String bookName = "";
    String authorName = "";

    String word1 = "";

    String fileUsers = "E:\\oop\\LibrarySystem\\src\\users.txt";
    String fileBorrowing = "E:\\oop\\LibrarySystem\\src\\Borrowing.txt";
    String fileBooks = "E:\\oop\\LibrarySystem\\src\\books.txt";



    public ReturnBook() {
    }

    public void returnBookInLst(List<Book> bookList) {
        Scanner reader = new Scanner(System.in);
        BookManager BM = new BookManager();
        System.out.println("Enter ISBN: ");
        String ISBN = reader.nextLine();
        boolean exist = BM.books.containsKey(ISBN);
        if (exist == false) {
            for (Book book : bookList) {
                int num = book.getNumber() + 1;
                book.setNumber(num);
                System.out.println("book name: " + book.getNameOfTheBook() + "\t book number: " + num + "\tauthor: " + book.getAuthor());

            }
        } else {
            System.out.println("not valid book...");
        }
    }
    public void returnBook() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your name: ");
        word1 = scan.nextLine();

        System.out.print("Enter your password: ");
        String word2 = scan.nextLine();

        List<String> lines = FileTools.readLinesFromFile(fileBorrowing);

        List<String> updatedLines = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.split(",");
            if (words[0].equals(word1) && words[1].equals(word2)) {

                System.out.print("Please enter the name of the book you want to return: ");
                bookName = scan.nextLine();

                System.out.print("Please enter the author's name: ");
                authorName = scan.nextLine();


            }
        }
    }
}