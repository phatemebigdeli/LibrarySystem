package System.Operation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowLists {


    public void allBooksForSpecialUser(){
        Scanner read = new Scanner(System.in);

        String fileBorrowing = "E:\\oop\\LibrarySystem\\src\\Borrowing.txt";
        System.out.print("Enter your name: ");
        String word1 = read.nextLine();

//        System.out.print("Enter your password: ");
//        String word2 = read.nextLine();

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



//            File file = new File(fileBorrowing);
//            Scanner scanner = new Scanner(file);
//            List<String> allLines = new ArrayList<>();
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                allLines.add(line);
//
//                int i;
//
//                for (i = 0; i < allLines.size(); i++) {
//                    if (allLines.get(i).equals("--------------------------------------------------------------------------------------------------")){
//                        break;
//                    }
//                }
//                    String[] parts = allLines.get(i).split(",");
//                    if (parts[0].equals(word1) && parts[1].equals(word2)) {
//                        while (line.equals("--------------------------------------------------------------------------------------------------")){
//                        System.out.println(allLines.get(i));
//                        i++;
//                        }
//                        break;
//                    }
//                }
//
//
//
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Not found... " + e.getMessage());
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