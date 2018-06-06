package com.tbutler78.minemapping.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;



public class TestUtils {
private static Logger log = LoggerFactory.getLogger(TestUtils.class);

	public static <T> void dumpList(List<T> list){
		log.info("Size:", list.size());
		for (T item : list){
			log.info(item.toString());
		}
		
		
	}
	
}
