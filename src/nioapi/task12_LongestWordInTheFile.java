/*
Найти самое длинное слово в файле.
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Constants.WORDSPLITTER;

@LabAnnotation(
        number = "12",
        text = "Найти самое длинное слово в файле.")
public class task12_LongestWordInTheFile extends task {
    public task12_LongestWordInTheFile() {
        super();
        String fileName = "./res/payload/java8/stream/wordCount.txt";
//        String fileName = "./res/payload/java8/stream/File_id.diz";

        try (Stream<String> wordsFromFile = Files.lines(Paths.get(fileName))) {
            Map<String, Integer> longestWord = wordsFromFile
                .flatMap(s -> {
                    String[] wordsArray = s.split(WORDSPLITTER);
                    return Stream.of(wordsArray);
                })
                .collect(Collectors.toMap(s->s, s->s.length(),(s1,s2)->s1))
                .entrySet()
                .stream()
                .sorted((o1,o2)->o2.getValue().compareTo(o1.getValue()))
                .limit(1)
                .collect(Collectors.toMap(o->o.getKey(),o->o.getValue()));
            System.out.println("file: "+fileName);
            System.out.println("the longest word in the file: "+ longestWord);

        } catch (IOException e) {
            System.out.println("error reading file " + fileName + "!");
        }
    }
}
