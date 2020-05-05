package com.makefriend.makefriend.repository;

import com.makefriend.makefriend.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestRepository extends JpaRepository<FriendRequest,Long> {
}
