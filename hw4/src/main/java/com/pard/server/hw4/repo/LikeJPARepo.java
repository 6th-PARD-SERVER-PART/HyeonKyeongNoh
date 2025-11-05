package com.pard.server.hw4.repo;

import com.pard.server.hw4.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeJPARepo extends JpaRepository<Like, Long> {
    public void deleteByUserIdAndTextId(Long userId, Long textId);

    @Query("SELECT COUNT(l) FROM Like l WHERE l.userId = :userId AND l.textId = :textId")
    public int findByLike(Long userId, Long textId);

    public void deleteAllByUserId(Long userId);

    public void deleteAllByTextId(Long textId);
}
