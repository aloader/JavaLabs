/*
Создайте класс с полями name типа String, date типа  LocalDate.
Добавьте “_outdated” в случае если оно отсутсвует, перед расширением,
к name для объектов, у которых date менее текущей даты

Пример входа                                        Пример выхода
[{name:”1”,date:”03/11/2001”},                      [{name:”1_outdated”,date:”03/11/2001”},
{name:”1.txt”,date:”03/11/2001”},                   {name:”1_outdated.txt”,date:”03/11/2001”},
{name:”1_outdated.txt”, date:”03/11/2001”},         {name:”1_outdated.txt”,date:”03/11/2001”}
{name:”1”, date:”03/11/2021”}]                      {name:”1”, date:”03/11/2021”}]

 */
package streams2;
import utils.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// constants
import static utils.Constants.*;

@LabAnnotation(
        number = "08",
        text = "Создайте класс с полями name типа String, date типа  LocalDate.\n" +
                "Добавьте “_outdated” в случае если оно отсутсвует, перед расширением\n" +
                "для объектов, у которых date менее текущей даты")
public class task08_AddOutdated extends task {
    public task08_AddOutdated() {

        LocalDate currDate = LocalDate.now();

        List<FileAttrs> lstFilesAttrs = Arrays.asList(
            new FileAttrs("1", LocalDate.of(2001, 03,11)),
            new FileAttrs("1.txt", LocalDate.of(2001, 03,11)),
            new FileAttrs("1_outdated.txt", LocalDate.of(2001, 03,11)),
            new FileAttrs("1", LocalDate.of(2021, 03,11)));
        System.out.println("\nin array of attributes: \n" + lstFilesAttrs);

        Stream<FileAttrs> streamFileAttrs = lstFilesAttrs.stream()
            .filter(f-> f.date.isBefore(currDate) & f.name.indexOf(OUTDATED)<=0)
            .map((FileAttrs f)->{
                f.name = f.getFileName() + OUTDATED + DOT + f.getFileExtension();
                return f;
            });
        System.out.println("\n\nresult array: \n\n" + streamFileAttrs.collect(Collectors.toList()));
    }
}
