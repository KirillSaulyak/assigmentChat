package com.assigment.chat.protocol.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserChatDto {
    private Long idUser;
    private String name;
    private String message;
}
