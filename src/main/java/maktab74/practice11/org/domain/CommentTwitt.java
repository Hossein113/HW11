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
    @ManyToOne
    private Twitt twitt;

    public CommentTwitt(Long aLong, String commentTwitt, User userComment, Twitt twitt) {
        super(aLong);
        this.commentTwitt = commentTwitt;
        this.userComment = userComment;
        this.twitt = twitt;
    }

    public CommentTwitt(String commentTwitt, User userComment, Twitt twitt) {
        this.commentTwitt = commentTwitt;
        this.userComment = userComment;
        this.twitt = twitt;
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

    public CommentTwitt() {

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
                "ID comment ='" + super.getId() + '\'' +
                        "ID comment ='" + userComment.getUsertName() + '\'' +
                        "comment='" + commentTwitt + '\'';
    }
}
