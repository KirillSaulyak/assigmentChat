package com.assigment.chat.protocol.message;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageChatDto {
    private String message;
    private String username;
}
