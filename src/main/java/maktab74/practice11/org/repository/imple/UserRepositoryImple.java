package maktab74.practice11.org.repository.imple;

import maktab74.practice11.org.base.repository.imple.BaseRepositoryImple;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.repository.UserRepository;

import javax.persistence.EntityManager;

public class UserRepositoryImple extends BaseRepositoryImple<User, Long> implements UserRepository {
    public UserRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> entityClass() {
        return User.class;
    }
}
