/*
Дан массив объектов (поля: id – Long, name - String, date - LocalDate ).
Убедиться, лежат ли date всех объектов в пределах текущего года.
 */
package streams3;
import utils.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static utils.CreateUsers.createUsersArrayList;

@LabAnnotation(
        number = "11",
        text = "Дан массив объектов (поля: id – Long, name - String, date - LocalDate ).\n" +
                "Убедиться, лежат ли date всех объектов в пределах текущего года.")
public class task11_IsObjectNotCurrentYearExist extends task {
    private ArrayList<User> listOfUsers = new ArrayList<User>();

    public task11_IsObjectNotCurrentYearExist() {
        super();
        listOfUsers = createUsersArrayList();
        System.out.println("\nList of users: \n" + listOfUsers);

        int currentYear = LocalDate.now().getYear();

        System.out.println("Is there any objects with year != current? " +
            listOfUsers.stream().anyMatch(o->o.date.getYear()!=currentYear)
        );


    }
}
