package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.service.MineService;
import com.tbutler78.minemapping.web.command.MineResponse;
import com.tbutler78.minemapping.web.command.MineSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by butlert on 4/13/17.
 */
@Controller
@RequestMapping("mines")
public class MineController {

    @Autowired
    MineService mineService;
    @ResponseBody
    @RequestMapping(value="/county/{county}")
    public MineCommand getMines(@PathVariable String county){
        return new MineCommand(mineService.findByCounty(county));
    }

    @ResponseBody
	@RequestMapping(value="minename/{name}")
	public List<Mine> getMinesByName(@PathVariable String name){
		return  mineService.findMineByName(name);
	}

    @ResponseBody
    @RequestMapping
	@CrossOrigin(origins = "http://localhost:3000")
    public List<Mine> getAllMines(){
        return mineService.findAll().subList(0,10);
    }

    @ResponseBody
    @RequestMapping(value="/{id}")
    public Mine getMine(@PathVariable Long id){
        return mineService.findMine(id);
    }

    @ResponseBody

    @RequestMapping(path="/mine-summaries")
    public List<MineResponse> getMineSummaries(){
        return mineService.findAllMineSummaries();
    }

    @ResponseBody
    @RequestMapping(value="/mine-summaries/{county}")
    public List<MineResponse> getMineSummariesByCounty(@PathVariable String county){
        return mineService.findAllMineSummaries(county);
    }

    @ResponseBody
	@RequestMapping(value="/mine-summary/{id}")
	public MineSummary getMineSummary(@PathVariable Long id){
    	return mineService.getMineSummary(id);
	}
}
