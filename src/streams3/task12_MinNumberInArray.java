/*
Дан массив. Найти минимальное число.
 */
package streams3;
import utils.*;

import java.util.Arrays;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "11",
        text = "Дан массив. Найти минимальное число.")
public class task12_MinNumberInArray extends task  {
    public task12_MinNumberInArray() {
        super();

        Integer[] arr = createIntegerArray();
        System.out.println("array: " + Arrays.asList(arr));
        System.out.println("min number: " + Arrays.stream(arr)
            .min((x1,x2)->{
                return x1.compareTo(x2);
            }).get());

    }
}
