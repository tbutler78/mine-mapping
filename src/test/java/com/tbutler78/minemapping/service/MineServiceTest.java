package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.repository.MineRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class MineServiceTest {

  @Mock
  MineRepository mineRepository;

  @Mock
  PropertyFileScanService propertyFileScanService;

  @Mock
    ReferenceService referenceService;

  MineService mineService;

	@Before
	public void setUp() throws Exception {
	  mineService = new MineService(mineRepository, propertyFileScanService, referenceService);
	}

	@Test
	public void findAll() {
	  // given
	  List<Mine> mines = new ArrayList<>();
	  Mine mine = new Mine();
	  mines.add(mine);

	  //when
	  Mockito.when(mineRepository.findAll()).thenReturn(mines);

	  // then
	  assertThat(mineService.findAll()).isEqualTo(mines);
	}

	@Test
	public void findAllMineSummaries() throws Exception {
	}

	@Test
	public void findAllMineSummaries1() throws Exception {
	}

	@Test
	public void findByCounty() throws Exception {
	}

	@Test
	public void findMine() throws Exception {
	}

	@Test
	public void findMineByName() throws Exception {
	}

	@Test
	public void getMineSummary() throws Exception {
	}

}
