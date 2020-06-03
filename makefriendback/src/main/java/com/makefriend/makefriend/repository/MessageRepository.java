package com.makefriend.makefriend.repository;

import com.makefriend.makefriend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select m from Message m where m.receiver.id = :userId or m.sender.id = :userId")
    List<Message> findAllUserMessages(Long userId);

    @Query("select m from Message m where m.sender.username = :username and m.receiver.username = :friendUsername or m.sender.username = :friendUsername and m.receiver.username = :username order by m.time asc")
    List<Message> findChatMessages(String username, String friendUsername);

}
