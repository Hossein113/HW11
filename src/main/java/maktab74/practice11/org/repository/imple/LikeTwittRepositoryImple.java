package maktab74.practice11.org.repository.imple;

import maktab74.practice11.org.base.repository.imple.BaseRepositoryImple;
import maktab74.practice11.org.domain.LikeTwitt;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.repository.LikeTwittRepository;

import javax.persistence.EntityManager;
import java.util.List;

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

    @Override
    public LikeTwitt findByTwittLike(Long id) {
        return entityManager.find(LikeTwitt.class, id);
    }

    @Override
    public void deleltByTwitt(Long id) {
        entityManager.createQuery("delete from LikeTwitt t where t.twitt.id =: id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public LikeTwitt findByUserAndTwitt(Twitt twit, User user) {
        return entityManager.createQuery("select l from LikeTwitt l where l.twitt.id =: twiitId and " +
                        "l.userLike.id =:userId", LikeTwitt.class)
                .setParameter("twiitId", twit.getId()).setParameter("userId", user.getId()).getSingleResult();
    }

    @Override
    public Long likeOreNoLikeTwitt(Twitt twit, User user) {
        return entityManager.createQuery("select count(id) from LikeTwitt l where l.twitt.id =: twiitId and " +
                        "l.userLike.id =:userId", Long.class)
                .setParameter("twiitId", twit.getId()).setParameter("userId", user.getId()).getSingleResult();

    }

    @Override
    public void deletbyUser(User user) {
        entityManager.createQuery("delete from LikeTwitt l where l.userLike.id =: id ")
                .setParameter("id", user.getId()).executeUpdate();
    }

    @Override
    public List<LikeTwitt> showLikeusernames(Twitt twitt) {
        return entityManager.createQuery("select l from LikeTwitt l where l.twitt =:twitt and l.likeTwitt=: likeTwitt"
                , LikeTwitt.class).setParameter("twitt", twitt).setParameter("likeTwitt", "yes").getResultList();
    }

    @Override
    public Long countLike(Twitt twitt) {
        return entityManager.createQuery("select count (l.id) from LikeTwitt l where l.twitt =:twitt and l.likeTwitt=: likeTwitt"
                , Long.class).setParameter("twitt", twitt).setParameter("likeTwitt", "yes").getSingleResult();
    }


}