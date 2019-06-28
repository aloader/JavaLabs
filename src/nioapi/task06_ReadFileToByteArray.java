/*
Прочитать файл в массив байт
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

@LabAnnotation(
        number = "06",
        text = "Прочитать файл в массив байт.")
public class task06_ReadFileToByteArray extends task {
    public task06_ReadFileToByteArray() {
        super();
        Path filePath = null;
        byte[] byteArr=null;

        try {
            filePath = Paths.get("./res", "1.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path file error!");
            return;
        }
        System.out.println("file: " + filePath.toString());
        try {
            byteArr = Files.readAllBytes(filePath);
        } catch (IOException e) {
            System.out.println("Error opening file \""+filePath+"\"!");
        } catch (SecurityException e) {
            System.out.println("Security error in file \""+filePath+"\"!");
        }
        System.out.println("byte buffer: " + Arrays.toString(byteArr));
    }
}
