package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.County;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(
    locations = "classpath:application-integrationtest.properties")
public class CountyRepositoryTest {
  Logger log = LoggerFactory.getLogger(CountyRepositoryTest.class);
  @Autowired
  TestEntityManager entityManager;

  @Autowired
  private CountyRepository countyRepository;

  private static final String county1Name = "Owyhee";
  private static final String county2Name = "Washington";

  @Before
  public void setUp() {


    // given

    County county = new County();
    county.setName(county1Name);
    County county2 = new County();
    county2.setName(county2Name);
    entityManager.persist(county);
    entityManager.persist(county2);
    entityManager.flush();
  }

  @Test
  public void whenFindOneByName_thenReturnCounty() {


    // when
    County found = countyRepository.findOneByName(county1Name);
    log.info(found.toString());

    // then
    assertThat(found.getName()).isEqualTo(county1Name);
    assertThat(found.getId()).isGreaterThan(0);
  }

  @Test
  public void whenFindAll_thenReturnCountyList() {

    // when
    County found = countyRepository.findOneByName(county1Name);
    List<County> counties = countyRepository.findAll();

    // then
    assertThat(counties.contains(found));
    log.info(counties.toString());

  }

}
