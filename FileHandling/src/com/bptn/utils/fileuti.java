package com.bptn.utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class fileuti {
	
	public class Main {

		public static void main(String[] args) {
	        System.out.println("File exists: " + FileUtils.isFileExist());
	        FileUtils.isFileExistsWithExceptionHandling();
	        System.out.println("File created: " + FileUtils.createFileIfNotExist());
	    }
	}

    private static final String FILE_NAME = "test.txt";
    private static final String HOME = System.getProperty("user.home");

    public static boolean isFileExist() {
        Path path = Paths.get(HOME, FILE_NAME);
        return Files.exists(path);
    }

    public static void isFileExistsWithExceptionHandling() {
        Path path = Paths.get(HOME, FILE_NAME);
        try {
            byte[] content = Files.readAllBytes(path);
            System.out.println("File content: " + new String(content));
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    public static boolean createFileIfNotExist() {
        Path path = Paths.get(HOME, FILE_NAME);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                System.out.println("File created successfully");
                return true;
            } catch (IOException e) {
                System.out.println("Exception occurred: " + e.getMessage());
                return false;
            }
        } else {
            System.out.println("File already exists");
            return false;
        }
    }
}
