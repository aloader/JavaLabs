/*
Верните стрим, состоящий из двух элементов перед серединой
Пример входа                Пример выхода
[1,2,3,4,5,6,7,8]           [3,4]
 */
package streams2;
import utils.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "12",
        text = "Верните стрим, состоящий из двух элементов перед серединой.")
public class task12_TwoElementsArray extends task {
    public task12_TwoElementsArray() {
        super();

        Integer[] arr = createIntegerArray();
        System.out.println("\narray in: " + Arrays.toString(arr));

        int elN = (int)arr.length/2-2;

        Stream<Integer> streamFromArray = Arrays.stream(arr)
                .skip(elN)
                .limit(2);
        System.out.println("array send: " + streamFromArray.collect(Collectors.toList()));

    }
}
