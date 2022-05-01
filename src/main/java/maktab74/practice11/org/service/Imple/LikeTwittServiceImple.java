package maktab74.practice11.org.service.Imple;

import maktab74.practice11.org.base.service.imple.BaseServiceImple;
import maktab74.practice11.org.domain.LikeTwitt;
import maktab74.practice11.org.repository.LikeTwittRepository;
import maktab74.practice11.org.service.LikeTwittService;

public class LikeTwittServiceImple extends BaseServiceImple<LikeTwitt, Long, LikeTwittRepository> implements
        LikeTwittService {

    public LikeTwittServiceImple(LikeTwittRepository repository) {
        super(repository);
    }

    @Override
    public void likeOrDislike(LikeTwitt likeTwitt) {
        repository.likeOrDislike(likeTwitt);
    }
}
