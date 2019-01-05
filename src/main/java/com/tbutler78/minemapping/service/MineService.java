package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.domain.PropertyFileScan;
import com.tbutler78.minemapping.domain.Reference;
import com.tbutler78.minemapping.repository.MineRepository;
import com.tbutler78.minemapping.web.command.MineResponse;
import com.tbutler78.minemapping.web.command.MineSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class MineService {
	private final MineRepository mineRepository;
	private final PropertyFileScanService propertyFileScanService;
	private final ReferenceService referenceService;

	@Autowired
	public MineService(MineRepository mineRepository, PropertyFileScanService propertyFileScanService, ReferenceService referenceService) {
		this.mineRepository = mineRepository;
		this.propertyFileScanService = propertyFileScanService;
		this.referenceService = referenceService;
	}

	public List<Mine> findAll() {
		return mineRepository.findAll();
	}

	public List<MineResponse> findAllMineSummaries() {
		List<MineResponse> summaries = new ArrayList<>();
		mineRepository.findAll().stream().forEach(m ->
				summaries.add(new MineResponse(m.getDeposit(), m.getLatitude(), m.getLongitude(), m.getCountyName()))
		);
		return summaries;
	}

	public List<MineResponse> findAllMineSummaries(String county) {

		List<MineResponse> summaries = new ArrayList<>();
		mineRepository.findByCountyNameAndLatitudeIsNotNullAndLongitudeIsNotNull(county).stream()
				.sorted(Comparator.comparing(Mine::getDeposit)).forEach(m -> {
			summaries.add(new MineResponse(m.getDeposit(), m.getLatitude(), m.getLongitude(), m.getCountyName()));
		});
		return summaries;
	}

	public List<Mine> findByCounty(String county) {
		return mineRepository.findByCountyNameAndLatitudeIsNotNullAndLongitudeIsNotNull(county).stream()
				.sorted(Comparator.comparing(Mine::getDeposit)).collect(Collectors.toList());

	}

	public Mine getMine(Long id) {
		return mineRepository.getOne(id);
	}

	public List<Mine> findMineByName(String name) {
		return mineRepository.findByDepositContaining(name);
	}

	public MineSummary getMineSummary(Long id){
		Mine mine = getMine(id);
		List<PropertyFileScan> propertyFileScans = propertyFileScanService.findByPropertyNumber(mine.getSequenceNumber());
		List<Reference> references = referenceService.findBySequenceNumber(mine.getSequenceNumber());

		return new MineSummary(mine, propertyFileScans, references);

	}

	//private List<PropertyFileScan> getPropertyFileScans()
}
