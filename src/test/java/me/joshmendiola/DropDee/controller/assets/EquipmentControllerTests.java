package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.enums.Condition;
import me.joshmendiola.DropDee.model.assets.Band;
import me.joshmendiola.DropDee.model.assets.Equipment;
import me.joshmendiola.DropDee.repository.assets.EquipmentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

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

        equipment.setEquipmentID(97295);
        equipment.setValue(200.00);
        equipment.setModel("Solo");
        equipment.setItemCondition(Condition.GOOD);
        equipment.setBrand("Focusrite");
        equipment.setHourlyRate(12.50);
        equipment.setPurpose("Allows for a DI connection from an electric instrument into a moniter");

        equipmentRepository.save(equipment);

        equipmentTwo.setEquipmentID(84928);
        equipmentTwo.setValue(120.00);
        equipmentTwo.setModel("MPK Mini");
        equipmentTwo.setItemCondition(Condition.PERFECT);
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
    @Test
    public void getEquipmentById()
    {
        Optional<Equipment> firstRetrievedEquipment = equipmentRepository.findById(97295);
        Optional<Equipment> secondRetrievedEquipment = equipmentRepository.findById(84928);
        Optional<Equipment> thirdRetrievedEquipment = equipmentRepository.findById(100);

        assert(firstRetrievedEquipment.isPresent());
        assert(firstRetrievedEquipment.get().equals(equipment));
        assert(secondRetrievedEquipment.isPresent());
        assert(secondRetrievedEquipment.get().equals(equipmentTwo));
        assert(thirdRetrievedEquipment.isEmpty());
    }

    @Test
    public void updateEquipment()
    {
        equipment.setItemCondition(Condition.BROKEN);
        equipment.setValue(5.00);

        equipmentRepository.save(equipment);

        assert(equipmentRepository.findById(97295).isPresent());
        assert(equipmentRepository.findById(97295).get().equals(equipment));


    }
}
