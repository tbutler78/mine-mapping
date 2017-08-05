package com.tbutler78.minemapping.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by butlert on 8/18/16.
 */
public class Test {

	private static final Logger log = LoggerFactory.getLogger(Test.class);

	private Test() {
		main(new String[0]);
	}

	public static void main(String args[]) {
		Identity<String> idString = new Identity<>("abc");
		Identity<Integer> idInt = idString.map(String::length);
		if (idInt != null && idString != null) {
			log.info(String.format("%s %s", idInt, idString));
		}
	}
}