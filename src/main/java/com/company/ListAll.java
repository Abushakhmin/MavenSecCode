package com.company;

import java.io.IOException;
import java.nio.file.*;

class ListAll {


    static void onListAll(String arg1){

    try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(arg1))) {
            for (Path file: stream) {
                if(!file.toFile().isDirectory() ) {
                    System.out.println(file.getFileName());
                }
            }
        } catch (IOException | DirectoryIteratorException x) {
                System.err.println(x);
        }
    }
}
