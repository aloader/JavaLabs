package utils;

import java.time.LocalDateTime;
import java.util.ArrayList;

// create arraylist for tasks02, 03
public class CreatePersons {
    public static ArrayList<Person> createPersonsArrayList() {
        ArrayList<Person> listOfPerson = new ArrayList<Person>();
        listOfPerson.add(new Person("Ivan", "Ivanov", LocalDateTime.of(2019, 01, 15, 5, 17, 53), true));
        listOfPerson.add(new Person("Alex", "Alex", LocalDateTime.of(2019, 04, 8, 10, 55, 26), false));
        listOfPerson.add(new Person("Peter", "Pavlov", LocalDateTime.of(2019, 03, 29, 12, 03, 8), true));
        listOfPerson.add(new Person("Polievkt", "Harlampievich", LocalDateTime.of(2019, 02, 26, 23, 14, 48), false));

        return listOfPerson;
    }
}
