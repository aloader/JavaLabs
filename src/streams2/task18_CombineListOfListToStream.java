/*
Объедините List Listов в один Stream.
 */
package streams2;
import utils.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@LabAnnotation(
        number = "18",
        text = "Объедините List Listов в один Stream.")
public class task18_CombineListOfListToStream extends task {
    public task18_CombineListOfListToStream() {
        super();

        ArrayList listStr = new ArrayList();
        listStr.add(Arrays.asList(new String[]{"str3", "str4", "str5"}));

        ArrayList listInt = new ArrayList();
        listInt.add(Arrays.asList(new Integer[]{1, 2, 3, 4}));

        ArrayList listDouble = new ArrayList();
        listDouble.add(Arrays.asList(new Double[]{0.5, 0.3}));

        ArrayList<ArrayList> listList = new ArrayList<>();
        listList.add(listStr);
        listList.add(listInt);
        listList.add(listDouble);
        System.out.println("List of list: " + listList);

        Stream streamOfLists = listList.stream()
                .flatMap(x->{
                    return Stream.of(x);
                });

        System.out.println("Stream of the list: " + streamOfLists.collect(Collectors.toList()));


    }
}
