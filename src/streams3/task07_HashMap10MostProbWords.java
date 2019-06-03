/*
Дан текстовый файл по пути ./payload/java8/stream/wordCount.txt.
Вернуть HashMap, где ключ – слово, а значение – вероятность встречи слова в тексте.
HashMap должен хранить только 10 самых частых слов
 */
package streams3;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Constants.WORDSPLITTER;

@LabAnnotation(
        number = "07",
        text = "Дан текстовый файл по пути ./payload/java8/stream/wordCount.txt.\n" +
                "Вернуть HashMap, где ключ – слово, а значение – вероятность встречи слова в тексте.\n" +
                "HashMap должен хранить только 10 самых частых слов.")
public class task07_HashMap10MostProbWords extends task {
    public task07_HashMap10MostProbWords() {
        super();
        String wordCount = "./res/payload/java8/stream/wordCount.txt";
        AtomicLong WordsCnt=new AtomicLong();
        try {
            HashMap<String, Long> wordsAllFrequency = new HashMap<String, Long>(Files.lines(Paths.get(wordCount))
                    .flatMap(s -> {
                        String[] wordsArray = s.split(WORDSPLITTER);
                        return Stream.of(wordsArray);
                    })
                    .filter(s->{
                        WordsCnt.incrementAndGet();
                        return true;
                    })
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting())));
            System.out.println("\nall words hashmap: \n" + wordsAllFrequency);

            HashMap<String, Double> words10Frequency = new HashMap<String, Double>(wordsAllFrequency
                    .entrySet()
                    .stream()
                    .sorted((o1,o2)-> o2.getValue().compareTo(o1.getValue()))
                    .limit(10)
                    .collect(Collectors.toMap(o-> {return o.getKey();},
                            o->{return (double)o.getValue()/WordsCnt.get();})
                    ));
            System.out.println("\nresult: \n" + words10Frequency);

        } catch (IOException e) {
            System.out.println("error reading file "+ wordCount+".");
        }
    }
}
