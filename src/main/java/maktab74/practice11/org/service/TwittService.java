package maktab74.practice11.org.service;

import maktab74.practice11.org.base.service.BaseService;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;

import java.util.List;

public interface TwittService extends BaseService<Twitt, Long> {

    List<Twitt> findByUser(Long id);

    List<Twitt> findAllTwitt();

    Twitt findByTwitt(Long numberId);

    void delettwittByUser(User user);

}
