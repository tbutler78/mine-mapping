package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.County;
import com.tbutler78.minemapping.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by butlert on 4/13/17.
 */
@Controller
@RequestMapping("counties")
public class CountyController {

    private final CountyService countyService;
    @Autowired
    public CountyController(CountyService countyService) {
        this.countyService = countyService;
    }

    @ResponseBody
    @RequestMapping(value="/counties")
    public List<County> getCounties(){
        return countyService.getCounties();
    }
}
