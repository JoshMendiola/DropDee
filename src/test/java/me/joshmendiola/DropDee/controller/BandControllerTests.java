package me.joshmendiola.DropDee.controller;

import me.joshmendiola.DropDee.model.assets.Band;
import me.joshmendiola.DropDee.repository.BandRepository;
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

    @Before
    public void setUp() throws Exception
    {
        bandRepository.deleteAll();
    }

    @Test
    public void getAllBands()
    {
        Band band = new Band();
        band.setBandID(1);
        band.setName("Johmen");
        band.setGenre("Alternative/Indie");
        band.setBalance(200);

        bandRepository.save(band);

        Band secondBand = new Band();
        secondBand.setBandID(2);
        secondBand.setName("Judds Anarchy");
        secondBand.setGenre("Alternative");
        secondBand.setBalance(250);

        bandRepository.save(secondBand);

        List<Band> aList = bandRepository.findAll();
        assertEquals(aList.size(), 2);
    }

    @Test
    public void getBandByID()
    {
        Band firstBand = new Band();
        firstBand.setBandID(1000);
        firstBand.setName("Johmen");
        firstBand.setGenre("Alternative/Indie");
        firstBand.setBalance(200);

        bandRepository.save(firstBand);

        Band secondBand = new Band();
        secondBand.setBandID(2000);
        secondBand.setName("Judds Anarchy");
        secondBand.setGenre("Alternative");
        secondBand.setBalance(250);

        bandRepository.save(secondBand);

        System.out.println(bandRepository.findAll());

        Optional<Band> firstRetrievedBand = bandRepository.findById(1000);
        Optional<Band> secondRetrievedBand = bandRepository.findById(2000);

        assert(firstRetrievedBand.isPresent());
        assert(firstRetrievedBand.get().equals(firstBand));
        assert(secondRetrievedBand.isPresent());
        assert(secondRetrievedBand.get().equals(secondBand));

    }
}
