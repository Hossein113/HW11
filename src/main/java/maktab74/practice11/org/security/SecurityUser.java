package maktab74.practice11.org.security;

import maktab74.practice11.org.base.domain.BaseEntity;
import maktab74.practice11.org.domain.User;

public class SecurityUser extends BaseEntity<Long> {

    private User curentUser;

    public User getUser() {
        return curentUser;
    }

    public void setUser(User user) {
        this.curentUser = user;
    }

    public void logOut() {
        this.curentUser = null;
    }
}

