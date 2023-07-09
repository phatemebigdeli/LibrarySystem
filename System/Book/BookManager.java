package System.Book;
import System.Tools.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class BookManager {

    String filePathBook = "E:\\oop\\LibrarySystem\\src\\books.txt";
    public Map<String, Book> books;




    public BookManager() {
        books = new HashMap<>();
    }



    public Book addNewBook(Book book) {
        if (!this.books.containsKey(book.getISBN())) {
            this.books.put(book.getISBN(), book);
            return new Book(book.getNameOfTheBook(), book.getPrice(), book.getPlaceOfPrint(), book.getAuthor(), book.getGenre(), book.getPrintYear(), book.getNumber(), book.getISBN());
        } else {
            System.out.println("There is a book with " + book.getISBN() + " ISBN");
            return null;
        }
    }



    public void newBookStore(String nameOfTheBook, int price, String placeOfPrint, String author, String genre, int printYear, int number, String ISBN) {
        FileTools.fileAppend("E:\\oop\\LibrarySystem\\src\\books.txt", nameOfTheBook + "," + price + "," + placeOfPrint + "," + author + "," + genre + "," + printYear + "," + number + "," + ISBN);
        System.out.printf("The %s book added to system.\n", nameOfTheBook);

    }



    public List<Book> searchBook(String keyword, String searchOption) {
        List<Book> foundBooks = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filePathBook))) {

                String line;
                while ((line = br.readLine()) != null) {

                    String[] parts = line.split(",");
                    String nameOfTheBook = parts[0];
                    int price = Integer.parseInt(parts[1]);
                    String placeOfPrint = parts[2];
                    String author = parts[3];
                    String genre = parts[4];
                    int printYear = Integer.parseInt(parts[5]);
                    int number = Integer.parseInt(parts[6]);
                    String ISBN = parts[7];

                    Book book = new Book(nameOfTheBook, price, placeOfPrint, author, genre, printYear, number, ISBN);
                    BookManager BM = new BookManager();
                    BM.books.put(ISBN, book);


                    if (searchOption.equalsIgnoreCase("ISBN") && book.getISBN().equalsIgnoreCase(keyword)) {
                        foundBooks.add(book);
                    } else if (searchOption.equalsIgnoreCase("nameOfTheBook") && book.getNameOfTheBook().equalsIgnoreCase(keyword)) {
                        foundBooks.add(book);
                    } else if (searchOption.equalsIgnoreCase("author") && book.getAuthor().equalsIgnoreCase(keyword)) {
                        foundBooks.add(book);
                    } else if (searchOption.equalsIgnoreCase("genre") && book.getGenre().equalsIgnoreCase(keyword)) {
                        foundBooks.add(book);
                    }
                }
            } catch (Exception e) {

                System.out.println("An error occurred while loading books from the file");
                return null;
            }

        return foundBooks;

    }



    public List<Book> searchBookInList(String keyword, String searchOption, List<Book> bookList) {
        /*For the case that the file is not found*/
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (searchOption.equalsIgnoreCase("ISBN") && book.getISBN().equalsIgnoreCase(keyword)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }



    public void allBooks() {

        String filePath = "E:\\oop\\LibrarySystem\\src\\books.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String nameBook = fields[0];
                String author = fields[3];
                String genre = fields[4];
                int number = Integer.parseInt(fields[6]);

                System.out.print("name of the book: " + nameBook + "\t");
                System.out.print("Author: " + author + "\t");
                System.out.print("Genre: " + genre + "\t");
                System.out.println("Number of books available: " + number);
                System.out.println("------------------------------------------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /*For the case that the file is not found*/
    public void printTheListBookNow(Map<String, Book> allBooks) {
        for (Map.Entry<String, Book> entry : allBooks.entrySet()) {
            String key = entry.getKey();
            Book value = entry.getValue();
            System.out.println("ISBN: " + key +'\t'+ value.toString());
            System.out.println("--------------------------------");
        }
    }

}