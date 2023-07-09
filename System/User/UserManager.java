package System.User;
import System.Tools.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UserManager {

    String filePathUser = "E:\\oop\\LibrarySystem\\src\\users.txt";

    public Map<String, SingIn> users;


    public UserManager() {
        users = new HashMap<>();
    }


    public SingIn addNewUsers(SingIn singIn) {
        if (!this.users.containsKey(singIn.getMembershipNumber())) {
            this.users.put(singIn.getMembershipNumber(), singIn);
            return new SingIn(singIn.getMembershipNumber(), singIn.getUserName(), singIn.getUserPassword(), singIn.getName(), singIn.getEmail(), singIn.getPhoneNum(), singIn.getDateOfBirth());
        } else {
            System.out.println("There is a user with membership number " + singIn.getMembershipNumber() + " in the system");
        }
        return null;
    }


    public void newUserStore(String membershipNumber, String name, String userName, String userPassword, long phoneNum, String dateOfBirth, String email) {
        FileTools.fileAppend("E:\\oop\\LibrarySystem\\src\\users.txt", "USER," + membershipNumber + "," + userName + "," + userPassword + "," + name + "," + email + "," + phoneNum + "," + dateOfBirth);
        System.out.printf("The %s user added to system.\n", userName);
    }


    public List<SingIn> searchUser(String keyword, String searchOption) {
        List<SingIn> foundUsers = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filePathUser))) {

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");

                    String membershipNumber = parts[1];
                    String userName = parts[2];
                    String userPassword = parts[3];
                    String  name= parts[4];
                    String email = parts[5];
                    long phoneNum = Long.parseLong(parts[6]);
                    String birthOfDate = parts[7];

                    SingIn user = new SingIn(membershipNumber, name, userName, userPassword, email, phoneNum, birthOfDate);

                    users.put(membershipNumber, user);

                    if (searchOption.equalsIgnoreCase("membership") && user.getMembershipNumber().equalsIgnoreCase(keyword)) {
                        foundUsers.add(user);
                    } else if (searchOption.equalsIgnoreCase("name") && user.getName().equalsIgnoreCase(keyword)) {
                        foundUsers.add(user);
                    } else if (searchOption.equalsIgnoreCase("username") && user.getUserName().equalsIgnoreCase(keyword)) {
                        foundUsers.add(user);
                    }
                }
            } catch(IOException e){
                    System.out.println("Error occurred while loading users from file.");
                    return null;
                }
            return foundUsers;
        }


    public List<SingIn> searchUserInList(String keyword, String searchOption,List<SingIn> userList){
        List<SingIn> foundUsers = new ArrayList<>();
        for (SingIn user : userList) {
            if (searchOption.equalsIgnoreCase("membership") && user.getMembershipNumber().equals(keyword)) {
                foundUsers.add(user);
            }
        }return foundUsers;
    }


    public  void allUsers() {

        String filePath = "E:\\oop\\LibrarySystem\\src\\users.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String username = fields[2];
                String name = fields[4];
                String phoneNumber = fields[6];

                System.out.print("user name: " + username + "\t");
                System.out.print("name: " + name + "\t");
                System.out.println("phone number: " + phoneNumber);
                System.out.println("---------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /*For the case that the file is not found*/
    public void printTheListNow(Map<String, SingIn> allUsers) {
        for (Map.Entry<String, SingIn> entry : allUsers.entrySet()) {
            String key = entry.getKey();
            SingIn value = entry.getValue();
            System.out.println("membership number: " + key +'\t'+ value.toString());
            System.out.println("--------------------------------");
        }
    }
}