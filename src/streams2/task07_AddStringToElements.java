/*
Добавьте к каждой строке массива “_outdated”

Пример входа                        Пример выхода
[“log1”,”log2”,”log3”]              [“log1_outdated”,”log2_outdated”,”log3_outdated”]

 */
package streams2;
import utils.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@LabAnnotation(
        number = "07",
        text = "Добавьте к каждой строке массива \"_outdated\".")
public class task07_AddStringToElements extends task {
    public task07_AddStringToElements() {

        String[] strArr = {"log1", "log2", "log3", "log4"};
        System.out.println("in: " +Arrays.toString(strArr));
        Stream<String> streamString = Arrays.stream(strArr)
                .map((String s)-> {return s.concat("_outdated");});
        System.out.println("result: " + streamString.collect(Collectors.toList()));
    }
}
