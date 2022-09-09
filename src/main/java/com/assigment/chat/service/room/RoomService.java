package com.assigment.chat.service.room;

import com.assigment.chat.model.Room;

import java.util.List;

public interface RoomService{
    Room createRoom(String name);
    List<Room> getAllRooms();
}
