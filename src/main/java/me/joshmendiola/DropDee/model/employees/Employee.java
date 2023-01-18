package me.joshmendiola.DropDee.model.employees;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Employee")
public class Employee implements Serializable
{
    @Id
    private int employeeID;
    private String phoneNumber;
    private String employeeEmail;
    private String personalEmail;
    private String firstName;
    private String lastName;
    private String position;
    private Double hourlyPay;
    private Timestamp birthday;
    private String socialSecurity;
    private Timestamp startDate;

    public int getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeEmail()
    {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail)
    {
        this.employeeEmail = employeeEmail;
    }

    public String getPersonalEmail()
    {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail)
    {
        this.personalEmail = personalEmail;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public Double getHourlyPay()
    {
        return hourlyPay;
    }

    public void setHourlyPay(Double hourlyPay)
    {
        this.hourlyPay = hourlyPay;
    }

    public Timestamp getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Timestamp birthday)
    {
        this.birthday = birthday;
    }

    public String getSocialSecurity()
    {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity)
    {
        this.socialSecurity = socialSecurity;
    }

    public Timestamp getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Timestamp startDate)
    {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(employeeEmail, employee.employeeEmail) && Objects.equals(personalEmail, employee.personalEmail) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(position, employee.position) && Objects.equals(hourlyPay, employee.hourlyPay) && Objects.equals(birthday, employee.birthday) && Objects.equals(socialSecurity, employee.socialSecurity) && Objects.equals(startDate, employee.startDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(employeeID, phoneNumber, employeeEmail, personalEmail, firstName, lastName, position, hourlyPay, birthday, socialSecurity, startDate);
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", personalEmail='" + personalEmail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", hourlyPay=" + hourlyPay +
                ", birthday=" + birthday +
                ", socialSecurity='" + socialSecurity + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
