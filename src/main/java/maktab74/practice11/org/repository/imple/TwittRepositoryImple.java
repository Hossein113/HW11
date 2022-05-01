package maktab74.practice11.org.repository.imple;

import maktab74.practice11.org.base.repository.imple.BaseRepositoryImple;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.repository.TwittRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class TwittRepositoryImple extends BaseRepositoryImple<Twitt, Long> implements
        TwittRepository {
    public TwittRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Twitt> entityClass() {
        return Twitt.class;
    }

    @Override
    public List<Twitt> findByUser(Long id) {
        return entityManager.createQuery("select t from Twitt t where  t.user.id =: id", Twitt.class)
                .setParameter("id", id).getResultList();
    }

    @Override
    public List<Twitt> findAllTwitt() {
        return entityManager.createQuery("select t from Twitt t ", Twitt.class).getResultList();
    }
}
