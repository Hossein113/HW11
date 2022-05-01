package maktab74.practice11.org.repository;

import maktab74.practice11.org.base.repository.BaseRepository;
import maktab74.practice11.org.domain.Twitt;

import java.util.List;

public interface TwittRepository extends BaseRepository<Twitt, Long> {

    List<Twitt> findByUser(Long id);

    List<Twitt> findAllTwitt();
}
