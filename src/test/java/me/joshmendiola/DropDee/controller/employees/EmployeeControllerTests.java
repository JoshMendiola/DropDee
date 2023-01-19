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
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeControllerTests
{
    @Autowired
    EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception
    {
        employeeRepository.deleteAll();
    }

    @After
    public void tearDown() throws Exception
    {
        employeeRepository.deleteAll();
    }

    @Test
    public void getAllBands()
    {
        Employee employee = new Employee();
        Date date = Date.valueOf("2000-01-01");

        employee.setEmployeeID(95620);
        employee.setEmployeeEmail("tester@company.com");
        employee.setBirthday(date);
        employee.setFirstName("John D");
        employee.setHourlyPay(42.50);
        employee.setLastName("Fake");
        employee.setPersonalEmail("hometester@company.com");
        employee.setPhoneNumber("512-555-1234");
        employee.setPosition(Position.MANAGER);
        employee.setSocialSecurity("123456789");
        employee.setStartDate(new Date(System.currentTimeMillis()));

        employeeRepository.save(employee);

        Employee employeeTwo = new Employee();
        Date dateTwo = Date.valueOf("2002-01-01");

        employeeTwo.setEmployeeID(47293);
        employeeTwo.setEmployeeEmail("testerTwo@company.com");
        employeeTwo.setBirthday(dateTwo);
        employeeTwo.setFirstName("Angela M");
        employeeTwo.setHourlyPay(36.42);
        employeeTwo.setLastName("Notreal");
        employeeTwo.setPersonalEmail("hometestertwo@company.com");
        employeeTwo.setPhoneNumber("512-555-4321");
        employeeTwo.setPosition(Position.AUDIO_ENGINEER);
        employeeTwo.setSocialSecurity("987654321");
        employeeTwo.setStartDate(new Date(System.currentTimeMillis()));

        employeeRepository.save(employeeTwo);

        List<Employee> employeeList = employeeRepository.findAll();
        assertEquals(employeeList.size(), 2);
    }

    @Test
    public void getBandByID()
    {
        Employee employee = new Employee();
        Date date = Date.valueOf("2000-01-01");

        employee.setEmployeeID(95620);
        employee.setEmployeeEmail("tester@company.com");
        employee.setBirthday(date);
        employee.setFirstName("John D");
        employee.setHourlyPay(42.50);
        employee.setLastName("Fake");
        employee.setPersonalEmail("hometester@company.com");
        employee.setPhoneNumber("512-555-1234");
        employee.setPosition(Position.MANAGER);
        employee.setSocialSecurity("123456789");
        employee.setStartDate(new Date(System.currentTimeMillis()));

        employeeRepository.save(employee);

        Employee employeeTwo = new Employee();
        Date dateTwo = Date.valueOf("2002-01-01");

        employeeTwo.setEmployeeID(47293);
        employeeTwo.setEmployeeEmail("testerTwo@company.com");
        employeeTwo.setBirthday(dateTwo);
        employeeTwo.setFirstName("Angela M");
        employeeTwo.setHourlyPay(36.42);
        employeeTwo.setLastName("Notreal");
        employeeTwo.setPersonalEmail("hometestertwo@company.com");
        employeeTwo.setPhoneNumber("512-555-4321");
        employeeTwo.setPosition(Position.AUDIO_ENGINEER);
        employeeTwo.setSocialSecurity("987654321");
        employeeTwo.setStartDate(new Date(System.currentTimeMillis()));

        employeeRepository.save(employeeTwo);

        Optional<Employee> firstRetrievedEmployee = employeeRepository.findById(95620);
        Optional<Employee> secondRetrievedEmployee = employeeRepository.findById(47293);

        assert(firstRetrievedEmployee.isPresent());
        assert(firstRetrievedEmployee.get().equals(employee));
        assert(secondRetrievedEmployee.isPresent());
        assert(secondRetrievedEmployee.get().equals(employeeTwo));

    }

//
//    @Test
//    public void getBandByName()
//    {
//        Band firstBand = new Band();
//        firstBand.setBandID(1000);
//        firstBand.setName("Johmen");
//        firstBand.setGenre("Alternative/Indie");
//        firstBand.setBalance(200);
//
//        employeeRepository.save(firstBand);
//
//        Band secondBand = new Band();
//        secondBand.setBandID(2000);
//        secondBand.setName("Judds Anarchy");
//        secondBand.setGenre("Alternative");
//        secondBand.setBalance(250);
//
//        employeeRepository.save(secondBand);
//
//        System.out.println(employeeRepository.findAll());
//
//        Band firstRetrievedBand = employeeRepository.findByName("Johmen").get(0);
//        Band secondRetrievedBand = employeeRepository.findByName("Judds Anarchy").get(0);
//
//        assert(firstRetrievedBand.equals(firstBand));
//        assert(secondRetrievedBand.equals(secondBand));
//
//    }
//
//    @Test
//    public void updateArtist()
//    {
//        Band testBand = new Band();
//        testBand.setBandID(1000);
//        testBand.setName("Johmen");
//        testBand.setGenre("Alternative/Indie");
//        testBand.setBalance(200);
//
//        employeeRepository.save(testBand);
//
//        testBand.setName("Johmen and the Johmens");
//        testBand.setGenre("Punk/Surf");
//        testBand.setBalance(150);
//
//        employeeRepository.save(testBand);
//
//        assert(employeeRepository.findById(1000).isPresent());
//        assert(employeeRepository.findById(1000).get().equals(testBand));
//
//
//    }
}
