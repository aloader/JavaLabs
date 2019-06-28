/*
Записать в массив первые три строки из файла
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
        number = "10",
        text = "Записать в массив первые три строки из файла.")
public class task10_First3StrFromFile extends task {
    public task10_First3StrFromFile() {
        super();
        Path filePath = null;
        ArrayList<String> strArr = null;
        try {
            filePath = Paths.get("./res", "2.txt");
            try (Stream<String> strStream = Files.lines(filePath)) {
                System.out.println("file: " + filePath.toString());
                strArr = strStream
                        .limit(3)
                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                System.out.println("first 3 strings from the file: " + strArr.toString());
            } catch (IOException e) {
                System.out.println("error reading file \""+filePath+"\".");
            }
        } catch (InvalidPathException e){
            System.out.println("Path file error \""+(filePath!=null? filePath.toString(): "")+"\"");
        }
    }
}
