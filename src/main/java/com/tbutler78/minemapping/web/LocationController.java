package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.Location;
import com.tbutler78.minemapping.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by butlert on 4/14/17.
 */

@Controller
@RequestMapping("locations")
public class LocationController {
 
    private LocationService locationService;


    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @ResponseBody
    @RequestMapping
    public List<Location> getLocations(){
       return locationService.findAll();
    }
}
