/*
Найти самое частое слово в файле.
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Constants.WORDSPLITTER;

@LabAnnotation(
        number = "13",
        text = "Найти самое частое слово в файле.")
public class task13_MostUsedWordInTheFile extends task {
    public task13_MostUsedWordInTheFile() {
        super();
        String fileName = "./res/payload/java8/stream/wordCount.txt";
//        String fileName = "./res/payload/java8/stream/File_id.diz";

        try (Stream<String> wordsFromFile = Files.lines(Paths.get(fileName))) {
            Map<String, Long> longestWord = wordsFromFile
                    .flatMap(s -> {
                        String[] wordsArray = s.split(WORDSPLITTER);
                        return Stream.of(wordsArray);
                    })
                    .collect(Collectors.groupingBy(s->s, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted((o1,o2)->o2.getValue().compareTo(o1.getValue()))
                    .filter(e->e.getKey().length()>0)
                    .limit(1)
                    .collect(Collectors.toMap(o->o.getKey(),o->o.getValue()));
            System.out.println("file: "+fileName);
            System.out.println("the most used word in the file: "+ longestWord);

        } catch (IOException e) {
            System.out.println("error reading file " + fileName + "!");
        }
    }
}
