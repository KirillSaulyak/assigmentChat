package com.assigment.chat.service.room;

import com.assigment.chat.model.Room;
import com.assigment.chat.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Room createRoom(String name) {
      return roomRepository.save(Room.builder().name(name).build());
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
