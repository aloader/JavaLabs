/*
Верните стрим, состоящий только из трети элементов по середине
Пример входа                        Пример выхода
[1,2,3,4,5,6,7,8,9]                 [4,5,6]
 */
package streams2;
import utils.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "11",
        text = "Верните стрим, состоящий только из трети элементов по середине.")
public class task11_ThirdPartArray extends task {
    public task11_ThirdPartArray() {
        super();

        Integer[] arr = createIntegerArray();
        System.out.println("\narray in: " + Arrays.toString(arr));

        int elN = (int)arr.length/3;

        Stream<Integer> streamFromArray = Arrays.stream(arr)
                .skip(elN)
                .limit(elN);
        System.out.println("array send: " + streamFromArray.collect(Collectors.toList()));

    }
}
