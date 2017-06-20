package com.Generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerPropertiesGenerator{

	final static String FILE_NAME = "E:\\Desktop\\StormForged Productions Work\\Ben Projects\\ServerPropertiesGenerator\\test.properties";
	final static String OUTPUT_FILE_NAME = "E:\\Desktop\\StormForged Productions Work\\Ben Projects\\ServerPropertiesGenerator\\src\\com\\Generator\\output\\SP.java";
	final static Charset ENCODING = StandardCharsets.UTF_8;






	public static  List<String> read() throws IOException {
		Path path = Paths.get(FILE_NAME);
		return Files.readAllLines(path, ENCODING);
	}


	public static List<String> process(List<String> rawData){

		ArrayList<String> javaLines = new ArrayList<String>();
		
		javaLines.add("public class SP{");
		javaLines.add("public final static class "+rawData.get(0).split("[.]")[0]+"{}");//firs group
		
		for(int i=1; i<rawData.size();i++){

			String[] pieces = rawData.get(i).split("[.]");
			String[] prevPiece = rawData.get(i-1).split("[.]");

			if(!"".equals(pieces[0])){
				if(!pieces[0].equals(prevPiece[0])){
					javaLines.add("public final static class "+pieces[0]+"{}");//JUNK INSIDE ()
				}
			}


			//			for(int i=0; i<pieces.length; i++){
			//				if(i==pieces.length){
			//					String[] lastPiece = s.split("[=]");
			//					
			//				}else{
			//					
			//				}
			//				
			//			}
		}
		javaLines.add("}");


		return javaLines;
	}

	static void  writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		Files.write(path, aLines, ENCODING);
	}
}