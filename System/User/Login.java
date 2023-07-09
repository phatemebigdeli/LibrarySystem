package System.User;

import System.Tools.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Login {

    public  static LoginItem validate(String inputUsername, String inputPassword) throws FileNotFoundException {
        //            Check inputs with the File1 (users.txt)
        ArrayList<LoginItem> loginItems = getLoginInformation();
        for (LoginItem loginItem : loginItems) {
            if (inputUsername.equals(loginItem.getUserName())) {
                if (inputPassword.equals(loginItem.getUserPassword())) {
                    return loginItem;
                }
            }
        }
        return null;
    }


    private static ArrayList<LoginItem> getLoginInformation() throws FileNotFoundException {
        ArrayList<LoginItem> result=new ArrayList<>();
        ArrayList<String> fileLines = FileTools.fileLines("E:\\oop\\LibrarySystem\\src\\users.txt");
        for (String newLine : fileLines) {
            String[] split = newLine.split(",");
            result.add(new LoginItem(UserType.valueOf(split[0]), split[2], split[3]));
        }
        return result;
    }

}
