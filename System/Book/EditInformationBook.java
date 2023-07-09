package System.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditInformationBook extends ReplaceWord {

    public void edit(){
        String filePath = "E:\\oop\\LibrarySystem\\src\\books.txt";

        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String> lines = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter name of the book: ");
            String nameBook = scanner.nextLine();
            System.out.print("Enter the ISBN: ");
            String ISBN = scanner.nextLine();

            int position = -1;
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts[0].equals(nameBook) && parts[7].equals(ISBN)) {
                    position = i;
                    break;
                }
            }

            if (position < 0) {
                System.out.println("No book was found with this specification...");
                return;
            }

            String lineToEdit = lines.get(position);
            System.out.println("Which part do you want to edit?\n");

            System.out.println("1. Author: "+ EditInformationBook.Information.getAuthor(lineToEdit));
            System.out.println("2. Genre: "+ EditInformationBook.Information.getGenre(lineToEdit));
            System.out.println("3. Number: "+ EditInformationBook.Information.getNumber(lineToEdit));
            System.out.println("4. price: "+EditInformationBook.Information.getPrice(lineToEdit));

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the new name of the author: ");
                    String newAuthor = scanner.nextLine();
                    lineToEdit = EditInformationBook.Information.setAuthor(lineToEdit,newAuthor);
                    break;
                case 2:
                    System.out.println("Enter the new genre: ");
                    String newGenre = scanner.nextLine();
                    lineToEdit = EditInformationBook.Information.setGenre(lineToEdit,newGenre);
                    break;
                case 3:
                    System.out.println("Enter the new number: ");
                    String newNumber = scanner.nextLine();
                    lineToEdit = EditInformationBook.Information.setNumber(lineToEdit,newNumber);
                    break;
                case 4:
                    System.out.println("Enter the new price: ");
                    String newPrice = scanner.nextLine();
                    lineToEdit = EditInformationBook.Information.setPrice(lineToEdit,newPrice);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }


            lines.set(position, lineToEdit);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String modifiedLine : lines
            ) {
                writer.write(modifiedLine);
                writer.newLine();
            }
            writer.close();

            System.out.printf("%s book corrections were edited...",nameBook);
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List<Book> editListBook(List<Book> bookList){
        List<Book> foundBooks = new ArrayList<>();

        /*For the case that the file is not found*/
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the word you want to edit: ");
        String originalWord = scanner.nextLine();
        System.out.print("Enter the replacement word: ");
        String replacementWord = scanner.nextLine();

        for (Book book : bookList) {

            String information = book.toString();
            String[] separate = information.split(" ");
            ArrayList Components = new ArrayList<>();

//                foundUsers.add(user);
            Components.add(separate[0]);
            Components.add(separate[1]);
            Components.add(separate[2]);
            Components.add(separate[3]);
            Components.add(separate[4]);
            Components.add(separate[5]);
            Components.add(separate[6]);

            List<String> edited = replaceWord(Components, originalWord, replacementWord);

            String nameOfTheBook = edited.get(0);
            int price = Integer.parseInt(edited.get(1));
            String placeOfPrint = edited.get(2);
            String author = edited.get(3);
            String genre = edited.get(4);
            int printYear = Integer.parseInt(edited.get(5));
            int number = Integer.parseInt(edited.get(6));
            String ISBN = edited.get(7);

           Book boook = new Book(nameOfTheBook,price,placeOfPrint,author,genre,printYear,number,ISBN);
            BookManager BM = new BookManager();
            BM.books.put(ISBN, boook);

            foundBooks.add(boook);
            System.out.println("Your information has been updated...");

        }
        return foundBooks;


    }




    //INNER CLASS**********************
    public static class Information{
        private static String getAuthor(String line){
            String[] parts = line.split(",");
            return parts[3];
        }
        private static String getGenre(String line){
            String[] parts = line.split(",");
            return parts[4];
        }
        private static String getNumber(String line){
            String[] parts = line.split(",");
            return parts[6];
        }
        private static String getPrice(String line) {
            String[] parts = line.split(",");
            return parts[1];}


        private static String setAuthor(String line, String newUserName) {
            String[] parts = line.split(",");
            parts[3] = newUserName;
            return String.join(",", parts);
        }

        private static String setGenre(String line, String newPassWord) {
            String[] parts = line.split(",");
            parts[4] = newPassWord;
            return String.join(",", parts);
        }
        public static String setNumber(String line, String newNum) {
            String[] parts = line.split(",");
            parts[6] = newNum;
            return String.join(",",parts);
        }
        private static String setPrice(String line, String newEmail) {
            String[] parts = line.split(",");
            parts[1] = newEmail;
            return String.join(",", parts);
        }

    }

}
