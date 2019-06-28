/*
Сымитировать ошибку в процессе чтения файла (выбросить исключение).
Корректно освободить все ресурсы.
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

@LabAnnotation(
        number = "08",
        text = "Сымитировать ошибку в процессе чтения файла (выбросить исключение). \n" +
                "Корректно освободить все ресурсы.")
public class task08_ExceptionInFileProceeding extends task {
    public task08_ExceptionInFileProceeding() throws FileContentException {
        super();
        Path filePath = null;
        ArrayList<String> strArr = null;
        try {
            filePath = Paths.get("./res", "1.txt");
        } catch (InvalidPathException e){
            System.out.println("Path file error \""+filePath+"\"");
        }
        try (Stream<String> strStream = Files.lines(filePath)) {
            strArr = strStream
                    .peek(s->{
                        if (s.equals("2")){
                            System.out.println(s.length()/0);
                        }
                    })
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        } catch (IOException e) {
            System.out.println("Error opening file \"" + filePath + "\"!");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero!");
        }
        if (strArr!=null) System.out.println("string array: " + strArr.toString());
    }

    public static <T> Consumer<T> throwingConsumer(Consumer<T> consumer) {
        return f->{
            try {
                consumer.accept(f);
            } catch (Exception ex) {
                throw ex;
            }
        };
    }
}
