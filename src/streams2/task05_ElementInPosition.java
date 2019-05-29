/*
Верните стрим, из одного элемента на заданной позиции.
В случае отсутствии такого  элемента верните 42.
Запрещено использовать условный оператор.

Пример входа                        Пример выхода
[1,2,3,4,5,6,7,8], 20               [42]
[1,2,3,4,5,6,7,8], 4                [5]
 */
package streams2;

import utils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.CreateIntegerArray.*;

@LabAnnotation(
        number = "05",
        text = "Верните стрим, из одного элемента на заданной позиции\n" +
                "В случае отсутствии такого  элемента верните 42\n" +
                "Запрещено использовать условный оператор.")
public class task05_ElementInPosition extends task {

    long ElCounter=0;
    long Pos;

    public task05_ElementInPosition() {

        Integer[] Arr = createIntegerArray();
        System.out.println("\narray in: " + Arrays.toString(Arr));

        Pos = 5;
        System.out.println("position: " + Pos);

        Stream<Integer> streamOut = Stream.concat(
                Arrays.stream(Arr).filter(x->++ElCounter == Pos),
                Stream.of((Integer)42)).limit(1);
        System.out.println("array out: " + streamOut.collect(Collectors.toList()));

        Pos = 20;
        System.out.println("position: " + Pos);
        streamOut = Stream.concat(
                Arrays.stream(Arr).filter(x->++ElCounter == Pos),
                Stream.of((Integer)42)).limit(1);
        System.out.println("array out: " + streamOut.collect(Collectors.toList()));
    }
}
