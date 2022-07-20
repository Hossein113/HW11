package maktab74.practice11.org.service;

import maktab74.practice11.org.base.service.BaseService;
import maktab74.practice11.org.domain.LikeTwitt;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;

import java.util.List;

public interface LikeTwittService extends BaseService<LikeTwitt, Long> {

    LikeTwitt findByUserAndTwitt(Twitt twit, User user);

    void deletbyUser(User user);

    List<LikeTwitt> showLikeusernames(Twitt twitt);

    Long countLike(Twitt twitt);
}
