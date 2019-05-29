/*
Дан текстовый файл по пути ./payload/java8/stream/wordCount.txt.
Вернут стрим со словами, отсортированными по частоте встречи по убыванию.
 */
package streams3;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@LabAnnotation(
    number = "03",
    text = "Дан текстовый файл по пути ./payload/java8/stream/wordCount.txt.\n" +
            "Вернут стрим со словами, отсортированными по частоте встречи по убыванию.")
public class task03 extends task {
    public task03() {

        String wordCount = "./res/payload/java8/stream/wordCount.txt";
//        String wordCount = "./res/payload/java8/stream/File_id.diz";

        try {
            Stream<String> finalStream = Files.lines(Paths.get(wordCount))
                .flatMap(s -> {
                    String[] wordsArray = s.split("[\\s\\p{Punct}]");
                    return Stream.of(wordsArray);
                })
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1,o2)->{
                    long v1, v2;
                    v1 = o1.getValue();
                    v2 = o2.getValue();
                    return v1==v2? 0: (v1<v2? -1: 1);
                })
                .map(o->{return o.getKey();});

            System.out.println("result: "+ finalStream.collect(Collectors.toList()));


        } catch (IOException e) {
            System.out.println("error reading file " + wordCount + "!");
        }
    }
}
