/*
Cоздание стрима из List.
Пример входа                            Пример выхода
[“a1”,”a2”,”a3”] as ArrayList           [“a1”,”a2”,”a3”]
 */

package streams1;
import utils.*;

import java.util.ArrayList;

@LabAnnotation(
        number = "01",
        text = "Cоздание стрима из ArrayList.")
public class task01_StreamFromArrayList extends task {

    public task01_StreamFromArrayList() {
        super();

        ArrayList<String> al = new ArrayList<String>();
        for (int i=1; i<=3; i++) al.add("a"+i);
        al.stream()
                .forEach((x)-> System.out.print(x+","));

        System.out.println();
    }
}
