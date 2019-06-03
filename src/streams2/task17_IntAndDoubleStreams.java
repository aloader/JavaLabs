/*
Создайте натуральный стрим для целых чисел,
для чисел с плавающей точкой двойной точности
 */
package streams2;
import utils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

@LabAnnotation(
        number = "17",
        text = "Создайте натуральный стрим для целых чисел,\n" +
                "для чисел с плавающей точкой двойной точности.")
public class task17_IntAndDoubleStreams extends task {
    public task17_IntAndDoubleStreams(){
        super();

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println("IntStream:");
        intStream.forEach(i->System.out.print(i+" "));

        DoubleStream doubleStream = DoubleStream.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d);
        System.out.println("\nDoubleStream:");
        doubleStream.forEach(i->System.out.print(i+" "));

    }
}
