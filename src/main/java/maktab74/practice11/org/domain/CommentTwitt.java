package maktab74.practice11.org.domain;

import maktab74.practice11.org.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment_tbl")
public class CommentTwitt extends BaseEntity<Long> {

    private String commentTwitt;

    @ManyToOne
    private User userComment;

    public CommentTwitt() {
    }

    public CommentTwitt(Long aLong, String commentTwitt, User userComment) {
        super(aLong);
        this.commentTwitt = commentTwitt;
        this.userComment = userComment;
    }

    public CommentTwitt(String commentTwitt, User userComment) {
        this.commentTwitt = commentTwitt;
        this.userComment = userComment;
    }

    public String getCommentTwitt() {
        return commentTwitt;
    }

    public void setCommentTwitt(String commentTwitt) {
        this.commentTwitt = commentTwitt;
    }

    public User getUserComment() {
        return userComment;
    }

    public void setUserComment(User userComment) {
        this.userComment = userComment;
    }

    @Override
    public String toString() {
        return "CommentTwitt{" +
                "commentTwitt='" + commentTwitt + '\'' +
                ", userComment=" + userComment +
                "} " + super.toString();
    }
}
