package com.bptn.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.UUID;


public class FileUtils {



		
	// System.out.println(home);

	static void isFileExist(Path p) {
		
		System.out.println(Files.exists(p));
		
	}

	static void isFileExistsWithExceptionHandling(Path p) {

		Scanner scanner;
		try {
			scanner = new Scanner(new File(p.toUri()));
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(p);

	}

	static void createFileIfNotExist(Path p2) throws IOException {

			if (!Files.exists(p2)) {
			Files.createFile(p2);
		}

		System.out.println(Files.exists(p2));
	}

	
	
	public static void main(String[] args) throws IOException {
		
		String home = System.getProperty("user.home");
		
		Path p = Paths.get(home + "/test.txt");
		
		
		createFileIfNotExist(p);
		isFileExist(p);
		
		isFileExistsWithExceptionHandling(p);
		
		
		

	}
}