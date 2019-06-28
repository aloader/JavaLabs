/*
Дан массив строк по шаблону <префикс>_<число>. Отсортирвоат ьпо числу по убыванию,
исключить повторения (чисел). Вернуть стрим в формате <префикс>_<число>.
 */
package streams2;
import utils.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@LabAnnotation(
        number = "16",
        text = "Дан массив строк по шаблону <префикс>_<число>. Отсортирвоат ьпо числу по убыванию,\n" +
                "исключить повторения (чисел). Вернуть стрим в формате <префикс>_<число>.")
public class task16_SortStringByPrefix extends task{
    public task16_SortStringByPrefix() {

        String[] strArray = {
                "1-_15ty._1989",
                "[oOther]_1",
                "fG_DWORD_0",
                "Tisnding_20",
                "fmt-m or_21",
                "sghfdghd_0",
                "han@%^&@_34",
                "ftidule-_1515",
                "---Usua__1194",
                "---Possi_89",
                "0==mal-p_6",
                "tttltttt_1194",
                "1===r;pr_15"
        };
        System.out.println("\nString array <prefix>_<number>:\n" + Arrays.asList(strArray));

        // variant 1: remove duplicates with ".filter" and lambdas
        /*
        Supplier<Predicate<String>> noDupId = ()-> {
            AtomicInteger prevId = new AtomicInteger();
            AtomicBoolean first = new AtomicBoolean(true);
            return (String s)->{
                int id = parseId(s);
                if (first.get() ==true) {
                    prevId.set(id);
                    first.set(false);
                    return true;
                } else if (prevId.get() ==id) {
                    return false;
                } else {
                    prevId.set(id);
                    return true;
                }
            };
        };

        System.send.println("\nString array:\n" + strArray);
        Stream<String> streamString = Arrays.stream(strArray)
                .sorted((s1, s2)->{
                    int id1, id2;
                    id1 = Integer.parseInt(s1.substring(s1.lastIndexOf(UNDERLINE)+1));
                    id2 = Integer.parseInt(s2.substring(s2.lastIndexOf(UNDERLINE)+1));

                    return id1==id2? 0: id1<id2? -1: 1;
                })
                .filter(noDupId.get());
        */

        // variant 2: object with overriden methods "equals" and "hashmap" + standart stream
        // operation ".sort" and ".distinct"

        Stream<String> streamString = Arrays.stream(strArray)
                .map(s->{
                    return new StringWithId(s);
                })
                .distinct()
                .sorted((s1, s2)->{
                    return ((s1.iD == s2.iD)? 0: (s1.iD<s2.iD? -1: 1));
                })
                .map(o->o.sourceStr);

        System.out.println("\n\nresult, <number>-sorted, no duplicates: \n" +
                streamString.collect(Collectors.toList()));

    }
}
