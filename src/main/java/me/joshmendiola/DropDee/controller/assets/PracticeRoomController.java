package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.model.assets.PracticeRoom;
import me.joshmendiola.DropDee.repository.assets.PracticeRoomRepository;
import org.jetbrains.annotations.NotNull;
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
        if(returnPracticeRoom.isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        return returnPracticeRoom.orElse(null);
    }

    //POST MAPPINGS

    //adds a single practice room to the database
    @PostMapping("/practiceroom")
    @ResponseStatus(HttpStatus.CREATED)
    public PracticeRoom addPracticeRoom(@RequestBody PracticeRoom practiceRoom)
    {
        if(repository.existsById(practiceRoom.getRoomID()))
        {
            throw new IllegalArgumentException("ERROR: An entity with that ID already exists in the database");
        }
        return repository.save(practiceRoom);
    }

    //UPDATE MAPPINGS

    //updates by ID
    @PutMapping("/practiceroom/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePracticeRoom(@RequestBody @NotNull PracticeRoom newPracticeRoomData, @PathVariable int id)
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
    public void deletePracticeRoom(@PathVariable int id)
    {
        if(repository.findById(id).isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        repository.deleteById(id);
    }

    //deletes all practice rooms
    @DeleteMapping("/practicerooms")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllPracticeRooms() {
        repository.deleteAll();
    }
}
