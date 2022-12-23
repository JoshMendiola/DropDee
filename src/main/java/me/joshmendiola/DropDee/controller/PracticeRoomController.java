package me.joshmendiola.DropDee.controller;

import me.joshmendiola.DropDee.model.PracticeRoom;
import me.joshmendiola.DropDee.repository.PracticeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PracticeRoomController
{
    @Autowired
    PracticeRoomRepository repository;

    @GetMapping("/practicerooms")
    public List<PracticeRoom> getPracticeRooms()
    {
        return repository.findAll();
    }
}
