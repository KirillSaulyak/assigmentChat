package com.assigment.chat.service.message;

import com.assigment.chat.model.Message;
import com.assigment.chat.model.Room;
import com.assigment.chat.model.User;
import com.assigment.chat.protocol.message.MessageChatDto;
import com.assigment.chat.protocol.message.MessageChatDtoMapper;
import com.assigment.chat.repository.MessageRepository;
import com.assigment.chat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final MessageChatDtoMapper messageChatDtoMapper;
    private final UserService userService;

    @Override
    public void saveMessage(String message, Long idRoom, String login) {
        messageRepository.save(Message.builder()
                .message(message)
                .sentDateTime(LocalDateTime.now())
                .room(Room.builder()
                        .idRoom(idRoom)
                        .build())
                .user(User.builder()
                        .idUser(userService.getUserByLogin(login).getIdUser())
                        .build())
                .build()
        );
    }

    @Override
    public List<MessageChatDto> getAllMessageByIdRoom(Long idRoom) {
        return messageRepository.findAllByRoomIdRoom(idRoom, Sort.by(Sort.Direction.ASC,"sentDateTime")).stream().map(messageChatDtoMapper::entityToDto).collect(Collectors.toList());
    }
}
