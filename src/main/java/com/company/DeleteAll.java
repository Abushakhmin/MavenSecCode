package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.io.*;

class DeleteAll {

    static void onDeleteAll(String arg1) {

        Path del = Paths.get(arg1);
        File put1 = new File(arg1);

        if (put1.isDirectory()){

            String [] files = put1.list();

            if((null == files) || (files.length == 0)) {
                put1.delete();
            }

            else {
                for (final String filename : files) {

                    onDeleteAll(new File(put1.getAbsolutePath() + File.separator + filename).toString());
                }
                put1.delete();
            }
        } else {

            try {
                Files.delete(del);

            } catch (NoSuchFileException x) {
                System.err.format("%s: no such" + " file or directory%n", del);
            } catch (DirectoryNotEmptyException x) {
                System.err.format("%s not empty%n", del);
            } catch (IOException x) {
                // File permission problems are caught here.
                System.err.println(x);
            }

        }

    }
}
