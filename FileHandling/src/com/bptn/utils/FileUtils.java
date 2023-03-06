package com.bptn.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileUtils {

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

    static void readFile(Path p) {
        if (Files.exists(p)) {
            Scanner scanner;
            try {
                scanner = new Scanner(new File(p.toUri()));
                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    System.out.println("Data available in file: " + str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    static void deleteFile(Path p) throws IOException {

        System.out.println("Check if a file exists in folder: test.txt, " + Files.exists(p));

        Files.deleteIfExists(p);

        System.out.println("Check if a file exists in folder: test.txt, " + Files.exists(p));

    }

    static void writeFile(Path p) throws IOException {

        if (!Files.exists(p)) {
            Files.createFile(p);
        }

        try (FileWriter writer = new FileWriter(new File(p.toUri()))) {
            for (int i = 0; i < 10; i++) {
                writer.write("I love Coding\n");
            }
            System.out.println("File Written Successfully");
        }
    }

    static void updateFile(Path p) {

        String p1 = p.toString();

        File file = new File(p1);
        FileWriter fr;
        try {
            fr = new FileWriter(file, true);
            fr.write("Updated the file\n");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

