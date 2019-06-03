/*
Дан массив. Найти максимальное число.
 */
package streams3;
import utils.*;

import java.util.Arrays;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "13",
        text = "Дан массив. Найти максимальное число.")
public class task13_MaxNumberInArray extends task {
    public task13_MaxNumberInArray() {
        super();

        Integer[] arr = createIntegerArray();
        System.out.println("array: " + Arrays.asList(arr));
        System.out.println("max number: " + Arrays.stream(arr)
                .max((x1,x2)->{
                    return x1.compareTo(x2);
                }).get());

    }
}