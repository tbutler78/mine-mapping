package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.County100k;
import com.tbutler78.minemapping.domain.Location;
import com.tbutler78.minemapping.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * Created by butlert on 4/14/17.
 */

@Controller
@RequestMapping("locations")
public class LocationController {
 
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @ResponseBody
    @RequestMapping
    public List<Location> getLocations(){
       return locationService.findAll();
    }
    @ResponseBody
    @RequestMapping("hundredk")
    public List<County100k> getHundredKs(){
        return locationService.findAllByHundredK();
    }
    @ResponseBody
    @RequestMapping("counties")
    public Set<String> getCounties(){
        return locationService.getCounties();
    }
    @ResponseBody
    @RequestMapping("updatecounties")
    public List<County100k> updateCounties(){
        return locationService.updateCounties();
    }
}
