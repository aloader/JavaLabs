/*
Дан текстовый файл по пути ./payload/java8/stream/wordCount.txt.
Вернуть HashMap, где ключ – слово, а значение – количество встреч слова в тексте.
HashMap должен хранить только 10 самых частых слов
 */
package streams3;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Constants.WORDSPLITTER;

@LabAnnotation(
        number = "06",
        text = "Дан текстовый файл по пути ./payload/java8/stream/wordCount.txt.\n" +
                "Вернуть HashMap, где ключ – слово, а значение – количество встреч слова в тексте.\n" +
                "HashMap должен хранить только 10 самых частых слов.")
public class task06_HashMap10MostFreqWords extends task {
    public task06_HashMap10MostFreqWords() {
        super();

        String wordCount = "./res/payload/java8/stream/wordCount.txt";

        try {
            HashMap<String, Long> wordsAllFrequency = new HashMap<String, Long> (Files.lines(Paths.get(wordCount))
                    .flatMap(s -> {
                        String[] wordsArray = s.split(WORDSPLITTER);
                        return Stream.of(wordsArray);
                    })
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting())));
            System.out.println("\nall words hashmap: \n"+wordsAllFrequency);

            HashMap<String, Long> words10Frequency = wordsAllFrequency
                    .entrySet()
                    .stream()
                    .sorted((o1,o2)-> o2.getValue().compareTo(o1.getValue()))
                    .limit(10)
                    .collect(HashMap::new, (hm, o)->hm.put(o.getKey(), o.getValue()), HashMap::putAll);

            System.out.println("\nresult: \n" + words10Frequency);


        } catch (IOException e) {
            System.out.println("error reading file "+ wordCount+".");
        }
    }
}
