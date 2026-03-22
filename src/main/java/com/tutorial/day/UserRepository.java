package com.tutorial.day;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {

    // Spring generates this query automatically!
    Optional<User> findByUsername(String username);
}