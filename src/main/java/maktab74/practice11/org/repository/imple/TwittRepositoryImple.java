package maktab74.practice11.org.repository.imple;

import maktab74.practice11.org.base.repository.imple.BaseRepositoryImple;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.repository.TwittRepository;

import javax.persistence.EntityManager;

public class TwittRepositoryImple extends BaseRepositoryImple<Twitt, Long> implements
        TwittRepository {
    public TwittRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Twitt> entityClass() {
        return Twitt.class;
    }
}
