/*
18. Дан массив уникальных символов.
Вернуть строку, являющуюся конкатенацией всех возможных вариантов перестановок для массива.
Пример входа                        Пример выхода
[“A”,”B”,”C”]                       ABC ACB BAC BCA CAB CBA
 */
package streams3;
import utils.*;

import java.util.ArrayList;
import java.util.Arrays;


@LabAnnotation(
        number = "17",
        text = "Дан массив строк. Вернуть массив всех возможных комбинаций.")
public class task17_PermutationsArray extends task {
    public task17_PermutationsArray() {
        super();

        String[] strArrIn = {"str1", "str2", "str3"};

        System.out.println("in array: " + Arrays.asList(strArrIn));

        ArrayList<ArrayList<String>> perm =
                Permutations.getPermutations(strArrIn).stream()
                .collect(ArrayList::new, (al, el)->al.add(el), ArrayList::addAll);
        System.out.println("result: " + perm);

    }
}
