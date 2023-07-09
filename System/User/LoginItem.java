package System.User;

public class LoginItem {
    private UserType userType = null;
    private String userName = null;
    private String userPassword = null;


    public LoginItem(UserType userType, String userName, String userPassword) {
        this.userType = userType;
        this.userName = userName;
        this.userPassword = userPassword;
    }


    public UserType getUserType() {
        return userType;
    }


    public String getUserName() {
        return userName;
    }


    public String getUserPassword() {
        return userPassword;
    }
}
