package maktab74.practice11.org.service.Imple;

import maktab74.practice11.org.base.service.imple.BaseServiceImple;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.repository.TwittRepository;
import maktab74.practice11.org.service.TwittService;

public class TwittServiceImple extends BaseServiceImple<Twitt, Long, TwittRepository>
        implements TwittService {
    public TwittServiceImple(TwittRepository repository) {
        super(repository);
    }
}