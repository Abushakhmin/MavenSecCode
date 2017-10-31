package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int n = args.length; // Кол-во введенных аргументов

        if(n == 2 || n == 3) { // Продолжаем выполнение программы, если введено два или три аргумента

            if(n == 2) { // Если два аргумента, то проделываем действия на удаление, вывод списка, создание директории или файла

                switch(args[0]) {

                    case "rm": // удаление фдиректории или файла
                        System.out.println("Запуск удаления...");
                        DeleteAll.onDeleteAll(args[1]);
                        System.out.println("Аргумент: " + args[1] + " удален");
                        break;

                    case "ll": // Вывод списка из каталогов и файлов
                        System.out.println("Выводим список каталогов и файлов...");
                        ListAll.onListAll(args[1]);
                        System.out.println("Действие завершено");
                        break;

                    case "mkdir": // Создание директории
                        System.out.println("\nСоздаем директорию...\n");
                        AddDir.onAddDir(args[1]);
                        System.out.println("Действие завершено\n");
                        break;

                    case "file": // Создание файла
                        System.out.println("\nСоздаем файл...\n");
                        AddFile.onAddFile(args[1]);
                        System.out.println("Действие завершено\n");
                        break;

                    default:
                        System.out.println("Ошибка ввода команды!");
                }

            } else { //Если 3 аргумента, то проделываем действия на копирование или перемещение
                switch(args[0]) {

                    case "cp": // Копирование директориии или файла
                        System.out.println("Запуск копирования...");
                        CopyAll.onCopyAll(args[1], args[2]);
                        System.out.println("Процесс завершен");
                        break;

                    case "mv": // Переименование директории или файла
                        System.out.println("Запуск перемещения или переименования...");
                        RenameAll.onRenameAll(args[1], args[2]);
                        System.out.println("Итоговый результат: " + args[2]);
                        break;

                    default:
                        System.out.println("Ошибка ввода команды!");
                }
            }
        } else System.out.println("Ошибка ввода аргументов!"); // если аргументов не два и не три, то выводим ошибку
    }
}

