package System.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EditInformation extends ReplaceWord {


    public void edit() {
        String filePathUser = "E:\\oop\\LibrarySystem\\src\\users.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePathUser));
            List<String> lines = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the username: ");
            String loggedInUsername = scanner.nextLine();
            System.out.print("Enter the password: ");
            String loggedInPassword = scanner.nextLine();

            int position = -1;
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts.length >= 3 && parts[2].equals(loggedInUsername) && parts[3].equals(loggedInPassword)) {
                    position = i;
                    break;
                }
            }

            if (position < 0) {
                System.out.println("Invalid username or password.");
                return;
            }

            String lineToEdit = lines.get(position);

            System.out.println("Current System.Tools.User Information:");
            System.out.println("1. username: "+Information.getUserName(lineToEdit));
            System.out.println("2. password: "+Information.getPassword(lineToEdit));
            System.out.println("3. name: "+Information.getName(lineToEdit));
            System.out.println("4. Email: " + Information.getEmail(lineToEdit));
            System.out.println("5. Phone Number: " + Information.getPhoneNumber(lineToEdit));
            System.out.println("6. Date of Birth: " + Information.getDateOfBirth(lineToEdit));

            System.out.print("Enter the number of the information to edit: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the new user name: ");
                    String newUserName = scanner.nextLine();
                    lineToEdit = Information.setUserName(lineToEdit,newUserName);
                    break;
                case 2:
                    System.out.println("Enter the new password: ");
                    String newPassword = scanner.nextLine();
                    lineToEdit = Information.setPassWord(lineToEdit,newPassword);
                    break;
                case 3:
                    System.out.println("Enter the new name: ");
                    String newName = scanner.nextLine();
                    lineToEdit = Information.setName(lineToEdit,newName);
                    break;
                case 4:
                    System.out.print("Enter the new email: ");
                    String newEmail = scanner.nextLine();
                    lineToEdit = Information.setEmail(lineToEdit, newEmail);
                    break;
                case 5:
                    System.out.print("Enter the new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    lineToEdit = Information.setPhoneNumber(lineToEdit, newPhoneNumber);
                    break;
                case 6:
                    System.out.print("Enter the new date of birth: ");
                    String newDateOfBirth = scanner.nextLine();
                    lineToEdit = Information.setDateOfBirth(lineToEdit, newDateOfBirth);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }


            lines.set(position, lineToEdit);

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePathUser));
            for (String modifiedLine : lines
            ) {
                writer.write(modifiedLine);
                writer.newLine();
            }
            writer.close();

            System.out.println("File edited successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public List<SingIn> editList(List<SingIn> userList) {
        List<SingIn> foundUsers = new ArrayList<>();

        /*For the case that the file is not found*/
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the word you want to edit: ");
        String originalWord = scanner.nextLine();
        System.out.print("Enter the replacement word: ");
        String replacementWord = scanner.nextLine();

        for (SingIn user : userList) {

            String information = user.toString();
            String[] separate = information.split(" ");
            ArrayList a = new ArrayList<>();

            a.add(separate[0]);
            a.add(separate[1]);
            a.add(separate[2]);
            a.add(separate[3]);
            a.add(separate[4]);
            a.add(separate[5]);
            a.add(separate[6]);



            List<String> edited = replaceWord(a, originalWord, replacementWord);

            String membership = edited.get(0);
            String name = edited.get(1);
            String userName = edited.get(2);
            String userPassword = edited.get(3);
            long phoneNum = Long.parseLong(edited.get(5));
            String birthOfDate = edited.get(6);
            String email = edited.get(4);

            SingIn sing = new SingIn(membership, userName, userPassword, name, email, phoneNum, birthOfDate);

            UserManager UM = new UserManager();
            UM.users.put(membership, sing);

            foundUsers.add(sing);

        }
        return foundUsers;


    }





    //INNER CLASS **************************
    public class Information{
        private static String getUserName(String line){
            String[] parts = line.split(",");
            return parts[2];
        }
        private static String getPassword(String line){
            String[] parts = line.split(",");
            return parts[3];
        }
        private static String getName(String line){
            String[] parts = line.split(",");
            return parts[4];
        }
        private static String getEmail(String line) {
            String[] parts = line.split(",");
            return parts[5];
        }

        private static String getPhoneNumber(String line) {
            String[] parts = line.split(",");
            return parts[6];
        }

        private static String getDateOfBirth(String line) {
            String[] parts = line.split(",");
            return parts[7];
        }

        private static String setUserName(String line, String newUserName) {
            String[] parts = line.split(",");
            parts[2] = newUserName;
            return String.join(",", parts);
        }
        private static String setPassWord(String line, String newPassWord) {
            String[] parts = line.split(",");
            parts[3] = newPassWord;
            return String.join(",", parts);
        }
        public static String setName(String line, String newName) {
            String[] parts = line.split(",");
            parts[4] = newName;
            return String.join(",",parts);
        }
        private static String setEmail(String line, String newEmail) {
            String[] parts = line.split(",");
            parts[5] = newEmail;
            return String.join(",", parts);
        }

        private static String setPhoneNumber(String line, String newPhoneNumber) {
            String[] parts = line.split(",");
            parts[6] = newPhoneNumber;
            return String.join(",", parts);
        }

        private static String setDateOfBirth(String line, String newDateOfBirth) {
            String[] parts = line.split(",");
            parts[7] = newDateOfBirth;
            return String.join(",", parts);
        }


    }
}