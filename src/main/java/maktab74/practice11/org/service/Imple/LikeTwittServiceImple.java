package maktab74.practice11.org.service.Imple;

import maktab74.practice11.org.base.service.imple.BaseServiceImple;
import maktab74.practice11.org.domain.LikeTwitt;
import maktab74.practice11.org.repository.LikeTwittRepository;

public class LikeTwittServiceImple extends BaseServiceImple<LikeTwitt, Long, LikeTwittRepository> {

    public LikeTwittServiceImple(LikeTwittRepository repository) {
        super(repository);
    }
}
