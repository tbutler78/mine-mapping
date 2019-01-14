
package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.Location;
import com.tbutler78.minemapping.repository.LocationRepository;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LocationServiceTest {

    @Mock
    LocationRepository locationRepository;

    @InjectMocks
    LocationService locationService;

    Location location;
    List<Location> locations = new ArrayList<>();

    @Before
    public void before()  {
        location = new Location();
        location.setDeposit("Cumberland");
        locations.add(location);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRepository() {
        Mockito.when(locationRepository.findAll()).thenReturn(locations);
        int locationSize = locationRepository.findAll().size();
        assertEquals(1L, locationSize);
    }

    @Test
    public void testFindAll() throws Exception {
        Mockito.when(locationRepository.findAll()).thenReturn(locations);
        assertEquals(1L, locationService.findAll().size());

    }
}
