package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.model.assets.Band;
import me.joshmendiola.DropDee.repository.assets.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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
        return returnBand.orElse(null);
    }

    //gets band by name
    @GetMapping("/band/name/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Band getBandByName(@PathVariable String name)
    {
        return repository.findByName(name).get(0);
    }

    //POST MAPPINGS

    //adds a single band to the database
    @PostMapping("/band")
    @ResponseStatus(HttpStatus.CREATED)
    public Band addBand(@RequestBody Band band) {
        return repository.save(band);
    }

    //UPDATE MAPPINGS

    //updates by ID
    @PutMapping("/band/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBand(@RequestBody Band newBandData, @PathVariable int id)
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
    public void deleteBand(@PathVariable int id) {
        repository.deleteById(id);
    }

    //deletes all bands
    @DeleteMapping("/bands")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllBands() {
        repository.deleteAll();
    }
}
