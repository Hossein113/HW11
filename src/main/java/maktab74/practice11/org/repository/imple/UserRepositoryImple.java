package maktab74.practice11.org.repository.imple;

import maktab74.practice11.org.base.repository.imple.BaseRepositoryImple;
import maktab74.practice11.org.domain.CommentTwitt;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.repository.UserRepository;
import maktab74.practice11.org.utill.UserBrif;

import javax.persistence.EntityManager;

public class UserRepositoryImple extends BaseRepositoryImple<User, Long> implements UserRepository {
    public UserRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> entityClass() {
        return User.class;
    }

    @Override
    public User loginByUserNameAndPassword(UserBrif userBrif) {
        return entityManager.createQuery("select u from User u where u.userName =:userName and " +
                        "u.password =:password", User.class).setParameter("userName", userBrif.getUserName())
                .setParameter("password", userBrif.getPassword()).getSingleResult();
    }

    @Override
    public void deletUser(User user) {
        entityManager.createQuery("delete from User u where u.firstName =: firstName and " +
                        "u.lastName =: lastName and u.userName =: userName")
                .setParameter("firstName", user.getFirstName())
                .setParameter("lastName", user.getLastName())
                .setParameter("userName", user.getUsertName())
                .executeUpdate();
    }

    @Override
    public CommentTwitt findCommentById(Long id) {
        return entityManager.find(CommentTwitt.class, id);
    }
}
