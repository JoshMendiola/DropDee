package me.joshmendiola.DropDee.model.assets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import me.joshmendiola.DropDee.enums.RoomSize;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "PracticeRoom")
public class PracticeRoom implements Serializable
{
    @Id
    private int roomID;
    private RoomSize roomSize;
    private Boolean hasMixingBoard;
    private Boolean hasMicrophones;

    public int getRoomID()
    {
        return roomID;
    }

    public void setRoomID(int roomID)
    {
        this.roomID = roomID;
    }

    public RoomSize getRoomSize()
    {
        return roomSize;
    }

    public void setRoomSize(RoomSize roomSize)
    {
        this.roomSize = roomSize;
    }

    public Boolean getHasMixingBoard()
    {
        return hasMixingBoard;
    }

    public void setHasMixingBoard(Boolean hasMixingBoard)
    {
        this.hasMixingBoard = hasMixingBoard;
    }

    public Boolean getHasMicrophones()
    {
        return hasMicrophones;
    }

    public void setHasMicrophones(Boolean hasMicrophones)
    {
        this.hasMicrophones = hasMicrophones;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeRoom practiceRoom = (PracticeRoom) o;
        return getRoomID() == practiceRoom.getRoomID();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(roomID, roomSize, hasMixingBoard, hasMicrophones);
    }

    @Override
    public String toString()
    {
        return "PracticeRoom{" +
                "roomID=" + roomID +
                ", roomSize=" + roomSize +
                ", hasMixingBoard=" + hasMixingBoard +
                ", hasMicrophones=" + hasMicrophones +
                '}';
    }
}
