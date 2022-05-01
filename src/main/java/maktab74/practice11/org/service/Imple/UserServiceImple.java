package maktab74.practice11.org.service.Imple;

import maktab74.practice11.org.base.service.imple.BaseServiceImple;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.repository.UserRepository;
import maktab74.practice11.org.service.UserService;

public class UserServiceImple extends BaseServiceImple<User, Long, UserRepository> implements UserService {

    public UserServiceImple(UserRepository repository) {
        super(repository);
    }
}
