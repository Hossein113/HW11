package maktab74.practice11.org.domain;

import maktab74.practice11.org.base.domain.BaseEntity;

public class Twitt extends BaseEntity<Long> {

    private String comment;

    private boolean like = false;

    public Twitt(String comment, boolean like) {
        this.comment = comment;
        this.like = like;
    }

    public Twitt(Long aLong, String comment, boolean like) {
        super(aLong);
        this.comment = comment;
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Twitt{" +
                "comment='" + comment + '\'' +
                ", like=" + like +
                "} " + super.toString();
    }
}
