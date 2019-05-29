/*
Создание параллельного стрима
Пример входа                      Пример выхода
“1”,”2”,”3”                         [“1”,”2”,”3”]
*/
package streams1;

import utils.LabAnnotation;
import utils.task;

import java.util.stream.*;

@LabAnnotation(
        number = "06",
        text = "Создание параллельного стрима.")
public class task06_ParallelStream extends task {
    public task06_ParallelStream() {

        Stream<String> strStream = Stream.of("1", "2", "3");
        System.out.println("Stream.of(\"1\", \"2\", \"3\")");
        System.out.println("result: " +
            strStream
                .parallel()
                .collect(Collectors.toList()));
        System.out.println();
    }

}
