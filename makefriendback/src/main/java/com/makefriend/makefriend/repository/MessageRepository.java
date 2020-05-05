package com.makefriend.makefriend.repository;

import com.makefriend.makefriend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select m from Message m where m.receiver.id = :userId or m.sender.id = :userId")
    List<Message> findAllUserMessages(Long userId);

    @Query("select m from Message m where m.sender.id = :userId and m.receiver.id = :friendId or m.sender.id = :friendId and m.receiver.id = :userId order by m.time asc")
    List<Message> findChatMessages(Long userId, Long friendId);

}
