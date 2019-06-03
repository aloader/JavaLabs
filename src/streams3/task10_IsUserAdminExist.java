/*
Дан массив объектов (поля: id – Long, name - String, date - LocalDate ).
Убедиться, есть ли в массиве пользователь с name = admin
 */
package streams3;
import utils.*;

import java.util.ArrayList;
import static utils.CreateUsers.createUsersArrayList;

@LabAnnotation(
        number = "10",
        text = "Дан массив объектов (поля: id – Long, name - String, date - LocalDate ).\n" +
                "Убедиться, есть ли в массиве пользователь с name = admin.")
public class task10_IsUserAdminExist extends task {
    private ArrayList<User> listOfUsers = new ArrayList<User>();

    public task10_IsUserAdminExist() {
        super();
        listOfUsers = createUsersArrayList();
        System.out.println("\nList of users: \n" + listOfUsers);

        System.out.println("is user \"admin\" exist? " +
                listOfUsers.stream()
                .anyMatch(o->o.name.equalsIgnoreCase("admin"))
        );
    }
}
