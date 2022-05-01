package maktab74.practice11.org.service.Imple;

import maktab74.practice11.org.base.service.imple.BaseServiceImple;
import maktab74.practice11.org.domain.CommentTwitt;
import maktab74.practice11.org.repository.CommentTwittRepository;

public class CommentTwittServiceImple extends BaseServiceImple<CommentTwitt, Long, CommentTwittRepository> {


    public CommentTwittServiceImple(CommentTwittRepository repository) {
        super(repository);
    }
}
