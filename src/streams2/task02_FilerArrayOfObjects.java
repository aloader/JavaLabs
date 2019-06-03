/*
Отфильтровать массив объектов (по полю createdAt, класс создайте сами, в качестве createdAt
используйте LocalDateTime), оставив только созданные ранее заданной даты.

Пример входа                            Пример выхода
[{                                          [{
firstName:”Ivan”, lastName:”Ivanow”,        firstName:”Ivan”,
createdAt:” 01/15/2019 05:17:53”            lastName:”Ivanow”,
},                                          createdAt:” 01/15/2019 05:17:53”
{                                           }]
firstName:”Alex”,
lastName:”Alex”,
createdAt:” 04/08/2019 10:55:26”
},
{
firstName:”Peter”, lastName:”Peter”,
createdAt:” 03/29/2019 12:03:08”
}] as ArrayList
“02/27/2019 02:30:31” as LocalDateTime
 */
package streams2;
import utils.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.CreatePersons.createPersonsArrayList;


@LabAnnotation(
        number = "02",
        text = "Отфильтровать массив объектов, оставив только созданные ранее заданной даты.")
public class task02_FilerArrayOfObjects extends task {
    LocalDateTime fltDate;

    public task02_FilerArrayOfObjects() {

        ArrayList<Person> listOfPerson = new ArrayList<>();
        listOfPerson = createPersonsArrayList();
        System.out.println(listOfPerson);

        fltDate = LocalDateTime.of(2019, 02, 27, 02, 30, 31);
        System.out.println("\n\ncreated before " + fltDate + ":\n");

        List<Person> filteredListOfPerson =
            listOfPerson.stream()
                    .filter((p)-> p.createdAt.isBefore(this.fltDate))
                .collect(Collectors.toList());
        System.out.println(filteredListOfPerson);
    }

}
