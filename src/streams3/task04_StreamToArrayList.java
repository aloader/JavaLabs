/*
Дан стрим, преобразовать его в ArrayList
 */
package streams3;
import utils.*;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@LabAnnotation(
        number = "04",
        text = "Дан стрим, преобразовать его в ArrayList.")
public class task04_StreamToArrayList extends task {
    public task04_StreamToArrayList() {
        super();

        ArrayList<Double> strArrayList = Stream.generate(()->{return Math.random();})
                .limit(5)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(" " + strArrayList);
    }
}
