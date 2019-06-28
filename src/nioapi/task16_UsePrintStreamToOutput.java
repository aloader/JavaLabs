/*
Использовать PrintStream для вывода в файл
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@LabAnnotation(
        number = "16",
        text = "Использовать PrintStream для вывода в файл.")
public class task16_UsePrintStreamToOutput extends task {
    public task16_UsePrintStreamToOutput() {
        super();

        String fileNameOut = "./res/3.txt";
        String fileNameIn = "./res/2.txt";
        try (Stream<String> strStream = Files.lines(Paths.get(fileNameIn));
                PrintStream printStream = new PrintStream(fileNameOut)) {
            System.out.println("transfer context of the file "+fileNameIn + "\n"+
                    "to the file "+ fileNameOut + " using PrintStream.");
            strStream.forEach(printStream::println);
            if (printStream.checkError()) {
                System.out.println("there is a error during transferring! check the files!");
            }
        } catch (IOException e) {
            System.out.println("file write error!");
            e.printStackTrace();
        }
    }
}
