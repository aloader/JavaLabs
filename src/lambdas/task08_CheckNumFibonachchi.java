/*
Вернуть лямбду, которая проверяет число на принадлежность к ряду
Фибоначчи. Лямбда должна запоминать ранее вычисленные значения.
 */

package lambdas;
import utils.*;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

@LabAnnotation(
        number = "08",
        text = "Вернуть лямбду, которая проверяет число на принадлежность к ряду.\n" +
                "Фибоначчи. Лямбда должна запоминать ранее вычисленные значения.")
public class task08_CheckNumFibonachchi extends task {
    public task08_CheckNumFibonachchi() {

        Supplier<Function<Long, Boolean>> fib2 = () -> {
            // K:( lastFibNum )       V: (predFibNum)
            // nextFibNum = lastFibNum + predFibNum
            HashMap<Long, Long> cacheFib = new HashMap();
            long[] maxFibNum = {1L};        // max hashed number

            // key - Fibonacci number, value - previous number
            // store first numbers: 0 and 1
            cacheFib.put(0L, 0L);
            cacheFib.put(1L, 1L);

            return (checkedNum) -> {
                //if (checkedNum <= maxFibNum[0] & cacheFib.get(checkedNum) != null) {
                if (checkedNum <= maxFibNum[0] & cacheFib.containsKey(checkedNum)) {
                    System.out.print(checkedNum + " cached!");
                    return true;
                }

                long lastFibNum, nextFibNum;
                lastFibNum = maxFibNum[0];
                do {
                    nextFibNum = cacheFib.get(lastFibNum) + lastFibNum;
                    cacheFib.put(nextFibNum, lastFibNum);
                    lastFibNum = nextFibNum;
                } while (lastFibNum < checkedNum);
                maxFibNum[0] = lastFibNum;
                return lastFibNum==checkedNum;
            };
        };
        Function <Long, Boolean> lambda = fib2.get();

        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711
        for (int i=1; i<=20; i++) {
            System.out.println("check: " + i + " -> " + lambda.apply(Long.valueOf(i)));
        }
        for (int i=1; i<=5; i++) {
            System.out.println("check: " + i + " -> " + lambda.apply(Long.valueOf(i)));
        }
    }
}
