package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.io.*;

class DeleteAll {

    static void onDeleteAll(String arg1) {

        Path del = Paths.get(arg1);
        File put1 = new File(arg1);

        if (put1.isDirectory()){ // Проверяем что хотим удалить, директорию или файл

            String [] files = put1.list(); // Набираем массив из файлов доступных в данной директории

            if((null == files) || (files.length == 0)) { // Если файлов нет, то удаляем директорию
                put1.delete();
            }

            else { // Если файлов нет то применяем рекурсивное удалние
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
