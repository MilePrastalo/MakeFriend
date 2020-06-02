package com.makefriend.makefriend.repository;

import com.makefriend.makefriend.model.Trait;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitRepository extends JpaRepository<Trait, Long> {
    public Trait findByName(String name);
}
