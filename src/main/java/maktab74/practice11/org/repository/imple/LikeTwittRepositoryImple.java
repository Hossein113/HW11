package maktab74.practice11.org.repository.imple;

import maktab74.practice11.org.base.repository.imple.BaseRepositoryImple;
import maktab74.practice11.org.domain.LikeTwitt;

import javax.persistence.EntityManager;

public class LikeTwittRepositoryImple extends BaseRepositoryImple<LikeTwitt, Long> {
    public LikeTwittRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<LikeTwitt> entityClass() {
        return LikeTwitt.class;
    }
}
