package com.tbutler78.minemapping.service;


import com.tbutler78.minemapping.domain.MrdsLookup;
import com.tbutler78.minemapping.repository.MrdsLookupRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MrdsServiceTest {


    @Mock
    MrdsLookupRepository mrdsLookupRepository;

    @InjectMocks
    MrdsService mrdsService;

    MrdsLookup mrdsLookup;
    List<MrdsLookup> mrdsLookupList = new ArrayList<>();

    @Before
    public void setup(){
        mrdsLookup = new MrdsLookup();
        mrdsLookup.setCounty("Owyhee");
        mrdsLookupList.add(mrdsLookup);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMrds(){
        Mockito.when(mrdsLookupRepository.findAll()).thenReturn(mrdsLookupList);
        List<MrdsLookup> results = mrdsService.getAll();
        assertEquals(results.size(), 1);

    }

}
