/*
Верните стрим, состоящий только из второй половины элементов входного массива
Пример входа                        Пример выхода
[1,2,3,4,5,6,7,8]                   [5,6,7,8]

 */
package streams2;

import utils.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static utils.CreateIntegerArray.*;

@LabAnnotation(
        number = "04",
        text = "Верните стрим, состоящий только из второй половины элементов входного массива.")
public class task04_SecondHalfArray extends task {

    public task04_SecondHalfArray() {

        Integer[] Arr = createIntegerArray();
        System.out.println("\narray in: " + Arrays.toString(Arr));

        // тема - конвейерные методы стрима.поэтому не прерывая стрим, невозможно узнать
        // размер массива, который выдает стрим. Поэтому, зная размер входного массива,
        // пропускаем первую половину его элементов элементов
        Stream<Integer> streamFromArray = Arrays.stream(Arr)
                .skip((long)Arr.length/2);
        System.out.println("array send: " + streamFromArray.collect(Collectors.toList()));
    }
}
