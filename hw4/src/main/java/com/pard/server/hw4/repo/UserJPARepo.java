package com.pard.server.hw4.repo;

import com.pard.server.hw4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJPARepo extends JpaRepository<User, Long> {

    public Optional<User> findById(Long userId);

    public void deleteById(Long userId);
}
