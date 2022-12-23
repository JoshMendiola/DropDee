package me.joshmendiola.DropDee.model;

public class Band
{
    private int bandID;
    private String name;
    private String[] bandMembers;
    private String genre;
    private int balance;

    public Band(int bandID, String name, String[] bandMembers, String genre, int balance)
    {
        this.bandID = bandID;
        this.name = name;
        this.bandMembers = bandMembers;
        this.genre = genre;
        this.balance = balance;
    }

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

    public String[] getBandMembers()
    {
        return bandMembers;
    }

    public void setBandMembers(String[] bandMembers)
    {
        this.bandMembers = bandMembers;
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
}
