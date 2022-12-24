package me.joshmendiola.DropDee.controller;

import me.joshmendiola.DropDee.model.assets.PracticeRoom;
import me.joshmendiola.DropDee.repository.PracticeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/practiceroom/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PracticeRoom getPracticeRoomById(@PathVariable int id)
    {
        Optional<PracticeRoom> returnPracticeRoom = repository.findById(id);
        return returnPracticeRoom.orElse(null);
    }

    //POST MAPPINGS

    //adds a single practice room to the database
    @PostMapping("/practiceroom")
    @ResponseStatus(HttpStatus.CREATED)
    public PracticeRoom addPracticeRoom(@RequestBody PracticeRoom practiceRoom) {
        return repository.save(practiceRoom);
    }

    //UPDATE MAPPINGS

    //updates by ID
    @PutMapping("/practiceroom/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePracticeRoom(@RequestBody PracticeRoom newPracticeRoomData, @PathVariable int id)
    {
        PracticeRoom oldPracticeRoomData = getPracticeRoomById(id);
        oldPracticeRoomData.setRoomSize(newPracticeRoomData.getRoomSize());
        oldPracticeRoomData.setHasMicrophones(newPracticeRoomData.getHasMicrophones());
        oldPracticeRoomData.setHasMixingBoard(newPracticeRoomData.getHasMixingBoard());
        repository.save(oldPracticeRoomData);
    }

    //DELETE MAPPINGS

    //deletes by ID
    @DeleteMapping("/practiceroom/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePracticeRoom(@PathVariable int id) {
        repository.deleteById(id);
    }

    //deletes all practice rooms
    @DeleteMapping("/practicerooms")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllPracticeRooms() {
        repository.deleteAll();
    }
}
