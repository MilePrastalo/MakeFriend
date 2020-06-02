package com.makefriend.makefriend.repository;

import com.makefriend.makefriend.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {

    Interest findByName(String name);
}
