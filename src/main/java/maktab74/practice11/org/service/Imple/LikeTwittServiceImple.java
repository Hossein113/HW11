package maktab74.practice11.org.service.Imple;

import maktab74.practice11.org.base.service.imple.BaseServiceImple;
import maktab74.practice11.org.domain.LikeTwitt;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.repository.LikeTwittRepository;
import maktab74.practice11.org.service.LikeTwittService;

import java.util.List;

public class LikeTwittServiceImple extends BaseServiceImple<LikeTwitt, Long, LikeTwittRepository> implements
        LikeTwittService {

    public LikeTwittServiceImple(LikeTwittRepository repository) {
        super(repository);
    }


    @Override
    public LikeTwitt findByUserAndTwitt(Twitt twit, User user) {
        return repository.findByUserAndTwitt(twit, user);
    }

    @Override
    public void deletbyUser(User user) {
        repository.deletbyUser(user);
    }

    @Override
    public List<LikeTwitt> showLikeusernames(Twitt twitt) {
        return repository.showLikeusernames(twitt);

    }

    @Override
    public Long countLike(Twitt twitt) {
        return repository.countLike(twitt);
    }
}
