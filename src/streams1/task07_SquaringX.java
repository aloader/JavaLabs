/*
Создание бесконечного стрима, который возводит каждое предыдущее значение в квадрат
Пример входа                    Пример выхода
2                               [“2”,”4”,”16”,”256”, …]
1                               [“1”,”1”,”1”,”1”,“1”, …]
 */
package streams1;

import utils.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@LabAnnotation(
        number = "07",
        text = "Создание бесконечного стрима, который возводит \nкаждое предыдущее значение в квадрат.")
public class task07_SquaringX extends task {

    public task07_SquaringX() {

        System.out.println("begin stream from 2, first 8 values!");
        Stream<Double> intStream = Stream.iterate(2D, (x)->x*x);
        List<Double> intList = intStream
                .limit(8)
                .collect(Collectors.toList());
        System.out.println("result: " + intList);

        System.out.println("begin stream from 1, first 8 values!");
        intStream = Stream.iterate(1D, (x)->x*x);
        intList = intStream
                .limit(8)
                .collect(Collectors.toList());
        System.out.println("result: " + intList);

    }
}
