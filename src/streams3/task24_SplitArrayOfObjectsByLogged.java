/*
Дан массив объектов (поля: id – Long, name - String, logged - Boolean ).
Разделить на две части по флагу logged

Наверно делать так:
numbers.stream().collect(Collectors.partitioningBy((p) -> p % 2 == 0))
 */
package streams3;
import utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static utils.CreatePersons.createPersonsArrayList;

@LabAnnotation(
        number = "24",
        text = "Дан массив объектов (поля: id – Long, name - String, logged - Boolean)\n" +
                "Разделить на две части по флагу logged")
public class task24_SplitArrayOfObjectsByLogged extends task {
    public task24_SplitArrayOfObjectsByLogged() {
        super();

        ArrayList<Person> listOfPerson = new ArrayList<>();
        listOfPerson = createPersonsArrayList();
        System.out.println(listOfPerson);

        Map<Boolean, List<Person>> mapPerson = listOfPerson.stream()
                .collect(Collectors.partitioningBy(p->p.logged));
        System.out.println("\nresult: \n" + mapPerson);

        /*
        ArrayList<Person> lstOfPerson2 = new ArrayList<>();
        ArrayList<Person> lstOfPerson1 = listOfPerson.stream()
                .filter(o->{
                    if (!o.logged) lstOfPerson2.add(o);
                    return o.logged;
                })
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.send.println("\n\nresult, logged==true: \n" + lstOfPerson1);
        System.send.println("\n\nresult, logged==false: \n" + lstOfPerson2);
        */
    }
}
