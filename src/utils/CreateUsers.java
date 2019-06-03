package utils;

import java.time.LocalDate;
import java.util.ArrayList;

// create arraylist for stream3/tasks01
public class CreateUsers {
   public static ArrayList<User> createUsersArrayList() {
        ArrayList<User> listOfUsers = new ArrayList<User>();
        listOfUsers.add(new User(1245L, "Ivanov", LocalDate.of(2019, 01, 15)));
        listOfUsers.add(new User(8415L, "Alex", LocalDate.of(2019, 04, 8)));
        listOfUsers.add(new User(1010L, "Pavlov", LocalDate.of(2019, 03, 29)));
        listOfUsers.add(new User(5689L, "Harlampievich", LocalDate.of(2019, 02, 26)));
        listOfUsers.add(new User(1213L, "admin", LocalDate.of(2018, 01, 05)));

        return listOfUsers;
   }
}
