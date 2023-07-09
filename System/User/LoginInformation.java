package System.User;

public class LoginInformation {
    private String inputUsername;
    private String inputPassword;

    public LoginInformation(String inputUsername, String inputPassword) {
        this.inputUsername = inputUsername;
        this.inputPassword = inputPassword;
    }

    public String getInputUsername() {
        return inputUsername;
    }

    public String getInputPassword() {
        return inputPassword;
    }
}
