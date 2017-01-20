package com.github.woodylic.jmeter.client;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by choli on 2017/1/20.
 */
public class ClassToBeTested {
	public String sayHello(){
		return "Hello";
	}

	public String sayHello(String name) {
		if(StringUtils.isBlank(name) || StringUtils.isEmpty(name))
			return "Hello";

		return "Hello " + name;
	}
}
