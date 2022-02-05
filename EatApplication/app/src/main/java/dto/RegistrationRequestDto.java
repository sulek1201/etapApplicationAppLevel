package dto;

public class RegistrationRequestDto {

    private String nameSurname;
    private String username;
    private String password;
    private String email;
    private String userType;

    public RegistrationRequestDto(String nameSurname, String userName, String password, String email, String userType) {
        this.nameSurname = nameSurname;
        this.username = userName;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
