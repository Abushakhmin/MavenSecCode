package com.company;

import java.io.IOException;
import java.io.InvalidClassException;

class RenameAll {

    static void onRenameAll(String arg1, String arg2){
        try {

            CopyAll.onCopyAll(arg1, arg2);

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
