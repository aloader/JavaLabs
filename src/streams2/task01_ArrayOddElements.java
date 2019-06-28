/*
Отфильтровать массив, оставив только нечетные элементы.
Пример входа                            Пример выхода
[1,3,4,5,6,7,2,1,4] as ArrayList        [1,3,5,7,1]
 */
package streams2;
import utils.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@LabAnnotation(
    number = "01",
    text = "Отфильтровать массив, оставив только нечетные элементы.")
public class task01_ArrayOddElements extends task {
    public task01_ArrayOddElements() {

        Integer[] intArray = {1, 3, 4, 5, 6, 7, 2, 1, 4};
        System.out.println("Array in: " + Arrays.toString(intArray));
        List<Integer> intList = (List<Integer>) Arrays.stream(intArray)
            .filter((Integer x)->x%2!=0)
            .collect(Collectors.toList());
        System.out.println("Array send: " + intList);
    }
}
