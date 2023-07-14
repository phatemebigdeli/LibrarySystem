package System.Book;

import System.Tools.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BorrowingBooks {


    String bookName = "";
    String authorName = "";

    String word1 = "";

    String fileUsers = "E:\\oop\\LibrarySystem\\src\\users.txt";
    String fileBorrowing = "E:\\oop\\LibrarySystem\\src\\Borrowing.txt";
    String fileBooks = "E:\\oop\\LibrarySystem\\src\\books.txt";




    public void borrowing() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Have you ever borrowed a book?");
            String answer = scanner.nextLine();


            if (answer.equalsIgnoreCase("yes")) {
                Scanner scan = new Scanner(System.in);

                System.out.print("Enter your membership: ");
                word1 = scan.nextLine();

                System.out.print("Enter your password: ");
                String word2 = scan.nextLine();

                List<String> lines = FileTools.readLinesFromFile(fileBorrowing);

                List<String> updatedLines = new ArrayList<>();

                for (String line : lines) {
                    String[] words = line.split(",");
                    if (words[0].equals(word1) && words[1].equals(word2)) {

                        System.out.print("Please enter the name of the book you want to borrow: ");
                        bookName = scan.nextLine();

                        System.out.print("Please enter the author's name: ");
                        authorName = scan.nextLine();


                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.DAY_OF_MONTH, 14);

                        Date currentDate = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

                        Date futureDate = calendar.getTime();


                        line += "\n" + bookName + "," + authorName + "," + "Date Received : "+"," + dateFormat.format(currentDate) + "," + "  Your return date : "+"," + dateFormat.format(futureDate);

                    }updatedLines.add(line);

                }

                FileTools.writeLinesToFile(updatedLines, fileBorrowing);
                reduceTheBook();
            } else if (answer.equalsIgnoreCase("no")) {
                Scanner scan = new Scanner(System.in);

                System.out.print("Enter your membership: ");
                word1 = scan.nextLine();

                System.out.print("Enter your password: ");
                String word2 = scan.nextLine();

                List<String> lines = FileTools.readLinesFromFile(fileUsers);

                for (String line : lines) {
                    String[] words = line.split(",");
                    String id = words[1];
                    String pass = words[3];
                    if (id.equals(word1) && pass.equals(word2)) {

                        System.out.print("Please enter the name of the book you want to borrow: ");
                        bookName = scan.nextLine();

                        System.out.print("Please enter the author's name: ");
                        authorName = scan.nextLine();

                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.DAY_OF_MONTH, 14);

                        Date currentDate = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

                        // Book delivery time after 14 days
                        Date futureDate = calendar.getTime();

                        FileTools.fileAppend(fileBorrowing, word1 + "," + word2 + "\n" + bookName + "," + authorName +","+
                                "Date Received : ," + dateFormat.format(currentDate) + "," + "Your return date : "+"," + dateFormat.format(futureDate) +
                                "\n" + "--------------------------------------------------------------------------------------------------");

                        reduceTheBook();
                    }
                }
            }
        }



    public void borrowingInList(List<Book> bookList){
        Scanner reader = new Scanner(System.in);
        BookManager BM = new BookManager();
        System.out.println("Enter ISBN: ");
        String ISBN = reader.nextLine();
        boolean exist = BM.books.containsKey(ISBN);
        if (exist==false){
            for (Book book : bookList ){
                int num = book.getNumber()-1;
                book.setNumber(num);
                System.out.println("book name: "+book.getNameOfTheBook()+"\t book number: "+num+"\tauthor: "+book.getAuthor());

            }
        }else{
            System.out.println("not valid...");
        }
    }



    private void reduceTheBook() {
        try {
            File file = new File(fileBooks);
            FileReader reader = new FileReader(file);
            BufferedReader read = new BufferedReader(reader);
            List<String> allLines = new ArrayList<>();

            String line;
            while ((line = read.readLine()) != null) {
                allLines.add(line);
            }
            read.close();
            String[] parts = new String[0];
            int position = -1;
            for (int i = 0; i < allLines.size(); i++) {
                parts = allLines.get(i).split(",");
                if (parts[0].equals(bookName) && parts[3].equals(authorName)) {
                    position = i;
                    break;
                }
            }
            if (position < 0) {
                System.out.println("No book was found with this specification...");
                return;
            }

            if ( !parts[6].equals("not available")) {
                String lineToEdit = allLines.get(position);

                lineToEdit = setNumber(lineToEdit);

                allLines.set(position, lineToEdit);


                //We write the applied changes in the file
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileBooks));
                for (String modifiedLine : allLines) {
                    writer.write(modifiedLine);
                    writer.newLine();
                }
                writer.close();

                System.out.printf("The book was successfully borrowed by %s ", word1);
                System.out.println();
            }else {
                System.out.println("This book is currently not available...");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
    }



    private String setNumber(String line) {
        String[] parts = line.split(",");
        int bookCount = Integer.parseInt(parts[6]);
        String updatedCount = "";
        if (bookCount-1>0) {
            updatedCount = String.valueOf(bookCount - 1);
        }else if(bookCount-1==0){
            updatedCount = "not available";
        }
        parts[6] = updatedCount;
        return String.join(",", parts);
    }
}