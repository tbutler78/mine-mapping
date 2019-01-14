package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.County;
import com.tbutler78.minemapping.domain.County100k;
import com.tbutler78.minemapping.domain.Location;
import com.tbutler78.minemapping.integrations.AccessAdapter;
import com.tbutler78.minemapping.integrations.AccessTable;
import com.tbutler78.minemapping.repository.County100kRepository;
import com.tbutler78.minemapping.repository.CountyRepository;
import com.tbutler78.minemapping.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toMap;


@Service

public class LocationService {
	private final Logger log = LoggerFactory.getLogger(LocationService.class);

	private final LocationRepository locationRepository;
	private final AccessAdapter accessAdapter;
	private final County100kRepository countyHundredKRepository;
	private final CountyRepository countyRepository;

	@Autowired
	public LocationService(LocationRepository locationRepository, County100kRepository countyHundredKRepository, AccessAdapter accessAdapter, CountyRepository countyRepository) {
		this.locationRepository = locationRepository;
		this.countyHundredKRepository = countyHundredKRepository;
		this.accessAdapter = accessAdapter;
		this.countyRepository = countyRepository;
	}


	public List<Location> findAll() {
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
		Set<String> counties = new HashSet<>();
		AccessTable results;
		try {
			results = accessAdapter.getResultSet("select * from County100k", 500);


			for (Map<String, String> stringStringHashMap : results.getRows()) {
				String county = Arrays.asList(stringStringHashMap.entrySet().toArray()).get(1).toString().split("=")[1];
				counties.add(county);
			}

			counties.forEach(s -> {
					County c = countyRepository.findOneByName(s);
					if (c == null){
						County newCounty = new County();
						newCounty.setName(s);
						saveCounty(newCounty);
					}
					log.info(s, ": ", (c != null ? c.toString() : "none"));
				});

		} catch (Exception e) {
			log.error("error:{}", e);
		}

		return new ArrayList<>();
	}


	private County saveCounty(County county){
		return countyRepository.save(county);
	}

}
