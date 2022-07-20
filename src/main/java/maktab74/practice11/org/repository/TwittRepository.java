package maktab74.practice11.org.repository;

import maktab74.practice11.org.base.repository.BaseRepository;
import maktab74.practice11.org.domain.Twitt;
import maktab74.practice11.org.domain.User;

import java.util.List;

public interface TwittRepository extends BaseRepository<Twitt, Long> {

    List<Twitt> findByUser(Long id);

    List<Twitt> findAllTwitt();

    Twitt findByTwitt(Long id);

    Twitt findByIdEm(Long id);

    void removeTwitt(Twitt twitt);

    void delettwittByUser(User user);

}
