package maktab74.practice11.org.domain;

import maktab74.practice11.org.base.domain.BaseEntity;

public class User extends BaseEntity<Long> {

    private String firstName;
    private String lasttName;
    private String usertName;
    private Twitt twitt;

    public User(Long aLong, String firstName, String lasttName, String usertName, Twitt twitt) {
        super(aLong);
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.usertName = usertName;
        this.twitt = twitt;
    }

    public User(String firstName, String lasttName, String usertName, Twitt twitt) {
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.usertName = usertName;
        this.twitt = twitt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public String getUsertName() {
        return usertName;
    }

    public void setUsertName(String usertName) {
        this.usertName = usertName;
    }

    public Twitt getTwitt() {
        return twitt;
    }

    public void setTwitt(Twitt twitt) {
        this.twitt = twitt;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lasttName='" + lasttName + '\'' +
                ", usertName='" + usertName + '\'' +
                ", twitt=" + twitt +
                "} " + super.toString();
    }
}
