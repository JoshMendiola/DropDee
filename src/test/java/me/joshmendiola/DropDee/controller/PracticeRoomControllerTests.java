package me.joshmendiola.DropDee.controller;

import me.joshmendiola.DropDee.enums.RoomSize;
import me.joshmendiola.DropDee.model.assets.Band;
import me.joshmendiola.DropDee.model.assets.PracticeRoom;
import me.joshmendiola.DropDee.repository.PracticeRoomRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PracticeRoomControllerTests
{
    @Autowired
    PracticeRoomRepository practiceRoomRepository;

    @Before
    public void setUp() throws Exception
    {
        practiceRoomRepository.deleteAll();
    }

    @After
    public void tearDown() throws Exception
    {
        practiceRoomRepository.deleteAll();
    }

    @Test
    public void getAllPracticeRooms()
    {
        PracticeRoom practiceRoom = new PracticeRoom();
        practiceRoom.setRoomID(1);
        practiceRoom.setRoomSize(RoomSize.SMALL);
        practiceRoom.setHasMicrophones(false);
        practiceRoom.setHasMixingBoard(true);

        practiceRoomRepository.save(practiceRoom);

        PracticeRoom practiceRoomTwo = new PracticeRoom();
        practiceRoomTwo.setRoomID(2);
        practiceRoomTwo.setRoomSize(RoomSize.MEDIUM);
        practiceRoomTwo.setHasMicrophones(true);
        practiceRoomTwo.setHasMixingBoard(true);

        practiceRoomRepository.save(practiceRoomTwo);

        List<PracticeRoom> practiceRoomList = practiceRoomRepository.findAll();
        assertEquals(practiceRoomList.size(), 2);
    }

}
