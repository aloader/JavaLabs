/*
Дан массив объектов (поля: id – Long, name - String, date - LocalDate )
Найти первый элемент в массиве по заданному имени.
В случае отсутствия такового вернуть нового пользователя.
 */
package streams3;
import utils.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import static utils.CreateUsers.createUsersArrayList;

@LabAnnotation(
        number = "01",
        text = "Дан массив объектов (поля: id – Long, name - String, date - LocalDate )\n" +
                "Найти первый элемент в массиве по заданному имени.\n" +
                "В случае отсутствия такового вернуть нового пользователя.")
public class task01_FindFirstObject extends task {
    private ArrayList<User> listOfUsers = new ArrayList<User>();

    public task01_FindFirstObject() {
        super();
        listOfUsers = createUsersArrayList();
        System.out.println(listOfUsers);

        String fndName = "Ivanov";
        System.out.println("\n\nFinding name is: " + fndName + ":\n");
        System.out.println("object: " + findUser(fndName));

        fndName = "Petrov";
        System.out.println("\n\nFinding name is: " + fndName + ":\n");
        System.out.println("object: " + findUser(fndName));

    }

    private User findUser(String fndName) {
        return listOfUsers.stream()
                .filter(u->{return u.name.equalsIgnoreCase(fndName);})
                .findFirst().orElse(new User(1001L, "new_unknown_user", LocalDate.now()));
    }
}
