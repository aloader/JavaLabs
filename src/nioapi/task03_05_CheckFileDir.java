/*
Проверить, есть ли файл по заданному пути
Проверить, файл или папка расположен по заданному пути?
Получить размер файла в килобайтах
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

@LabAnnotation(
        number = "03-05",
        text = "3.Проверить, есть ли файл по заданному пути.\n" +
                "4. Проверить, файл или папка расположен по заданному пути?\n" +
                "5.Получить размер файла в килобайтах.")
public class task03_05_CheckFileDir extends task {
    public task03_05_CheckFileDir() {
        super();

        String path = "./res";
        String file1 = "1.txt";
        String file2 = "2.txt";
        try {
            System.out.println();
            isExist(FileSystems.getDefault().getPath(path, file1));
            System.out.println();
            isExist(FileSystems.getDefault().getPath(path, file2));
            System.out.println();
            isExist(FileSystems.getDefault().getPath(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist(Path path) throws IOException {
        if (path==null) throw new IOException();
        boolean result=false;
        String objectStr = "the object \""+path.toString() + "\"";
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            if (Files.isDirectory(path)) {
                System.out.println(objectStr+" is a directory.");
            } else {
                System.out.println(objectStr+" is a file.");
                System.out.println("size of the file is: " + Files.size(path) + " kb.");
            }
            result = true;
        } else System.out.println(objectStr + " not found.");
        return result;
    };
}
