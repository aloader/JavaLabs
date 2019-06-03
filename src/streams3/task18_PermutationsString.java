/*
Дан массив строк. Вернуть массив всех возможных комбинаций.
 */
package streams3;
import utils.*;

import java.util.*;
import java.util.stream.Collectors;

@LabAnnotation(
        number = "18",
        text = "Дан массив уникальных символов. Вернуть строку, являющуюся \n" +
                "конкатенацией всех возможных вариантов перестановок для массива.")
public class task18_PermutationsString extends task {
    public task18_PermutationsString() {
        super();

        String[] strArrIn = {"A", "B", "C"};
        System.out.println("in array: " + Arrays.asList(strArrIn));
        String perm = Permutations.getPermutations(strArrIn).stream()
                .flatMap(strArr->strArr.stream())
                .collect(Collectors.joining());
        System.out.println("result: " + perm);

    }
}
