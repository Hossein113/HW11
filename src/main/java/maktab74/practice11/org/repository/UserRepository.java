package maktab74.practice11.org.repository;

import maktab74.practice11.org.base.repository.BaseRepository;
import maktab74.practice11.org.domain.User;
import maktab74.practice11.org.utill.UserBrif;

public interface UserRepository extends BaseRepository<User, Long> {

    User loginByUserNameAndPassword(UserBrif userBrif);

    void deletUser(User user);
}
