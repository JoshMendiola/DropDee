package me.joshmendiola.DropDee.controller.employees;

import me.joshmendiola.DropDee.repository.employees.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeRepository employeeRepository;


}
