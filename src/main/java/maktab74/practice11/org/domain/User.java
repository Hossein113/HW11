package maktab74.practice11.org.domain;

import maktab74.practice11.org.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class User extends BaseEntity<Long> {


    private String firstName;

    private String lastName;

    private String userName;

    private String password;


    public User() {
    }

    public User(Long aLong, String firstName, String lastName, String userName, String password) {
        super(aLong);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;

    }

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
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

    public String getUsertName() {
        return userName;
    }

    public void setUsertName(String usertName) {
        this.userName = usertName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", usertName='" + userName + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}
