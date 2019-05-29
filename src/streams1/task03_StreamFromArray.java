package streams1;

import utils.LabAnnotation;
import utils.task;

import java.util.Arrays;
import java.util.stream.Stream;

@LabAnnotation(number = "03", text = "Создание стрима из массива.")
/*
Пример входа                        Пример выхода
{“a1”,”a2”,”a3”}                    [“a1”,”a2”,”a3”]
*/
public class task03_StreamFromArray extends task {
    public task03_StreamFromArray() {
        String[] strArr = {"a1", "a2", "a3", "a4", "a5"};

        Stream<String> strStream = Arrays.stream(strArr);
        strStream.forEach((x)-> System.out.print(x + ", "));
        System.out.println();

    }
}
