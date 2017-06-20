package com.Generator.test;

import java.io.IOException;
import java.util.List;

import com.Generator.ServerPropertiesGenerator;

public class Tester {

	public static void main(String[] args) throws IOException {
		List<String> testLines = ServerPropertiesGenerator.process(ServerPropertiesGenerator.read());
		
		for(String s : testLines){
			System.out.println(s);
		}

	}

}
