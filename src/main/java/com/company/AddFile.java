// Работает :)

package com.company;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class AddFile {

    static void onAddFile(String arg1) {

        Path path = Paths.get(arg1);

        try {
            Files.createFile(path);

            System.out.println("Создан файл: " + path.getFileName() + "\n");
        }

        catch (FileAlreadyExistsException e){ // Каталог уже существует
            System.out.println("Внимание: Данный файл уже существует\n");
        }

        catch (IOException e) {
            System.out.println("--------Сработало общее исключение:\n");

            e.printStackTrace();

            System.out.println("\n--------Указан не корректный путь или имя файла, либо не достаточно прав для создания файла\n");
        }
    }
}
