package me.joshmendiola.DropDee.controller;

import me.joshmendiola.DropDee.model.Band;
import me.joshmendiola.DropDee.repository.BandRepository;
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

    @GetMapping("/bands")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Band> getBands()
    {
        return repository.findAll();
    }

    @GetMapping("/band/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Band getBandById(@PathVariable int id)
    {
        Optional<Band> returnBand = repository.findById(id);
        return returnBand.orElse(null);
    }

    @PostMapping("/band")
    @ResponseStatus(HttpStatus.CREATED)
    public Band addBand(@RequestBody Band band) {
        return repository.save(band);
    }

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

    @DeleteMapping("/band/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBand(@PathVariable int id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/bands")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllBand() {
        repository.deleteAll();
    }
}
