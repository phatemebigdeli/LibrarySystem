package System.Operation;

import java.io.*;
import java.util.Scanner;

public class ShowLists {

    public void allBooksForSpecialUser(){
        Scanner read = new Scanner(System.in);

        String fileBorrowing = "E:\\oop\\LibrarySystem\\src\\Borrowing.txt";
        System.out.print("Enter your membership: ");
        String word1 = read.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileBorrowing))) {
            String line;
            boolean isMatching = false;
            while ((line = br.readLine()) != null) {
                if (line.equals("--------------------------------------------------------------------------------------------------")) {
                    isMatching = false;
                }
                if (isMatching) {
                    System.out.println(line);
                }
                if (line.startsWith(word1)) {
                    isMatching = true;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void borrowedBooks(){
        String fileBorrowing = "E:\\oop\\LibrarySystem\\src\\Borrowing.txt";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileBorrowing));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}