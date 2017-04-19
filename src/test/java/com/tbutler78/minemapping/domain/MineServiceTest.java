package com.tbutler78.minemapping.domain;

import com.tbutler78.minemapping.MineMappingApplicationTest;
import com.tbutler78.minemapping.service.MineService;
import com.tbutler78.minemapping.service.ReferenceRelateService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class MineServiceTest extends MineMappingApplicationTest{

	private static Logger log = LoggerFactory.getLogger(MineServiceTest.class);
	@Autowired
	MineService mineService;

	@Autowired
	ReferenceRelateService referenceRelateService;

	@Test
	public void testFindAll() {
		Assert.assertTrue(mineService.findAll().size() > 0);
	}

	@Test
	public void testSeqNumber(){
		mineService.findAll().subList(0,30).stream().forEach(m -> {

				log.info(m.getDeposit());
			referenceRelateService.findBySequenceNumber(m.getSequenceNumber()).stream().forEach(r ->
					log.info(r.getReference())
			);
				});
	}

	@Test
	public void testFindByCounty() {
		Assert.assertTrue(mineService.findByCounty("GEM").size() > 0);
	}

	@Test
	public void testFindMineByName() {
		List<Mine> mines = mineService.findMineByName("Cumberland");
		log.info(mines.toString());
	}

}
