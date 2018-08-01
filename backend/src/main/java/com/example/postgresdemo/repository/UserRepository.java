package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findOneByUserid(Long id);

    User findByUserid(Long id);

    List<User> findByUseridIn(List<Long> ids);
}
