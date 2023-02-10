package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.model.assets.Band;
import me.joshmendiola.DropDee.repository.assets.BandRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class BandController
{
    @Autowired
    BandRepository repository;

    //GET MAPPINGS

    //gets all bands
    @GetMapping("/bands")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Band> getAllBands()
    {
        return repository.findAll();
    }

    //gets band by singular ID
    @GetMapping("/band/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Band getBandById(@PathVariable int id)
    {
        Optional<Band> returnBand = repository.findById(id);
        if(returnBand.isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        return returnBand.orElse(null);
    }

    //gets band by name
    @GetMapping("/band/name/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Band> getBandByName(@PathVariable String name)
    {
        if(repository.findByName(name).isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that name found !");
        }
        return repository.findByName(name);
    }

    //POST MAPPINGS

    //adds a single band to the database
    @PostMapping("/band")
    @ResponseStatus(HttpStatus.CREATED)
    public Band addBand(@RequestBody Band band)
    {
        if(repository.existsById(band.getBandID()))
        {
            throw new IllegalArgumentException("ERROR: An entity with that ID already exists in the database");
        }
        return repository.save(band);
    }
    //UPDATE MAPPINGS

    //updates by ID
    @PutMapping("/band/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBand(@RequestBody @NotNull Band newBandData, @PathVariable int id)
    {
        Band oldBandData = getBandById(id);
        oldBandData.setBalance(newBandData.getBalance());
        oldBandData.setGenre(newBandData.getGenre());
        oldBandData.setName(newBandData.getName());
        repository.save(oldBandData);
    }

    //DELETE MAPPINGS

    //deletes by ID
    @DeleteMapping("/band/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBand(@PathVariable int id)
    {
        if(repository.findById(id).isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        repository.deleteById(id);
    }

    //deletes all bands
    @DeleteMapping("/bands")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllBands() {
        repository.deleteAll();
    }
}
