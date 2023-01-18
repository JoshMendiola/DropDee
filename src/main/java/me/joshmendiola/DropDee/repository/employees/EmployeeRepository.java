package me.joshmendiola.DropDee.repository.employees;

import me.joshmendiola.DropDee.model.employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
