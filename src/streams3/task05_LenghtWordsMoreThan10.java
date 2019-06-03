/*
Дан список слов. Используя стрим вернуть список, из которого исключены слова длиннее заданного значения.
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
        number = "05",
        text = "Дан список слов. Используя стрим вернуть список, из которого исключены слова длиннее заданного значения.")
public class task05_LenghtWordsMoreThan10 extends task {
    public task05_LenghtWordsMoreThan10() {
        super();

        String wordCount = "./res/payload/java8/stream/File_id.diz";
        int lenghtFlt = 10;
        try {
            Stream<String> finalStream = Files.lines(Paths.get(wordCount))
                    .flatMap(s -> {
                        String[] wordsArray = s.split(WORDSPLITTER);
                        return Stream.of(wordsArray);
                    })
                    .distinct()
                    .filter(s -> s.length() > lenghtFlt);
            System.out.println("result, lenght of words>10: " + finalStream.collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("error reading file " + wordCount);
        }
    }
}
