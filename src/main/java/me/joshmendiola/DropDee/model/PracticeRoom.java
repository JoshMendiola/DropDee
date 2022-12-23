package me.joshmendiola.DropDee.model;

import me.joshmendiola.DropDee.enums.RoomSize;

public class PracticeRoom
{
    private int roomID;
    private RoomSize roomSize;
    private Boolean hasMixingBoard;
    private Boolean hasMicrophones;

    public PracticeRoom(int roomID, RoomSize roomSize, Boolean hasMixingBoard, Boolean hasMicrophones)
    {
        this.roomID = roomID;
        this.roomSize = roomSize;
        this.hasMixingBoard = hasMixingBoard;
        this.hasMicrophones = hasMicrophones;
    }

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
}
