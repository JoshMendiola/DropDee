package me.joshmendiola.DropDee.model.assets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import me.joshmendiola.DropDee.enums.Condition;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Equipment")
public class Equipment
{
    @Id
    private int equipmentID;
    private String brand;
    private String model;
    private double value;
    private double hourlyRate;
    @Enumerated(EnumType.STRING)
    private Condition itemCondition;
    private String purpose;

    public int getEquipmentID()
    {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID)
    {
        this.equipmentID = equipmentID;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public double getHourlyRate()
    {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    public Condition getItemCondition()
    {
        return itemCondition;
    }

    public void setItemCondition(Condition itemCondition)
    {
        this.itemCondition = itemCondition;
    }

    public String getPurpose()
    {
        return purpose;
    }

    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Equipment equipment)) return false;
        return getEquipmentID() == equipment.getEquipmentID() && Double.compare(equipment.getValue(), getValue()) == 0 && Double.compare(equipment.getHourlyRate(), getHourlyRate()) == 0 && Objects.equals(getBrand(), equipment.getBrand()) && Objects.equals(getModel(), equipment.getModel()) && getItemCondition() == equipment.getItemCondition() && Objects.equals(getPurpose(), equipment.getPurpose());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getEquipmentID(), getBrand(), getModel(), getValue(), getHourlyRate(), getItemCondition(), getPurpose());
    }

    @Override
    public String toString()
    {
        return "Equipment{" +
                "equipmentID=" + equipmentID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", value=" + value +
                ", hourlyRate=" + hourlyRate +
                ", condition=" + itemCondition +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
