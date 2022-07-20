package maktab74.practice11.org.domain;

import maktab74.practice11.org.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "like_tbl")
public class LikeTwitt extends BaseEntity<Long> {

    @JoinColumn(name = "like_twitt")
    private String likeTwitt;

    @OneToOne
    private User userLike;

    @ManyToOne
    private Twitt twitt;

    public LikeTwitt() {
    }

    public LikeTwitt(Long aLong, String likeTwitt, User userLike, Twitt twitt) {
        super(aLong);
        this.likeTwitt = likeTwitt;
        this.userLike = userLike;
        this.twitt = twitt;
    }

    public LikeTwitt(String likeTwitt, User userLike, Twitt twitt) {
        this.likeTwitt = likeTwitt;
        this.userLike = userLike;
        this.twitt = twitt;
    }

    public String getLikeTwitt() {
        return likeTwitt;
    }

    public void setLikeTwitt(String likeTwitt) {
        this.likeTwitt = likeTwitt;
    }

    public User getUserLike() {
        return userLike;
    }

    public void setUserLike(User userLike) {
        this.userLike = userLike;
    }

    public Twitt getTwitt() {
        return twitt;
    }

    public void setTwitt(Twitt twitt) {
        this.twitt = twitt;
    }

    @Override
    public String toString() {
        return

                "like =" + likeTwitt + '\'' +
                        ", userLike=" + userLike.getUsertName() + '\'';
    }
}
