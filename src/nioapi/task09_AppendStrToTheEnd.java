/*
Добавить строку в конец файла
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;

@LabAnnotation(
        number = "09",
        text = "Добавить строку в конец файла")
public class task09_AppendStrToTheEnd extends task {
    public task09_AppendStrToTheEnd() {
        super();

        Path filePath = null;
        String str = null;
        try {
            filePath = Paths.get("./res", "2.txt");
        } catch (InvalidPathException e){
            System.out.println("Path file error \""+filePath+"\"");
        }
        try {
            System.out.println("file: \""+filePath+"\"");
            str = Double.toString(Math.random());
            System.out.println("add string \""+str+"\" to the end of file.");
            Files.write(filePath, Collections.singleton(str),StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error writing file \"" + filePath + "\"!");
        }
    }
}
