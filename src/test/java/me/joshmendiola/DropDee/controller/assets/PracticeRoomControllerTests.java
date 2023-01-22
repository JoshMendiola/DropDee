package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.enums.RoomSize;
import me.joshmendiola.DropDee.model.assets.PracticeRoom;
import me.joshmendiola.DropDee.repository.assets.PracticeRoomRepository;
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
public class PracticeRoomControllerTests
{
    @Autowired
    PracticeRoomRepository practiceRoomRepository;

    private final PracticeRoom practiceRoom = new PracticeRoom();
    private final PracticeRoom practiceRoomTwo = new PracticeRoom();
    @Before
    public void setUp() throws Exception
    {
        practiceRoomRepository.deleteAll();
        practiceRoom.setRoomID(1);
        practiceRoom.setRoomSize(RoomSize.SMALL);
        practiceRoom.setHasMicrophones(false);
        practiceRoom.setHasMixingBoard(true);

        practiceRoomRepository.save(practiceRoom);

        practiceRoomTwo.setRoomID(2);
        practiceRoomTwo.setRoomSize(RoomSize.MEDIUM);
        practiceRoomTwo.setHasMicrophones(true);
        practiceRoomTwo.setHasMixingBoard(true);

        practiceRoomRepository.save(practiceRoomTwo);
    }

    @After
    public void tearDown() throws Exception
    {
        practiceRoomRepository.deleteAll();
    }

    @Test
    public void getAllPracticeRooms()
    {
        List<PracticeRoom> practiceRoomList = practiceRoomRepository.findAll();
        assertEquals(practiceRoomList.size(), 2);
    }

    @Test
    public void getPracticeRoomByID()
    {
        Optional<PracticeRoom> firstRetrievedPracticeRoom = practiceRoomRepository.findById(1);
        Optional<PracticeRoom> secondRetrievedPracticeRoom = practiceRoomRepository.findById(2);

        assert(firstRetrievedPracticeRoom.isPresent());
        assert(firstRetrievedPracticeRoom.get().equals(practiceRoom));
        assert(secondRetrievedPracticeRoom.isPresent());
        assert(secondRetrievedPracticeRoom.get().equals(practiceRoomTwo));
    }

    @Test
    public void updatePracticeRoom()
    {
        practiceRoom.setRoomSize(RoomSize.MEDIUM);
        practiceRoom.setHasMicrophones(true);

        practiceRoomRepository.save(practiceRoom);

        assert(practiceRoomRepository.findById(1).isPresent());
        assert(practiceRoomRepository.findById(1).get().equals(practiceRoom));
    }
}
