/*
Прочитать файл в массив строк
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

@LabAnnotation(
        number = "07",
        text = "Прочитать файл в массив строк.")
public class task07_ReadFileToStringArray extends task {
    public task07_ReadFileToStringArray() {
        super();
        Path filePath = null;
        ArrayList<String> strArr = null;
        try {
            filePath = Paths.get("./res", "1.txt");
        } catch (InvalidPathException e){
            System.out.println("Path file error \""+filePath+"\"");
        }
        try (Stream<String> strStream = Files.lines(filePath)) {
            strArr = strStream
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        } catch (IOException e) {
            System.out.println("Error opening file \""+filePath+"\"!");
        }
        System.out.println("string array: " + strArr.toString());
    }
}
