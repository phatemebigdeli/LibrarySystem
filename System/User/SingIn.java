package System.User;

public class SingIn {
    private String membershipNumber;
    private String name;
    private String userName = null;
    private String userPassword = null;
    private String email = null;
    private long phoneNum ;
    private String dateOfBirth;



    public SingIn(String membershipNumber,String userName, String userPassword,String name,String email, long phoneNum, String dateOfBirth ) {

        this.membershipNumber = membershipNumber;
        this.userName = userName;
        this.userPassword = userPassword;
        this.name=name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.dateOfBirth = dateOfBirth;


    }

    public String getName(){return name;}
    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }


    @Override
    public String toString() {
        return
                 membershipNumber+" " + name +" "+ userName+" " + userPassword+" " + email+" " + phoneNum+" " + dateOfBirth;
    }

}
