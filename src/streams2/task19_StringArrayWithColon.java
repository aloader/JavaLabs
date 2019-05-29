/*
Дан массив строк по шаблону: <text>:<text>:<text>:…:<text>. Вернуть массив элементов <text>
Пример входа                            Пример выхода
[“1:2:3:”,”foo:bar”]                    [“1”,”2”,”3”,””,”foo”,”bar”]
 */
package streams2;
import com.sun.org.apache.bcel.internal.classfile.ConstantLong;
import utils.*;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Constants.COLON;

@LabAnnotation(
        number = "19",
        text = "Дан массив строк по шаблону: <text>:<text>:<text>:…:<text>. Вернуть массив элементов <text>.")
public class task19 extends task {
    public task19() {
        super();

        String[] strArr = {"1:2:3:","foo:bar", "gg:", ":kk", "jjj"};
        System.out.println("String Array: " + Arrays.toString(strArr));

        Stream<String> strStream = Arrays.stream(strArr)
                .flatMap(s->{
                    int pos=0, prev=0;
                    String subStr;
                    Stream.Builder<String> streamBuider = Stream.<String>builder();

                    do {
                        pos = s.indexOf(COLON, prev);
                        subStr = s.substring(prev, (pos==-1? s.length(): pos));
                        streamBuider.add(subStr);
                        prev = pos + 1;
                    } while (pos>=0 & prev>0);
                    return streamBuider.build();
                });

        System.out.println("result: "+ strStream.collect(Collectors.toList()));
    }
}
