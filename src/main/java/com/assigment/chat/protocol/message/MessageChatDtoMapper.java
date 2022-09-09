package com.assigment.chat.protocol.message;

import com.assigment.chat.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageChatDtoMapper {
    public MessageChatDto entityToDto(Message message){
        return MessageChatDto.builder()
                .message(message.getMessage())
                .username(message.getUser().getName())
                .build();
    }
}
