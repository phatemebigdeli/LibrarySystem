package System.Tools;

import System.Operation.MyException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean validateEmail(String email) throws MyException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        boolean check= matcher.matches();
        if (check==false){
            throw new MyException("Email not valid...");
        }
        return check;
    }


    public static boolean validatePhonNamber(String phoneNumber) throws MyException {
        String phoneNumberRegex = "^9\\d{9}$";
        Pattern pattern = Pattern.compile(phoneNumberRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean check = matcher.matches();
        if (check==false){
            throw new MyException("PhoneNumber not valid...");
        }
        return check;

    }


    public static boolean validateBirth(String birthOfDay) throws MyException {
        String dateOfBirth="^\\d{4}/\\d{2}/\\d{2}$";
        Pattern pattern = Pattern.compile(dateOfBirth);
        Matcher matcher = pattern.matcher(birthOfDay);
        boolean check = matcher.matches();
        if (check==false){
            throw new MyException("Bith of day not valid...");
        }
        return check;

    }


    public static boolean validateMemberShip(String membership) throws MyException {
        String membershipRegex= "^\\d{10}$";
        Pattern pattern = Pattern.compile(membershipRegex);
        Matcher matcher = pattern.matcher(membership);
        boolean check = matcher.matches();
        if (check==false){
            throw new MyException("membership not valid...");
        }
        return check;
    }


    public static boolean validateUsername(String username)throws MyException{
        String usernameRegex = "^[a-zA-Z]{4,16}$";
        Pattern pattern = Pattern.compile(usernameRegex);
        Matcher matcher = pattern.matcher(username);
        boolean check = matcher.matches();
        if (check==false){
            throw new MyException("username not valid...");
        }
        return check;


    }


    public static boolean validateISBN(String ISBN) throws MyException {
        String ISBNRegex= "^\\d{13}$";
        Pattern pattern = Pattern.compile(ISBNRegex);
        Matcher matcher = pattern.matcher(ISBN);
        boolean check = matcher.matches();
        if (check==false){
            throw new MyException("ISBN not valid...");
        }
        return check;
    }

    }


