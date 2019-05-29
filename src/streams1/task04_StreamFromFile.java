/*
 Создание стрима из файла
 Пример входа                      Пример выхода
 “./payload/java8/stream/1.txt”     [“1”,”2”,”3”,”4”]

*/
package streams1;

import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@LabAnnotation(
        number = "04",
        text = "Создание стрима из файла.")
public class task04_StreamFromFile extends task {
    public task04_StreamFromFile() throws IOException {

        Stream<String> streamFromFile = Files.lines(Paths.get("res/1.txt"));
        streamFromFile
                .forEach((x)->{
                    System.out.print(x + ",");
                });
        System.out.println();
    }

}
