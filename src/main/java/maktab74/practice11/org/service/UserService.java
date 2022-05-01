package maktab74.practice11.org.service;

import maktab74.practice11.org.base.service.BaseService;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.utill.UserBrif;

public interface UserService extends BaseService<User, Long> {
    User loginByUserNameAndPassword(UserBrif userBrif);

    void deletUser(User user);
}
