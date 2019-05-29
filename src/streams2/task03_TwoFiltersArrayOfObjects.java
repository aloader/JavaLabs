/*
К классу из предыдущего примера добавьте поле logged типа Boolean. Отфильтровать массив
объектов, оставив только созданные ранее заданной даты и с установленным полем logged в true.

Пример входа                                        Пример выхода
                                                    [{
                                                    firstName:”Ivan”, lastName:”Ivanow”,
                                                    createdAt:” 01/15/2019 05:17:53”,
                                                    logged: true
                                                    }]
 */
package streams2;
import utils.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.CreatePersons.createPersonsArrayList;

@LabAnnotation(
        number = "03",
        text = "К классу из предыдущего примера добавьте поле logged типа Boolean.\n" +
               "Фильтруем только созданные ранее заданной даты и с установленным полем logged в true")
public class task03_TwoFiltersArrayOfObjects extends task {
    LocalDateTime fltDate;

    public task03_TwoFiltersArrayOfObjects() {

        ArrayList<Person> listOfPerson = new ArrayList<>();
        listOfPerson = createPersonsArrayList();
        System.out.println(listOfPerson);

        fltDate = LocalDateTime.of(2019, 02, 27, 02, 30, 31);
        System.out.println("\n\ncreated before " + fltDate.toLocalDate() + " " +
                fltDate.toLocalTime() + " and logged=true:\n");

        List<Person> filteredListOfPerson = listOfPerson.stream()
            .filter((Person p)-> p.createdAt.isBefore(fltDate))
            .filter((Person p)-> p.logged)
            .collect(Collectors.toList());

        System.out.println(filteredListOfPerson);
    }
}
