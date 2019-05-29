/*
Создание бесконечного стрима, который возвращает последовательность
фибоначчи ( Fn = Fn-1 + Fn-2, F0 = 0, F1 = 1)

Пример входа            Пример выхода
                        [“0”,”1”,”1”,”2”,”3”,”5”,”13”]
 */
package streams1;

import utils.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@LabAnnotation(
        number = "08",
        text = "Создание бесконечного стрима, который возвращает последовательность \n" +
                "фибоначчи ( Fn = Fn-1 + Fn-2, F0 = 0, F1 = 1).")
public class task08_Fibonachchi extends task {
    Integer num1=-1, num2=0;
    public task08_Fibonachchi() {

        System.out.println("first 10 numbers");
        List<Integer> intList = Stream.generate(()-> {
                Integer res;
                if (num1==-1) res = 0;
                    else if (num1==0) res = 1;
                    else res = num1 + num2;
                num1 = num2;
                num2 = res;
                return res;
            })
            .limit(10)
            .collect(Collectors.toList());
        System.out.println("result: " + intList);
    }
}
