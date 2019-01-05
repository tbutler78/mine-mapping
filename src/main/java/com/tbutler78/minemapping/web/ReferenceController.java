package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.Reference;
import com.tbutler78.minemapping.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by butlert on 4/17/17.
 */
@Controller
@RequestMapping("reference")
public class ReferenceController {
    private final ReferenceService referenceService;
    @Autowired
    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @ResponseBody
    @RequestMapping
    public List<Reference> getReference(){
        return referenceService.getReferencesWithDocuments();

    }


}
