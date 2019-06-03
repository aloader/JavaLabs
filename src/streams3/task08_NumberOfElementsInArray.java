/*
Посчитать количество элементов в массиве.
 */
package streams3;
import utils.*;

import java.util.Arrays;
import java.util.stream.Stream;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "08",
        text = "Посчитать количество элементов в массиве.")
public class task08_NumberOfElementsInArray extends task {
    public task08_NumberOfElementsInArray() {
        super();

        Integer[] arr = createIntegerArray();
        System.out.println("array: " + Arrays.asList(arr));
        System.out.println("number of elements: " +
                Stream.of(arr)
                    .count()
                );
    }
}
