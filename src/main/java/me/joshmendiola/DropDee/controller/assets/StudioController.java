package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.model.assets.Studio;
import me.joshmendiola.DropDee.repository.assets.StudioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudioController
{
    @Autowired
    StudioRepository repository;

    @GetMapping("/studios")
    public List<Studio> getStudios()
    {
        return repository.findAll();
    }

    @GetMapping("/studio/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Studio getStudioById(@PathVariable int id)
    {
        Optional<Studio> returnStudio = repository.findById(id);
        if(returnStudio.isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        return returnStudio.orElse(null);
    }

    //POST MAPPINGS

    //adds a single practice room to the database
    @PostMapping("/studio")
    @ResponseStatus(HttpStatus.CREATED)
    public Studio addStudio(@RequestBody Studio studio) {
        return repository.save(studio);
    }

    //UPDATE MAPPINGS

    //updates by ID
    @PutMapping("/studio/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudio(@RequestBody @NotNull Studio newStudioData, @PathVariable int id)
    {
        Studio oldStudioData = getStudioById(id);
        oldStudioData.setStudioType(newStudioData.getStudioType());
        repository.save(oldStudioData);
    }

    //DELETE MAPPINGS

    //deletes by ID
    @DeleteMapping("/studio/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudio(@PathVariable int id)
    {
        if(repository.findById(id).isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }repository.deleteById(id);
    }

    //deletes all studios
    @DeleteMapping("/studios")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllStudios() {
        repository.deleteAll();
    }
}
