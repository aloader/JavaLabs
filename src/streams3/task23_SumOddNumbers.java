/*
23.Вернуть сумму нечетных чисел
 */
package streams3;
import utils.*;

import java.util.Arrays;
import java.util.stream.IntStream;

@LabAnnotation(
        number = "23",
        text = "Вернуть сумму нечетных чисел")
public class task23_SumOddNumbers extends task {
    public task23_SumOddNumbers() {
        super();

        int[] iA = {1, 5, 6, 8, 9, 18, 19, 11};
        System.out.println("array: ");
        Arrays.stream(iA).forEach(x->{
            System.out.print(x+" ");
        });

        int sumOdd = Arrays.stream(iA)
                .filter(x->x%2!=0)
                .sum();
        System.out.println("\nsum odd numbers: " + sumOdd);
    }
}
