/*
Создайте класс с полями id типа Long, name типа String, date типа LocalDate.
Верните отсортированный стрим.
Правило сортировки:
- Сначала по полю LocalDate по убыванию,
- затем по полю id по возрастанию,
- затем по полю name в алфавитном порядке.
Использование циклов и условных
операторов допускается только в компараторе.
 */
package streams2;
import utils.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@LabAnnotation(
        number = "14",
        text = "Создайте класс с полями id типа Long, name типа String, date типа LocalDate.\n" +
                "Верните отсортированный стрим.")
public class task14_ObjectsSortWithComparator extends task {
    public task14_ObjectsSortWithComparator() {

        List<ClassT14> listClassT14 = Arrays.asList(
                new ClassT14(169, "object134", LocalDate.of(2021,07,14)),
                new ClassT14(796, "object001", LocalDate.of(1996,12,31)),
                new ClassT14(80, "hashmap14", LocalDate.of(2012,04,03)),
                new ClassT14(11, "_fedya_6", LocalDate.of(2009,01,02)),
                new ClassT14(4, "cementM500", LocalDate.of(2019,05,15))
        );
        System.out.println("\nList of objects: \n" + listClassT14);

        Stream<ClassT14> streamClassT14 = listClassT14.stream()
                .sorted( (o1, o2) -> {
                   return (o1.Date.isEqual(o2.Date)? 0:
                           (o1.Date.isBefore(o2.Date))? 1: -1);
                });
        System.out.println("\n\norder \"Date descending\": \n"+streamClassT14.collect(Collectors.toList()));

        streamClassT14 = listClassT14.stream()
                .sorted( (o1, o2) -> {
                    return (o1.Id == o2.Id)? 0:
                            ((o1.Id < o2.Id)? -1: 1);
                });
        System.out.println("\n\norder \"Id ascending\": \n"+streamClassT14.collect(Collectors.toList()));

        streamClassT14 = listClassT14.stream()
                .sorted( (o1, o2) -> {
                    return (o1.Name.compareTo(o2.Name));
                });
        System.out.println("\n\norder \"Name ABC-order\": \n"+streamClassT14.collect(Collectors.toList()));

    }
}
