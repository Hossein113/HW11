package maktab74.practice11.org.repository;

import maktab74.practice11.org.base.repository.BaseRepository;
import maktab74.practice11.org.domain.LikeTwitt;

public interface LikeTwittRepository extends BaseRepository<LikeTwitt, Long> {

    void likeOrDislike(LikeTwitt likeTwitt);

    LikeTwitt findByUserTwittLike(LikeTwitt likeTwitt);
}
