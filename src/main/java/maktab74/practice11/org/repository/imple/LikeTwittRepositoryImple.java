package maktab74.practice11.org.repository.imple;

import maktab74.practice11.org.base.repository.imple.BaseRepositoryImple;
import maktab74.practice11.org.domain.LikeTwitt;
import maktab74.practice11.org.repository.LikeTwittRepository;

import javax.persistence.EntityManager;

public class LikeTwittRepositoryImple extends BaseRepositoryImple<LikeTwitt, Long> implements
        LikeTwittRepository {
    public LikeTwittRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<LikeTwitt> entityClass() {
        return LikeTwitt.class;
    }

    @Override
    public void likeOrDislike(LikeTwitt likeTwitt) {
        entityManager.createQuery("update LikeTwitt l set l.likeTwitt=:myLike where l.id =: id ")
                .setParameter("myLike", likeTwitt.getLikeTwitt()).setParameter("id", likeTwitt.getUserLike()).executeUpdate();
    }

    @Override
    public LikeTwitt findByUserTwittLike(LikeTwitt likeTwitt) {
        return entityManager.createQuery("select l from LikeTwitt l where l.userLike =: userLike" +
                        " and l.twitt =: twitt", LikeTwitt.class)
                .setParameter("userLike", likeTwitt.getUserLike())
                .setParameter("twitt", likeTwitt.getTwitt()).getSingleResult();
    }
}
