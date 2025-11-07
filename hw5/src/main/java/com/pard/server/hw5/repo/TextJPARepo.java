package com.pard.server.hw5.repo;

import com.pard.server.hw5.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TextJPARepo extends JpaRepository<Text, Long> {

    @Query("SELECT t FROM Text t WHERE t.userId = :userId")
    List<Text> findAllByUserIdWithUser(Long userId);

    public Optional<Text> findByTextId(Long textId);

    public void deleteById(Long textId);
}