package com.assigment.chat.repository;

import com.assigment.chat.model.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findAllByRoomIdRoom(Long idRoom, Sort sort);
}
