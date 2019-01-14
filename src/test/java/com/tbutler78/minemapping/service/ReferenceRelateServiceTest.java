package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.ReferenceRelate;
import com.tbutler78.minemapping.repository.ReferenceRelateRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class ReferenceRelateServiceTest {

    @Mock
    ReferenceRelateRepository referenceRelateRepository;

    @InjectMocks
    ReferenceRelateService referenceRelateService;

    ReferenceRelate referenceRelate;
    List<ReferenceRelate> referenceRelateList = new ArrayList<>();
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        referenceRelate = new ReferenceRelate();
        referenceRelate.setRefId("456");
        referenceRelateList.add(referenceRelate);

    }
    @Test
    public void testFindOneBySequenceNumber(){

        Mockito.when(referenceRelateRepository.findOneBySequenceNumber(any())).thenReturn(referenceRelate);
        assertEquals(referenceRelateService.findOneBySequenceNumber("123"), referenceRelate);
        assertEquals(referenceRelateService.findOneBySequenceNumber("123").getRefId(), "456");
    }


    @Test
    public void testGetAll() {
        Mockito.when(referenceRelateRepository.findAll()).thenReturn(referenceRelateList);
        List<ReferenceRelate> results = referenceRelateService.getAll();
        assertEquals(results.size(), 1L);
    }


    @Test
    public void testFindBySequenceNumber() throws Exception {
        Mockito.when(referenceRelateRepository.findAllBySequenceNumber("123")).thenReturn(referenceRelateList);
        List<ReferenceRelate> results = referenceRelateService.findBySequenceNumber("123");
        assertEquals(results.size(), 1L);
    }

    @Test
    public void testFindByRefId() throws Exception {
        Mockito.when(referenceRelateRepository.findAllByRefId("123")).thenReturn(referenceRelateList);
        List<ReferenceRelate> results = referenceRelateService.findByRefId("123");
        assertEquals(results.size(), 1L);
    }

}
