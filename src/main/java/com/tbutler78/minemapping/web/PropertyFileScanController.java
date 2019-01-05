package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.PropertyFileScan;
import com.tbutler78.minemapping.service.PropertyFileScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by butlert on 4/14/17.
 */
@Controller
@RequestMapping("propertyfilescans")
public class PropertyFileScanController {

    private final PropertyFileScanService propertyFileScanService;
    @Autowired
    public PropertyFileScanController(PropertyFileScanService propertyFileScanService) {
        this.propertyFileScanService = propertyFileScanService;
    }

    @ResponseBody
    @RequestMapping
    public List<PropertyFileScan> getPropertyFileScans() {
        return propertyFileScanService.findAll().subList(1, 20);

    }

    @RequestMapping("names")
    @ResponseBody
    public List<String> getNames() {
        return propertyFileScanService.findAll().stream()
                .filter(pfs -> pfs.getInfoText() != null)
                .sorted(Comparator.comparing(PropertyFileScan::getInfoText))
                .map(pfs -> pfs.getInfoText())
				//.map(PropertyFileScan::getInfoText)
                .collect(Collectors.toList());

    }


}
