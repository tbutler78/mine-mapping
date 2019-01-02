package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.County;
import com.tbutler78.minemapping.repository.CountyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CountyServiceTest {

  Logger log = LoggerFactory.getLogger(CountyServiceTest.class);

  @Mock
  CountyRepository countyRepository;

  CountyService countyService;



  @Before
  public void setUp() throws Exception {
    countyService = new CountyService(countyRepository);

    County county = new County();
    county.setName("Owyhee");
    List<County> counties = new ArrayList<>();
    counties.add(county);

    Mockito.when(countyRepository.findAll()).thenReturn(counties);

    Mockito.when(countyRepository.findOneByName("Owyhee")).thenReturn(county);
  }

  @Test
  public void whenGetCounties_thenReturnAllCounties(){
    List<County> found = countyService.getCounties();
    assertThat(found.size()).isGreaterThan(0);
  }

  @Test
  public void whenValidName_thenReturnCounty() throws Exception {
    String name = "Owyhee";
    County found = countyService.findOneByName(name);
    assertThat(found.getName()).isEqualTo(name);


  }

}
