package System.Tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileTools {
    public static void fileAppend(String fileNAme, String newLine){
        PrintWriter pricesPrintWriter = null;
        try {
            pricesPrintWriter = new PrintWriter(new FileWriter(fileNAme,true),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pricesPrintWriter.println(newLine);
        pricesPrintWriter.close();
    }

    public static ArrayList<String> fileLines(String fileName) throws FileNotFoundException {
        ArrayList<String> lines=new ArrayList<>();

        Scanner stocksFileReader = new Scanner(new File(fileName));
        while (stocksFileReader.hasNext()){
            String newLine = stocksFileReader.nextLine();
            lines.add(newLine);
        }

        return lines;
    }

    public static List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void writeLinesToFile(List<String> lines,String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
