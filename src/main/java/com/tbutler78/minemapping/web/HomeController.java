package com.tbutler78.minemapping.web;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.service.MineService;
import com.tbutler78.minemapping.web.MineCommand;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// Constants

	@Autowired
	private MineService mineService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value="/mines")
	public ResponseEntity<MineCommand> getMines(){
		return buildResponse(new MineCommand(mineService.findByCounty("Owyhee")));
	}
	
	@RequestMapping(value="/mine")
	public ResponseEntity<Mine> getMine(){
		return buildResponse(mineService.findMine());
	}	
	
	private <T> ResponseEntity<T> buildResponse(T item){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Access-Control-Allow-Origin", "*");
		responseHeaders.add("Access-Control-Allow-Methods", "GET, OPTIONS, POST");
		responseHeaders.add("Access-Control-Allow-Headers", "Content-Type");
		responseHeaders.add("Access-Control-Max-Age", "86400");
		return new ResponseEntity<T>(item, responseHeaders, HttpStatus.OK);
	}

}
