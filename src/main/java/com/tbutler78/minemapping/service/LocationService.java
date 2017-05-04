package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.County100k;
import com.tbutler78.minemapping.domain.Location;
import com.tbutler78.minemapping.integrations.AccessAdapter;
import com.tbutler78.minemapping.integrations.AccessTable;
import com.tbutler78.minemapping.repository.County100kRepository;
import com.tbutler78.minemapping.repository.LocationRepository;
import static java.util.stream.Collectors.toMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;


@Service

public class LocationService {
	private final Logger log = LoggerFactory.getLogger(LocationService.class);

	private final LocationRepository locationRepository;

	private final County100kRepository countyHundredKRepository;

	private final AccessAdapter accessAdapter;

	@Autowired
	public LocationService(LocationRepository locationRepository, County100kRepository countyHundredKRepository, AccessAdapter accessAdapter) {
		this.locationRepository = locationRepository;
		this.countyHundredKRepository = countyHundredKRepository;
		this.accessAdapter = accessAdapter;
	}

	public List<Location> findAll() {
		//return userDao.findAll();
		return locationRepository.findAll();
	}

	public List<County100k> findAllByHundredK() {
		return countyHundredKRepository.findAll();

	}

	public Set<String> getCounties() {
		return countyHundredKRepository.findAll().stream()
				.sorted(Comparator.comparing(County100k::getCountyName))
				.collect(
						toMap(County100k::getCountyName, County100k::getHundredKQuad,
								(s, a) -> s + "," + a)).keySet();

	}

	public List<County100k> updateCounties() {
		AccessTable results = null;
		try {
			results = accessAdapter.getResultSet("select * from County100k", 500);
		} catch (SQLException e) {
			log.error(e.toString());
		}

		results.getRows().forEach((HashMap<String, String> s) -> {
					log.info(Arrays.toString(s.entrySet().toArray()));
					String quad = Arrays.asList(s.entrySet().toArray()).get(0).toString();
					String county = Arrays.asList(s.entrySet().toArray()).get(1).toString();
					County100k newCounty = new County100k();


				}

		);
		return new ArrayList<>();
	}
}
