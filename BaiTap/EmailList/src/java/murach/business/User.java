package murach.business;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName, lastName, email, gender, edu;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        gender = "";
        edu = "";
    }

    public User(String firstName, String lastName, String email, String gender, String edu) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.edu = edu;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getEdu() {
        return edu;
    }
}
