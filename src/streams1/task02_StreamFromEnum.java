/*
 Создание стрима перечислением
 Пример входа                      Пример выхода
 “a1”,”a2”,”a3”                    [“a1”,”a2”,”a3”]
*/
package streams1;

import utils.LabAnnotation;
import utils.task;

import java.util.stream.Stream;

@LabAnnotation(
        number = "02",
        text = "Создание стрима перечислением.")
public class task02_StreamFromEnum extends task {
    public task02_StreamFromEnum() {

        Stream.of("a1", "a2", "a3", "a4")
                .forEach((x)->{
                    System.out.print(x + ",");
                });
        System.out.println();
    }

}
