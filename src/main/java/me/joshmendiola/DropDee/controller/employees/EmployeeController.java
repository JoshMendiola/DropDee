package me.joshmendiola.DropDee.controller.employees;

import me.joshmendiola.DropDee.model.employees.Employee;
import me.joshmendiola.DropDee.repository.employees.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeRepository repository;

    //GET MAPPINGS

    //gets all employees
    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Employee> getAllEmployees()
    {
        return repository.findAll();
    }

    //gets employee by singular ID
    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Employee getEmployeeById(@PathVariable int id)
    {
        Optional<Employee> returnEmployee = repository.findById(id);
        if(returnEmployee.isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        return returnEmployee.orElse(null);
    }


    @GetMapping("/employee/{lastName}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Employee> getEmployeeByLastName(@PathVariable String lastName)
    {
        return repository.findByLastName(lastName);
    }

    //POST MAPPINGS

    //adds a single employee to the database
    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee)
    {
        if(repository.existsById(employee.getEmployeeID()))
        {
            throw new IllegalArgumentException("ERROR: An entity with that ID already exists in the database");
        }
        return repository.save(employee);
    }

    //UPDATE MAPPINGS

    //updates by ID
    @PutMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@RequestBody Employee newEmployeeData, @PathVariable int id)
    {
        Employee oldEmployeeData = getEmployeeById(id);
        oldEmployeeData.setEmployeeEmail(newEmployeeData.getEmployeeEmail());
        oldEmployeeData.setBirthday(newEmployeeData.getBirthday());
        oldEmployeeData.setFirstName(newEmployeeData.getFirstName());
        oldEmployeeData.setHourlyPay(newEmployeeData.getHourlyPay());
        oldEmployeeData.setLastName(newEmployeeData.getLastName());
        oldEmployeeData.setPersonalEmail(newEmployeeData.getPersonalEmail());
        oldEmployeeData.setPhoneNumber(newEmployeeData.getPhoneNumber());
        oldEmployeeData.setPosition(newEmployeeData.getPosition());
        oldEmployeeData.setSocialSecurity(newEmployeeData.getSocialSecurity());
        oldEmployeeData.setStartDate(newEmployeeData.getStartDate());
        repository.save(oldEmployeeData);
    }

    //DELETE MAPPINGS

    //deletes by ID
    @DeleteMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable int id)
    {
        if(repository.findById(id).isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        repository.deleteById(id);
    }

    //deletes all employees
    @DeleteMapping("/employees")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllEmployees() {
        repository.deleteAll();
    }

}
