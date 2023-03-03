package me.joshmendiola.DropDee.model.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Useraccount")
public class UserAccount
{
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID UserID;
    private String username;
    private String bio;
    private String password;
    private String email;
    private String phoneNumber;

    public UUID getUserID()
    {
        return UserID;
    }

    public void setUserID(UUID userID)
    {
        UserID = userID;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getBio()
    {
        return bio;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof UserAccount that)) return false;
        return Objects.equals(getUserID(), that.getUserID()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getBio(), that.getBio()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUserID(), getUsername(), getBio(), getPassword(), getEmail(), getPhoneNumber());
    }

    @Override
    public String toString()
    {
        return "UserAccount{" +
                "UserID=" + UserID +
                ", username='" + username + '\'' +
                ", bio='" + bio + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
