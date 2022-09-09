package com.assigment.chat.controller;

import com.assigment.chat.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainPage {
    private final RoomService roomService;

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "mainPage";
    }
}
