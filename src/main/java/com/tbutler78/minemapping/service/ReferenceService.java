package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.Reference;
import com.tbutler78.minemapping.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by butlert on 4/17/17.
 */
@Component
public class ReferenceService {
    final private ReferenceRepository referenceRepository;
    final private ReferenceRelateService referenceRelateService;

    @Autowired
    public ReferenceService(ReferenceRepository referenceRepository, ReferenceRelateService referenceRelateService) {
        this.referenceRepository = referenceRepository;
        this.referenceRelateService = referenceRelateService;
    }

    private List<Reference> getAll(){
        List<Reference> references = new ArrayList<>();
        referenceRepository.findAll().forEach(c -> {
            c.setReferenceRelates(referenceRelateService.findByRefId(c.getReferenceId()));
            references.add(c);
        });
        return references;

    }



    public List<Reference> getReferencesWithDocuments() {
        return getAll().stream().filter(r ->
                r.getHyperlink() != null && r.getHyperlink().length() > 0).collect(Collectors.toList());
    }

	List<Reference> findBySequenceNumber(String sequenceNumber) {
        String refId = referenceRelateService.findOneBySequenceNumber(sequenceNumber).getRefId();
            return referenceRepository.findByReferenceId(refId);
	}
}
