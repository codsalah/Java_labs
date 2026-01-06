package com.example.Java2Lab_01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Files_io {
    public static void main(String[] args) {
        Path file1 = Paths.get("src/main/java/com/example/Java2Lab_01/text1.text");
        Path file2 = Paths.get("src/main/java/com/example/Java2Lab_01/text2.text");
        Path outputFile = Paths.get("src/main/java/com/example/Java2Lab_01/output.text");

        try {
            if (Files.exists(file1) && Files.exists(file2)) {
                String content1 = Files.readString(file1);
                String content2 = Files.readString(file2);

                Files.writeString(outputFile, content1 + System.lineSeparator() + content2);
                System.out.println("Files merged successfully into " + outputFile.toAbsolutePath());
            } else {
                System.err.println("One or more input files not found.");
                if (!Files.exists(file1)) System.err.println("Missing: " + file1.toAbsolutePath());
                if (!Files.exists(file2)) System.err.println("Missing: " + file2.toAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}