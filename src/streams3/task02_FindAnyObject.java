/*
Дан массив объектов (поля: id – Long, name - String, date - LocalDate )
Найти любой элемент в массиве по заданному имени с date больше текущей даты.
В случае отсутствия такового вернуть null.
 */
package streams3;
import utils.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

import static utils.CreateUsers.createUsersArrayList;

@LabAnnotation(
        number = "02",
        text = "Дан массив объектов (поля: id – Long, name - String, date - LocalDate)\n" +
                "Найти любой элемент в массиве по заданному имени с date больше текущей даты.\n" +
                "В случае отсутствия такового вернуть null.")
public class task02 extends task {
    private ArrayList<User> listOfUsers = new ArrayList<User>();

    public task02() {
        super();
        listOfUsers = createUsersArrayList();
        System.out.println("\nList of users: \n" + listOfUsers);

        String fndName = "Ivanov";
        LocalDate fndDate = LocalDate.of(2019, 01, 01);
        System.out.println("find name user: \"" + fndName + "\" and date before " + fndDate);
        Predicate<User> filter = u -> {
            return u.name.equalsIgnoreCase(fndName) & u.date.isBefore(fndDate);
        };
        Optional<User> userOptional = findUser(filter);
        if (userOptional.isPresent()) {
            System.out.println("\nUser found: \n" + userOptional.get());
        } else {
            System.out.println("No user found. User object == nul.");
        }

    }

    private Optional<User> findUser(Predicate<User> filter) {
        return listOfUsers.stream()
                .filter(filter)
                .findFirst();
    }

}
