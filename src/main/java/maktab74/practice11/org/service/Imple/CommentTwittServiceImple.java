package maktab74.practice11.org.service.Imple;

import maktab74.practice11.org.base.service.imple.BaseServiceImple;
import maktab74.practice11.org.domain.CommentTwitt;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.repository.CommentTwittRepository;
import maktab74.practice11.org.service.CommentTwittService;

import java.util.List;

public class CommentTwittServiceImple extends BaseServiceImple<CommentTwitt, Long, CommentTwittRepository>
        implements CommentTwittService {


    public CommentTwittServiceImple(CommentTwittRepository repository) {
        super(repository);
    }


    @Override
    public List<CommentTwitt> findAllCommentForTwitt(Long id) {
        return repository.findAllCommentForTwitt(id);
    }

    @Override
    public CommentTwitt findCommentById(Long id) {
        return repository.findCommentById(id);
    }

    @Override
    public void deletByUser(User user) {
        repository.deletByUser(user);
    }

    @Override
    public List<CommentTwitt> myComment(Twitt t, User id) {
        return repository.myComment(t, id);
    }
}

