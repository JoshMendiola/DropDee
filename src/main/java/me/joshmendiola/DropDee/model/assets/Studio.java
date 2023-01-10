package me.joshmendiola.DropDee.model.assets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import me.joshmendiola.DropDee.enums.StudioType;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Studio")
public class Studio implements Serializable
{
    @Id
    private int studioID;

    @Enumerated(EnumType.STRING)
    private StudioType studioType;

    public int getStudioID()
    {
        return studioID;
    }

    public void setStudioID(int studioID)
    {
        this.studioID = studioID;
    }

    public StudioType getStudioType()
    {
        return studioType;
    }

    public void setStudioType(StudioType studioType)
    {
        this.studioType = studioType;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studio studio = (Studio) o;
        return getStudioID() == studio.getStudioID();
    }

    @Override
    public String toString()
    {
        return "Studio{" +
                "studioID=" + studioID +
                ", studioType=" + studioType +
                '}';
    }
}
