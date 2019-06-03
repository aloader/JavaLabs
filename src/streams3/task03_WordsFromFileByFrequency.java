/*
Дан текстовый файл по пути ./payload/java8/stream/wordCount.txt.
Вернут стрим со словами, отсортированными по частоте встречи по убыванию.
 */
package streams3;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Constants.WORDSPLITTER;

@LabAnnotation(
    number = "03",
    text = "Дан текстовый файл по пути ./payload/java8/stream/wordCount.txt.\n" +
            "Вернут стрим со словами, отсортированными по частоте встречи по убыванию.")
public class task03_WordsFromFileByFrequency extends task {
    public task03_WordsFromFileByFrequency() {
        super();
        String wordCount = "./res/payload/java8/stream/wordCount.txt";
//        String wordCount = "./res/payload/java8/stream/File_id.diz";

        try {
            Stream<String> finalStream = Files.lines(Paths.get(wordCount))
                .flatMap(s -> {
                    String[] wordsArray = s.split(WORDSPLITTER);
                    return Stream.of(wordsArray);
                })
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1,o2)->o1.getValue().compareTo(o2.getValue()))
                .map(o->o.getKey());

            System.out.println("result: "+ finalStream.collect(Collectors.toList()));


        } catch (IOException e) {
            System.out.println("error reading file " + wordCount + "!");
        }
    }
}
