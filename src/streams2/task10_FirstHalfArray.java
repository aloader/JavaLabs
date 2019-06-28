/*
Верните стрим, состоящий только из первой половины элементов входного массива
Пример входа                        Пример выхода
[1,2,3,4,5,6,7,8]                   [1,2,3,4]
 */
package streams2;
import utils.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "10",
        text = "Верните стрим, состоящий только из первой половины элементов входного массива.")
public class task10_FirstHalfArray extends task {
    public task10_FirstHalfArray() {
        super();

        Integer[] Arr = createIntegerArray();
        System.out.println("\narray in: " + Arrays.toString(Arr));

        Stream<Integer> streamFromArray = Arrays.stream(Arr)
                .limit((long)Arr.length/2);
        System.out.println("array send: " + streamFromArray.collect(Collectors.toList()));

    }
}
