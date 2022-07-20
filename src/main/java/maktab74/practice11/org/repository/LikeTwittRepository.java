package maktab74.practice11.org.repository;

import maktab74.practice11.org.base.repository.BaseRepository;
import maktab74.practice11.org.domain.LikeTwitt;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;

import java.util.List;

public interface LikeTwittRepository extends BaseRepository<LikeTwitt, Long> {

    void likeOrDislike(LikeTwitt likeTwitt);

    LikeTwitt findByUserTwittLike(LikeTwitt likeTwitt);

    LikeTwitt findByTwittLike(Long id);


    void deleltByTwitt(Long aLong);


    LikeTwitt findByUserAndTwitt(Twitt twit, User user);

    Long likeOreNoLikeTwitt(Twitt twit, User user);

    void deletbyUser(User user);


    List<LikeTwitt> showLikeusernames(Twitt twitt);

    Long countLike(Twitt twitt);
}
