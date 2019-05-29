/*
Верните отсортированный стрим в порядке убывания
Пример входа                    Пример выхода
[1,2,3,4,5,6,7,8]               [8,7,6,5,4,3,2,1]
 */
package streams2;

import utils.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "13",
        text = "Верните отсортированный стрим в порядке убывания.")
public class task13_ArrayInDescendingOrder extends task {
    public task13_ArrayInDescendingOrder() {

        Integer[] Arr = createIntegerArray();
        System.out.println("\narray in: " + Arrays.toString(Arr));

        Stream<Integer> streamInteger = Stream.of(Arr)
                .sorted((x1, x2)->{
                    return (x1==x2)? 0: ((x1<x2)? 1: -1);
                });

        System.out.println("result: "+streamInteger.collect(Collectors.toList()));
    }
}
