/*
Дан массив объектов (поля: id – Long, name - String, date - LocalDate ).
Посчитать количество объектов, у которых date лежит в пределах текущего года.
 */
package streams3;
import utils.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import static utils.CreateUsers.createUsersArrayList;

@LabAnnotation(
        number = "09",
        text = "Дан массив объектов (поля: id – Long, name - String, date - LocalDate ).\n" +
                "Посчитать количество объектов, у которых date лежит в пределах текущего года.")
public class task09_ObjectsQuantityWithDateEqualCurrentYear extends task {
    private ArrayList<User> listOfUsers = new ArrayList<User>();

    public task09_ObjectsQuantityWithDateEqualCurrentYear() {
        super();
        listOfUsers = createUsersArrayList();
        System.out.println("\nList of users: \n" + listOfUsers);
        int currentYear = LocalDate.now().getYear();
        long objectsCnt = listOfUsers.stream()
                .filter(o->o.date.getYear()==currentYear)
                .count();
        System.out.println("objects with current year date: " +objectsCnt );

    }
}
