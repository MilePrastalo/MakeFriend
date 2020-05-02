package com.makefriend.makefriend.repository;

import com.makefriend.makefriend.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    public Authority findByName(String name);
}
