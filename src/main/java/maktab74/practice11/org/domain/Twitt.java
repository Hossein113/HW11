package maktab74.practice11.org.domain;

import maktab74.practice11.org.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "twitt_tbl")
public class Twitt extends BaseEntity<Long> {

    private String WriteTwitt;

    @ManyToOne
    private User user;

    public Twitt() {
    }

    public Twitt(Long aLong, String writeTwitt, User user) {
        super(aLong);
        WriteTwitt = writeTwitt;
        this.user = user;
    }

    public Twitt(String writeTwitt, User user) {
        WriteTwitt = writeTwitt;
        this.user = user;
    }

    public String getWriteTwitt() {
        return WriteTwitt;
    }

    public void setWriteTwitt(String writeTwitt) {
        WriteTwitt = writeTwitt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Twitt{" +


                "Twitt ID =" + super.getId() + '\'' + " , " +
                "Writed By =" + user.getUsertName() + " , " +
                "WriteTwitt = " + WriteTwitt;
    }
}
