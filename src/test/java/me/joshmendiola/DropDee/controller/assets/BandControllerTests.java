package me.joshmendiola.DropDee.controller.assets;

import me.joshmendiola.DropDee.model.assets.Band;
import me.joshmendiola.DropDee.repository.assets.BandRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BandControllerTests
{
    @Autowired
    BandRepository bandRepository;

    private final Band firstBand = new Band();
    private final Band secondBand = new Band();

    @Before
    public void setUp() throws Exception
    {
        bandRepository.deleteAll();

        firstBand.setBandID(1000);
        firstBand.setName("Johmen");
        firstBand.setGenre("Alternative/Indie");
        firstBand.setBalance(200);

        bandRepository.save(firstBand);

        secondBand.setBandID(2000);
        secondBand.setName("Judds Anarchy");
        secondBand.setGenre("Alternative");
        secondBand.setBalance(250);

        bandRepository.save(secondBand);
    }

    @After
    public void tearDown() throws Exception
    {
        bandRepository.deleteAll();
    }

    @Test
    public void getAllBands()
    {
        List<Band> bandList = bandRepository.findAll();
        assertEquals(bandList.size(), 2);
    }

    @Test
    public void getBandByID()
    {
        Optional<Band> firstRetrievedBand = bandRepository.findById(1000);
        Optional<Band> secondRetrievedBand = bandRepository.findById(2000);

        assert(firstRetrievedBand.isPresent());
        assert(firstRetrievedBand.get().equals(firstBand));
        assert(secondRetrievedBand.isPresent());
        assert(secondRetrievedBand.get().equals(secondBand));

    }


    @Test
    public void getBandByName()
    {
        List<Band> bandList = bandRepository.findByName("Johmen");

        assert(bandList.size() == 1);
        assert(bandList.get(0).equals(firstBand));
    }

    @Test
    public void updateBand()
    {
        Band testBand = new Band();
        testBand.setBandID(1000);
        testBand.setName("Johmen and the Johmens");
        testBand.setGenre("Punk/Surf");
        testBand.setBalance(150);

        bandRepository.save(testBand);

        assert(bandRepository.findById(1000).isPresent());
        assert(bandRepository.findById(1000).get().equals(testBand));


    }
}
