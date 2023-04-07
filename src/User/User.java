package User;
//users of the banking application
import java.text.SimpleDateFormat;
import java.util.Date;
public class User {
    private String nameTag;
    private String firstName, lastName;
    private String password;
    private Date birthDate;
    private String email, phone;
    private String address;

    public User(String nameTag,String firstName, String lastName, String password, Date birthDate, String email, String phone, String address) {
        this.nameTag = nameTag;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }


//    getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getNameTag() {
        return nameTag;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

//    setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return "Name: " + firstName + " " + lastName + " (" + nameTag + ")" + " Password: " + password + " Birthdate: " + sdf.format(birthDate) + " Email: " + email + " Phone: " + phone + " Address: " + address;
    }



}
