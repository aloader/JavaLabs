/*
Напечатать на консоль каждый элемент массива, используя Stream
 */
package streams2;
import utils.*;

import java.util.Arrays;
import java.util.stream.Stream;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "09",
        text = "Напечатать на консоль каждый элемент массива, используя Stream.")
public class task09_PrintArrayElements extends task {
    public task09_PrintArrayElements() {

        Integer[] Arr = createIntegerArray();
        System.out.println("print array elements with forEach:");
//        Arrays.stream(Arr)
//                .forEach(x-> System.send.println("el: "+ x));
        Stream.of(Arr)
                .forEach(x -> System.out.println("element: "+x));
    }
}
