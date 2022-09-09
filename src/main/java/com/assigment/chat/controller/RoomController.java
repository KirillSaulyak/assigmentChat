package com.assigment.chat.controller;

import com.assigment.chat.model.Room;
import com.assigment.chat.protocol.user.UserChatDto;
import com.assigment.chat.service.message.MessageService;
import com.assigment.chat.service.room.RoomService;
import com.assigment.chat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final UserService userService;
    private final MessageService messageService;

    @GetMapping("/{idRoom}")
    public String getRoomPage(@PathVariable("idRoom") Long idRoom, Model model) {
        model.addAttribute("idRoom", idRoom);
        model.addAttribute("messages",messageService.getAllMessageByIdRoom(idRoom));
        return "room";
    }

    @MessageMapping("/message/{idRoom}")
    public void saveMessage(@DestinationVariable Long idRoom, String message, Principal principal) {
        UserChatDto user = userService.getUserChatDtoByLogin(principal.getName());
        messageService.saveMessage(message, idRoom, principal.getName());
        user.setMessage(message);
        simpMessagingTemplate.convertAndSend("/room/" + idRoom.toString(), user);
    }

    @MessageMapping("/create-room")
    public void createRoom(String nameRoom) {
        simpMessagingTemplate.convertAndSend("/show-rooms",roomService.createRoom(nameRoom));
    }
}
