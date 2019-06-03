/*
22. Дан массив строк. Некоторые элементы могут содержать целочисленные или вещественные числа.
Необходимо вернуть примитимный стрим целых чисел ( вещественные необходимо округлить вниз)

Пример входа                    Пример выхода
[“A”,”B123”,”11”,”231.62”]      [11,231]
 */
package streams3;
import utils.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@LabAnnotation(
        number = "22",
        text = "Дан массив строк. Некоторые элементы могут содержать целочисленные или вещественные числа.\n" +
                "Необходимо вернуть примитимный стрим целых чисел ( вещественные необходимо округлить вниз).")
public class task22_IntStreamFromStringArray extends task {
    public task22_IntStreamFromStringArray() {
        super();

        String[] strArr = {"A", "B132", "11g sadf _2@#%$ 12.36AAA", "231.62"};
        Pattern pattern = Pattern.compile("[0-9]*[.,]?[0-9]+");
        IntStream intStr = Arrays.stream(strArr)
                .flatMapToInt(s->{
                    Matcher matcher = pattern.matcher(s);
                    IntStream.Builder sb = IntStream.builder();
                    while (matcher.find()) {
                        sb.add(Math.round(Float.parseFloat(s.substring(matcher.start(), matcher.end()))));
                    }
                    return sb.build();
                });
        System.out.println("result: ");
        intStr.forEach(x-> {
            System.out.print(" "+x);
        });
    }
}
