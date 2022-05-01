package maktab74.practice11.org.service;

import maktab74.practice11.org.base.service.BaseService;
import maktab74.practice11.org.domain.Twitt;

import java.util.List;

public interface TwittService extends BaseService<Twitt, Long> {

    List<Twitt> findByUser(Long id);

    List<Twitt> findAllTwitt();
}
