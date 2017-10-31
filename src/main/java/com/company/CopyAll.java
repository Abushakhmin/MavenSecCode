package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class CopyAll {

    static void onCopyAll(String arg1, String arg2) throws IOException {

        File put1 = new File(arg1);
        File put2 = new File(arg2);

        if (put1.isDirectory()) {  // Это директория или файл
            if (!put2.exists()) {  // Если такой нет то создадим ее
                put2.mkdir();

                String[] listOfFiles = put1.list(); // Наполним массив файлами

                for (int i = 0; i < listOfFiles.length; i++) { // Рекурсивно копируем файлы

                    onCopyAll(new File(put1, listOfFiles[i]).toString(), new File(put2, listOfFiles[i]).toString());
                }
            }
            else
            { // Директория уже существует, применяем потоки
                InputStream in = new FileInputStream(put1);
                OutputStream out = new FileOutputStream(put2);

                byte[] buf = new byte[1024];
                int len;

                while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
                }

                in.close();
                out.close();
            }
        } else if (put1.exists()) // Если файл существует
        {
            if (put1.canRead()) // Если есть доступ к файлу
            {
                Path source = Paths.get(arg1);
                Path target = Paths.get(arg2);

                try {
                    // скопировать файл, если файл уже существует, то перезаписать его
                    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(source + " - Файл скопирован по аресу: " + target);

                }

                catch (InvalidClassException e) {
                    System.out.println("Ошибка указания пути " + e);
                }

                catch (IOException e) {
                    System.out.println("Ошибка ввода вывода " + e);
                }
            }
            else
            {
                System.out.println("Нет доступа к файлу: " + put1.getName());
            }
        }
        else
        {
            System.out.println(put1.getName() + "- Файл не существует, либо ошибка в указании пути: " + put1.getParent());
        }
    }
}
