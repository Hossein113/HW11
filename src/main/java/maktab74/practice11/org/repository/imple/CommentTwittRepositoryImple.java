package maktab74.practice11.org.repository.imple;

import maktab74.practice11.org.base.repository.imple.BaseRepositoryImple;
import maktab74.practice11.org.domain.CommentTwitt;

import javax.persistence.EntityManager;

public class CommentTwittRepositoryImple extends BaseRepositoryImple<CommentTwitt, Long> {

    public CommentTwittRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CommentTwitt> entityClass() {
        return CommentTwitt.class;
    }
}
