package maktab74.practice11.org.domain;

import maktab74.practice11.org.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "like_tbl")
public class LikeTwitt extends BaseEntity<Long> {

    private Boolean likeTwitt;

    @OneToOne
    private User userLike;

    public LikeTwitt() {
    }

    public LikeTwitt(Long aLong, Boolean likeTwitt, User userLike) {
        super(aLong);
        this.likeTwitt = likeTwitt;
        this.userLike = userLike;
    }

    public LikeTwitt(Boolean likeTwitt, User userLike) {
        this.likeTwitt = likeTwitt;
        this.userLike = userLike;
    }

    public Boolean getLikeTwitt() {
        return likeTwitt;
    }

    public void setLikeTwitt(Boolean likeTwitt) {
        this.likeTwitt = likeTwitt;
    }

    public User getUserLike() {
        return userLike;
    }

    public void setUserLike(User userLike) {
        this.userLike = userLike;
    }

    @Override
    public String toString() {
        return "LikeTwitt{" +
                "likeTwitt=" + likeTwitt +
                ", userLike=" + userLike +
                "} " + super.toString();
    }
}
