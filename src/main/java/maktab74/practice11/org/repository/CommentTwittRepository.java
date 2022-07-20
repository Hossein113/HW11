package maktab74.practice11.org.repository;

import maktab74.practice11.org.base.repository.BaseRepository;
import maktab74.practice11.org.domain.CommentTwitt;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;

import java.util.List;

public interface CommentTwittRepository extends BaseRepository<CommentTwitt, Long> {
    CommentTwitt findCommentById(Long id);

    List<CommentTwitt> findAllCommentForTwitt(Long id);

    void remove(CommentTwitt commentTwitt);

    void deletbyuserComment(Long userId);

    List<CommentTwitt> myComment(Twitt t, User id);

    void deletByUser(User user);
}
