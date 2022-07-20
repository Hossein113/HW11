package maktab74.practice11.org.service;

import maktab74.practice11.org.base.service.BaseService;
import maktab74.practice11.org.domain.CommentTwitt;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;

import java.util.List;

public interface CommentTwittService extends BaseService<CommentTwitt, Long> {

    List<CommentTwitt> findAllCommentForTwitt(Long id);

    CommentTwitt findCommentById(Long id);

    void deletByUser(User user);

    List<CommentTwitt> myComment(Twitt t, User id);
}
