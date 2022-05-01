package maktab74.practice11.org.service.Imple;

import maktab74.practice11.org.base.service.imple.BaseServiceImple;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.repository.UserRepository;
import maktab74.practice11.org.service.UserService;
import maktab74.practice11.org.utill.UserBrif;

public class UserServiceImple extends BaseServiceImple<User, Long, UserRepository> implements UserService {

    public UserServiceImple(UserRepository repository) {
        super(repository);
    }

    @Override
    public User loginByUserNameAndPassword(UserBrif userBrif) {
        return repository.loginByUserNameAndPassword(userBrif);
    }

    @Override
    public void deletUser(User user) {
        repository.deletUser(user);
    }
}
