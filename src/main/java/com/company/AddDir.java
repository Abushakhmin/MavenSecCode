// Работает :)

package com.company;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class AddDir {

    static void onAddDir(String arg1) {

        Path path = Paths.get(arg1);

        try {
            Files.createDirectory(path);

            System.out.println("Создана директория: " + path.getFileName() + "\n");
        }

        catch (FileAlreadyExistsException e){ // Каталог уже существует
            System.out.println("Внимание: Данный каталог уже существует\n");
        }

        catch (IOException e) {
            System.out.println("--------Сработало общее исключение:\n");

            e.printStackTrace();

            System.out.println("\n--------Указан не верный путь, либо не достаточно прав для создания директории\n");
        }
    }
}
