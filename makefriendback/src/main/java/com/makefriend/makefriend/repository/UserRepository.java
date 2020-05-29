package com.makefriend.makefriend.repository;

import com.makefriend.makefriend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("SELECT u.friends from User u where u.id = :id")
    List<User> findFriendsById(Long id);

}
