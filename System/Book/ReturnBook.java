package System.Book;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReturnBook {

    String memship="";
    String bookName="";
    String author = "";



    private static final int MAX_LOAN_DAYS = 14;


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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your membership :");
        memship = scanner.nextLine();

        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();

        System.out.println("Enter name book for return :");
        bookName =scanner.nextLine();

        System.out.println("Enter name author: ");
        author = scanner.nextLine();



        if (authenticateMember(memship)) {
            if (isBookLoaned(bookName)) {
                LocalDate loanDate = getLoanDate(memship, bookName);
                LocalDate currentDate = LocalDate.now();
                long daysDifference = ChronoUnit.DAYS.between(loanDate, currentDate);

                if (daysDifference <= MAX_LOAN_DAYS) {
                    returnBook(author, bookName);
                    System.out.println("The book has been returned successfully.");
                } else {
                    int lateDays = (int) (daysDifference - MAX_LOAN_DAYS);
                    int penalty = calculatePenalty(lateDays);

                    recordPenalty(memship, bookName, penalty);
                    returnBook(author, bookName);
                    System.out.println("The book was returned " + lateDays + " days late.");
                    System.out.println("Calculated penalty : " + penalty + " $");
                }
            } else {
                System.out.println("A book with this specification has not been borrowed...");
            }
        } else {
            System.out.println("The membership or password is incorrect...");
        }
    }



    private boolean authenticateMember(String memberId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileBorrowing))) {
            String line;
            boolean isMatching = false;
            while ((line = reader.readLine()) != null) {


                if (line.equals("--------------------------------------------------------------------------------------------------")) {
                    isMatching = false;
                }
                if (isMatching) {
                    return true;

                }
                if (line.startsWith(memberId)) {
                    isMatching = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    private boolean isBookLoaned(String bookName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileBorrowing))) {
            String line;
            boolean isMatching = false;
            while ((line = reader.readLine()) != null) {

                if (line.equals("--------------------------------------------------------------------------------------------------")) {
                    isMatching = false;
                }   if (line.startsWith(bookName)) {
                    isMatching = true;
                }
                if (isMatching) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    private  LocalDate getLoanDate(String memship, String bookName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileBorrowing))) {
            String line;
            boolean isMatching = false;
            while ((line = reader.readLine()) != null) {

                if (line.equals("--------------------------------------------------------------------------------------------------")) {
                    isMatching = false;
                }
                if (isMatching) {
                    String[] parts = line.split(",");
                    String  dateStr = parts[3];
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate loanDate = LocalDate.parse(dateStr,formatter);
                    return loanDate;
                }
                if (line.startsWith(memship)) {
                    isMatching = true;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




    private void returnBook(String Author, String bookName) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileBorrowing));
            StringBuilder content = new StringBuilder();

            String line;
            boolean isMatching = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(memship)) {
                    isMatching = true;
                }
                if (isMatching) {
                    if (line.contains(bookName)) {
                        continue;
                    }
                    content.append(line).append("\n");
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileBorrowing));

            writer.write(content.toString());
            writer.close();
            reduceTheBook();



        } catch (IOException e) {
            e.printStackTrace();
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

            int position = -1;
            for (int i = 0; i < allLines.size(); i++) {
                String[] parts = allLines.get(i).split(",");
                if (parts[0].equals(bookName) && parts[3].equals(author)) {
                    position = i;
                    break;
                }
            }
            if (position < 0) {
                System.out.println("No book was found with this specification...");
                return;
            }
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


        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
    }



    private String setNumber(String line) {
        String[] parts = line.split(",");
        int bookCount = Integer.parseInt(parts[6]);
        String updatedCount = String.valueOf(bookCount + 1);
        parts[6] = updatedCount;
        return String.join(",", parts);
    }



    private int calculatePenalty(int lateDays) {
        return lateDays;
    }



    private  void recordPenalty(String memberId, String bookName, int penalty) {
        try (FileWriter writer = new FileWriter("E:\\oop\\LibrarySystem\\src\\penalty.txt", true)) {
            writer.write(memberId + "," + bookName + "," + LocalDate.now() + "," + penalty + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}