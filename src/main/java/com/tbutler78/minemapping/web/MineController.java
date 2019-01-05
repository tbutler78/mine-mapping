package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.service.MineService;
import com.tbutler78.minemapping.web.command.MineResponse;
import com.tbutler78.minemapping.web.command.MineSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by butlert on 4/13/17.
 */
@RestController
@RequestMapping("mines")
public class MineController {

    private final MineService mineService;
    @Autowired
	public MineController(MineService mineService) {
		this.mineService = mineService;
	}
    @ResponseBody
    @RequestMapping(value="/county/{county}")
    public MineCommand getMines(@PathVariable String county){
        return new MineCommand(mineService.findByCounty(county));
    }

   @GetMapping("/minename/{name}")
	public List<Mine> getMinesByName(@PathVariable String name){
		return  mineService.findMineByName(name);
	}

    @GetMapping("/")
    public List<Mine> getAllMines(){
        return mineService.findAll();
    }

    @ResponseBody
    @RequestMapping(value="/{id}")
    public Mine getMine(@PathVariable Long id){
        return mineService.getMine(id);
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
