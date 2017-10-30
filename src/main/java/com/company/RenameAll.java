package com.company;

import java.io.IOException;
import java.io.InvalidClassException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class RenameAll {

    static void onRenameAll(String arg1, String arg2){
        try {

            //Path source = Paths.get(arg1);
            //Path target = Paths.get(arg2);

            CopyAll.onCopyAll(arg1, arg2);

            // переместить\вырезать файл
            //Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

            DeleteAll.onDeleteAll(String.valueOf(arg1));

        }
        // Исключения
        catch (InvalidClassException e) {
            System.out.println("Ошибка указания пути " + e);
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода вывода " + e);
        }
    }
}
