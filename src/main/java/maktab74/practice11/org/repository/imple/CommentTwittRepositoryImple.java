package maktab74.practice11.org.repository.imple;

import maktab74.practice11.org.base.repository.imple.BaseRepositoryImple;
import maktab74.practice11.org.domain.CommentTwitt;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.repository.CommentTwittRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class CommentTwittRepositoryImple extends BaseRepositoryImple<CommentTwitt, Long> implements CommentTwittRepository {

    public CommentTwittRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CommentTwitt> entityClass() {
        return CommentTwitt.class;
    }

    @Override
    public CommentTwitt findCommentById(Long id) {
        return entityManager.find(CommentTwitt.class, id);
    }

    @Override
    public List<CommentTwitt> findAllCommentForTwitt(Long id) {
        return entityManager.createQuery("select c from CommentTwitt c where c.twitt.id =: id"
                , CommentTwitt.class).setParameter("id", id).getResultList();
    }

    @Override
    public void remove(CommentTwitt commentTwitt) {
        entityManager.remove(commentTwitt);
    }

    @Override
    public void deletbyuserComment(Long id) {
        entityManager.createQuery("delete from CommentTwitt c where c.twitt.id =: id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public List<CommentTwitt> myComment(Twitt twittId, User userId) {
        return entityManager.createQuery("select c from CommentTwitt c where c.twitt.id =: twittId and " +
                        "c.userComment.id =: userId"
                , CommentTwitt.class).setParameter("twittId", twittId.getId()).setParameter("userId", userId.getId()).getResultList();
    }

    @Override
    public void deletByUser(User user) {
        entityManager.createQuery("delete from CommentTwitt c where c.userComment.id =: id")
                .setParameter("id", user.getId()).executeUpdate();
    }


}
