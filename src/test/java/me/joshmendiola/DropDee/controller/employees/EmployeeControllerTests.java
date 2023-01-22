package me.joshmendiola.DropDee.controller.employees;

import me.joshmendiola.DropDee.enums.Position;
import me.joshmendiola.DropDee.model.employees.Employee;
import me.joshmendiola.DropDee.repository.employees.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeControllerTests
{
    @Autowired
    EmployeeRepository employeeRepository;

    private final Employee employee = new Employee();
    private final Employee newEmployeeTwo = new Employee();
    private final Employee employeeThree = new Employee();

    @Before
    public void setUp()
    {
        employeeRepository.deleteAll();

        Date birthdayOne = Date.valueOf("2000-01-01");
        Date startingDateOne = Date.valueOf("2023-01-19");

        employee.setEmployeeID(95620);
        employee.setEmployeeEmail("tester@company.com");
        employee.setBirthday(birthdayOne);
        employee.setFirstName("John D");
        employee.setHourlyPay(42.50);
        employee.setLastName("Fake");
        employee.setPersonalEmail("hometester@company.com");
        employee.setPhoneNumber("512-555-1234");
        employee.setPosition(Position.MANAGER);
        employee.setSocialSecurity("123456789");
        employee.setStartDate(startingDateOne);

        employeeRepository.save(employee);

        Date birthdayTwo = Date.valueOf("2002-01-01");
        Date startingDateTwo = Date.valueOf("2022-11-21");

        newEmployeeTwo.setEmployeeID(47293);
        newEmployeeTwo.setEmployeeEmail("testerTwo@company.com");
        newEmployeeTwo.setBirthday(birthdayTwo);
        newEmployeeTwo.setFirstName("Angela M");
        newEmployeeTwo.setHourlyPay(36.42);
        newEmployeeTwo.setLastName("Notreal");
        newEmployeeTwo.setPersonalEmail("hometestertwo@company.com");
        newEmployeeTwo.setPhoneNumber("512-555-4321");
        newEmployeeTwo.setPosition(Position.AUDIO_ENGINEER);
        newEmployeeTwo.setSocialSecurity("987654321");
        newEmployeeTwo.setStartDate(startingDateTwo);

        employeeRepository.save(newEmployeeTwo);

        Date birthdayThree = Date.valueOf("1999-01-01");
        Date startingDateThree = Date.valueOf("2004-03-01");

        employeeThree.setEmployeeID(82902);
        employeeThree.setEmployeeEmail("testerThree@company.com");
        employeeThree.setBirthday(birthdayThree);
        employeeThree.setFirstName("Richard B");
        employeeThree.setHourlyPay(36.42);
        employeeThree.setLastName("Notreal");
        employeeThree.setPersonalEmail("hometesterthree@company.com");
        employeeThree.setPhoneNumber("512-555-4321");
        employeeThree.setPosition(Position.AUDIO_ENGINEER);
        employeeThree.setSocialSecurity("96986356");
        employeeThree.setStartDate(startingDateThree);

        employeeRepository.save(employeeThree);
    }

    @After
    public void tearDown()
    {
        employeeRepository.deleteAll();
    }

    @Test
    public void getAllEmployees()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        assertEquals(employeeList.size(), 3);
    }

    @Test
    public void getEmployeeByID()
    {
        Optional<Employee> firstRetrievedEmployee = employeeRepository.findById(95620);
        Optional<Employee> secondRetrievedEmployee = employeeRepository.findById(47293);

        assert(firstRetrievedEmployee.isPresent());
        assert(firstRetrievedEmployee.get().equals(employee));
        assert(secondRetrievedEmployee.isPresent());
        assert(secondRetrievedEmployee.get().equals(newEmployeeTwo));

    }

//
    @Test
    public void getBandByLastName()
    {
        List<Employee> employeeList = employeeRepository.findByLastName("Notreal");
        assert(employeeList.size() == 2);
        assert(employeeList.get(0).equals(newEmployeeTwo));
        assert (employeeList.get(1).equals(employeeThree));
    }

    @Test
    public void updateEmployee()
    {
        Date birthdayTwo = Date.valueOf("2002-11-01");
        Date startingDateTwo = Date.valueOf("2022-01-21");

        newEmployeeTwo.setEmployeeID(47293);
        newEmployeeTwo.setEmployeeEmail("testerTwo@company.com");
        newEmployeeTwo.setBirthday(birthdayTwo);
        newEmployeeTwo.setFirstName("Angela M");
        newEmployeeTwo.setHourlyPay(40.0);
        newEmployeeTwo.setLastName("Notreal");
        newEmployeeTwo.setPersonalEmail("hometestertwo@company.com");
        newEmployeeTwo.setPhoneNumber("512-555-4321");
        newEmployeeTwo.setPosition(Position.AUDIO_ENGINEER);
        newEmployeeTwo.setSocialSecurity("987654321");
        newEmployeeTwo.setStartDate(startingDateTwo);

        employeeRepository.save(newEmployeeTwo);

        assert(employeeRepository.findById(47293).isPresent());
        assert(employeeRepository.findById(47293).get().equals(newEmployeeTwo));


    }
}
