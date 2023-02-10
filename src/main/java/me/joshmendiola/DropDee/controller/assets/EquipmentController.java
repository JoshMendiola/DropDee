package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.model.assets.Equipment;
import me.joshmendiola.DropDee.repository.assets.EquipmentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EquipmentController
{
    @Autowired
    EquipmentRepository repository;

    //GET MAPPINGS

    //gets all equipment
    @GetMapping("/equipment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Equipment> getAllEquipment()
    {
        return repository.findAll();
    }

    //gets equipment by singular ID
    @GetMapping("/equipment/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Equipment getEquipmentById(@PathVariable int id)
    {
        Optional<Equipment> returnEquipment = repository.findById(id);
        if(returnEquipment.isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        return returnEquipment.orElse(null);
    }

    //gets equipment by brand
    @GetMapping("/equipment/{brand}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Equipment> getEquipmentByBrand(@PathVariable String brand)
    {
        if(repository.findByBrand(brand).isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that brand found !");
        }
        return repository.findByBrand(brand);
    }

    //POST MAPPINGS

    //adds a single equipment to the database
    @PostMapping("/equipment")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipment addEquipment(@RequestBody Equipment equipment)
    {
        if(repository.existsById(equipment.getEquipmentID()))
        {
            throw new IllegalArgumentException("ERROR: An entity with that ID already exists in the database");
        }

        return repository.save(equipment);
    }

    //UPDATE MAPPINGS

    //updates by ID
    @PutMapping("/equipment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEquipment(@RequestBody @NotNull Equipment newEquipmentData, @PathVariable int id)
    {
        Equipment equipment = getEquipmentById(id);
        equipment.setBrand(newEquipmentData.getBrand());
        equipment.setItemCondition(newEquipmentData.getItemCondition());
        equipment.setHourlyRate(newEquipmentData.getHourlyRate());
        equipment.setModel(newEquipmentData.getModel());
        equipment.setPurpose(newEquipmentData.getPurpose());
        equipment.setValue(newEquipmentData.getValue());

        repository.save(equipment);
    }

    //DELETE MAPPINGS

    //deletes by ID
    @DeleteMapping("/equipment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEquipment(@PathVariable int id)
    {
        if(repository.findById(id).isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        repository.deleteById(id);
    }

    //deletes all equipment
    @DeleteMapping("/equipment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllEquipment() {
        repository.deleteAll();
    }
}
