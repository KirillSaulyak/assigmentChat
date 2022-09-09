package com.assigment.chat.service.message;

import com.assigment.chat.protocol.message.MessageChatDto;

import java.util.List;

public interface MessageService {
    void saveMessage(String message, Long idRoom, String login);
    List<MessageChatDto> getAllMessageByIdRoom(Long idRoom);
}
