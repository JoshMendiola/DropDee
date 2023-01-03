package me.joshmendiola.DropDee.model.assets;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Band")
public class Band implements Serializable
{
    @Id
    private int bandID;
    private String name;
    private String genre;
    private int balance;

    public int getBandID()
    {
        return bandID;
    }

    public void setBandID(int bandID)
    {
        this.bandID = bandID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return getBandID() == band.getBandID();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(bandID, name, genre, balance);
    }

    @Override
    public String toString()
    {
        return "Band{" +
                "bandID=" + bandID +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", balance=" + balance +
                '}';
    }
}
