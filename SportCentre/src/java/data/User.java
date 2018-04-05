package data;


public class User {

    protected int id;
    protected String nameSurname;
    protected String username;
    protected String password;
    protected String confirmpass;
    protected String phoneNumber;
    protected String Email;

    public User(){
        System.out.println("obje oluşturuldu");
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

}
