package com.tbutler78.minemapping.domain;

import java.util.List;

import org.apache.log4j.Logger;

public class TestUtils {
private static Logger log = Logger.getLogger(TestUtils.class);

	public static <T> void dumpList(List<T> list){
		log.info(list.size());
		for (T item : list){
			log.info(item.toString());
		}
		
		
	}
	
}
