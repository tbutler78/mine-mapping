package com.tbutler78.minemapping.domain;

import com.tbutler78.minemapping.repository.MineRepository;
import com.tbutler78.minemapping.service.MineService;
import com.tbutler78.minemapping.service.ReferenceRelateService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MineServiceTest {

    private static Logger log = LoggerFactory.getLogger(MineServiceTest.class);


    @Mock
    ReferenceRelateService referenceRelateService;

    @Mock
    MineRepository mineRepository;

    @InjectMocks
    MineService mineService;

    Mine mine;
    List<Mine> mineList = new ArrayList<>();


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mine = new Mine();
        mine.setDeposit("Cumberland");
        mineList.add(mine);

    }

    @Test
    public void testFindAll() {
        Mockito.when(mineRepository.findAll()).thenReturn(mineList);
        Assert.assertTrue(mineService.findAll().size() > 0);
    }

    @Test
    public void testSeqNumber() {

        Mockito.when(mineService.findAll()).thenReturn(mineList);
        List<Mine> results = mineService.findAll();
        assertEquals(1L, results.size());
    }

    @Test
    public void testFindByCounty() {
        Mockito.when(mineRepository.findByCountyNameAndLatitudeIsNotNullAndLongitudeIsNotNull("GEM")).thenReturn(mineList);
        List<Mine> results = mineService.findByCounty("GEM");
        log.info(results.toString());
        assertEquals(1L, results.size());
        results = mineService.findByCounty("Owyhee");
        assertEquals(results.size(), 0L);
    }

    @Test
    public void testFindMineByName() {
        Mockito.when(mineRepository.findByDepositContaining("Cumberland")).thenReturn(mineList);
        List<Mine> mines = mineService.findMineByName("Cumberland");
        assertEquals(mines.size(), 1L);
        mines = mineService.findMineByName("Blackjack");
        assertEquals(mines.size(), 0L);
    }

}
