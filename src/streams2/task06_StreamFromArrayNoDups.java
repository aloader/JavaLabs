/*
Верните стрим из массива, исключив дубликаты
Пример входа                    Пример выхода
[1,1,3,4,3,6,7,8]               [1,3,4,6,7,8]
 */
package streams2;
import utils.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "06",
        text = "Верните стрим из массива, исключив дубликаты.")
public class task06_StreamFromArrayNoDups extends task {

    public task06_StreamFromArrayNoDups() {

        Integer[] Arr = createIntegerArray();
        System.out.println("\narray in: " + Arrays.toString(Arr));

        Stream<Integer> streamOut = Arrays.stream(Arr).distinct();

        System.out.println("result: " + streamOut.collect(Collectors.toList()));
    }
}
