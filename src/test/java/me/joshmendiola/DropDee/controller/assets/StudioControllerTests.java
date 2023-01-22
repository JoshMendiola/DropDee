package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.enums.StudioType;
import me.joshmendiola.DropDee.model.assets.Studio;
import me.joshmendiola.DropDee.repository.assets.StudioRepository;
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
public class StudioControllerTests
{
    @Autowired
    StudioRepository studioRepository;

    Studio studio = new Studio();
    Studio studioTwo = new Studio();

    @Before
    public void setUp() throws Exception
    {
        studioRepository.deleteAll();

        studio.setStudioID(10);
        studio.setStudioType(StudioType.FREELANCE);

        studioRepository.save(studio);

        studioTwo.setStudioID(20);
        studioTwo.setStudioType(StudioType.IN_HOUSE);

        studioRepository.save(studioTwo);
    }

    @After
    public void tearDown() throws Exception
    {
        studioRepository.deleteAll();
    }

    @Test
    public void getAllStudios()
    {
        List<Studio> studiosList = studioRepository.findAll();
        assertEquals(studiosList.size(), 2);
    }

    @Test
    public void getStudioByID()
    {
        Optional<Studio> firstRetrievedStudio = studioRepository.findById(10);
        Optional<Studio> secondRetrievedStudio = studioRepository.findById(20);

        assert(firstRetrievedStudio.isPresent());
        assert(firstRetrievedStudio.get().equals(studio));
        assert(secondRetrievedStudio.isPresent());
        assert(secondRetrievedStudio.get().equals(studioTwo));
    }

    @Test
    public void updateStudio()
    {
        studio.setStudioID(10);
        studio.setStudioType(StudioType.FREELANCE);

        assert(studioRepository.findById(10).isPresent());
        assert(studioRepository.findById(10).get().equals(studio));


    }
}
