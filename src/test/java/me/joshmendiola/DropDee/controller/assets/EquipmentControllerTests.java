package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.enums.Condition;
import me.joshmendiola.DropDee.model.assets.Band;
import me.joshmendiola.DropDee.model.assets.Equipment;
import me.joshmendiola.DropDee.repository.assets.BandRepository;
import me.joshmendiola.DropDee.repository.assets.EquipmentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EquipmentControllerTests
{
    @Autowired
    EquipmentRepository equipmentRepository;

    private final Equipment equipment = new Equipment();
    private final Equipment equipmentTwo = new Equipment();

    @Before
    public void setUp() throws Exception
    {
        equipmentRepository.deleteAll();

        equipment.setEquipmentID(97295026);
        equipment.setValue(200.00);
        equipment.setModel("Solo");
        equipment.setCondition(Condition.GOOD);
        equipment.setBrand("Focusrite");
        equipment.setHourlyRate(12.50);
        equipment.setPurpose("Allows for a DI connection from an electric instrument into a moniter");

        equipmentRepository.save(equipment);

        equipmentTwo.setEquipmentID(84928302);
        equipmentTwo.setValue(120.00);
        equipmentTwo.setModel("MPK Mini");
        equipmentTwo.setCondition(Condition.PERFECT);
        equipmentTwo.setBrand("Akai Professional");
        equipmentTwo.setHourlyRate(14.50);
        equipmentTwo.setPurpose("USB MIDI keyboard");

        equipmentRepository.save(equipmentTwo);
    }

    @After
    public void tearDown() throws Exception
    {
        equipmentRepository.deleteAll();
    }

    @Test
    public void getAllEquipment()
    {
        List<Equipment> equipmentList = equipmentRepository.findAll();
        assertEquals(equipmentList.size(), 2);
    }
}
