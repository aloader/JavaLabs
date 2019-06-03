/*
 Применить к каждому элементу массива заданную функцию.
 */
package streams3;
import utils.*;

import java.util.Arrays;
import java.util.function.Function;

import static utils.CreateIntegerArray.createIntegerArray;

@LabAnnotation(
        number = "21",
        text = " Применить к каждому элементу массива заданную функцию.")
public class task21_DoFunctionToArrayElements extends task {
    public task21_DoFunctionToArrayElements() {
        super();

        Integer[] arr = createIntegerArray();
        System.out.println("array: " + Arrays.asList(arr));

        Function<Integer, Integer> f = x->x+1;

        Integer fx = Arrays.stream(arr)
                .reduce(0, (accumulator, x)->accumulator+f.apply(x));

        System.out.println("result: "+ fx);
    }
}
