package com.bptn.utils;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Main {

    public static void main(String[] args) {
        // Check if the file exists
        boolean fileExist = FileUtils.isFileExist();
        System.out.println("File exists: " + fileExist);

        // Try to read the file and handle any exceptions
        FileUtils.isFileExistsWithExceptionHandling();

        // Create the file if it does not exist
        boolean fileCreated = FileUtils.createFileIfNotExist();
        System.out.println("File created: " + fileCreated);
    }

    public class FileUtilsTest {

        public static void main(String[] args) throws IOException {

            FileUtils fileUtils = null;
            String home = System.getProperty("user.home");
            Path p = Paths.get(home + "/test.txt");

            if (fileUtils == null) {
                fileUtils = new FileUtils();
            }

            FileUtils.deleteFile(p);
            FileUtils.createFileIfNotExist();
            System.out.println("File exists: " + FileUtils.isFileExist());
            FileUtils.isFileExistsWithExceptionHandling();
            FileUtils.writeFile(p);
            FileUtils.updateFile(p);
            FileUtils.readFile(p);
        }
    }


    
}





