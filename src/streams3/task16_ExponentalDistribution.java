/*
Сгенерировать случайную последовательность из 100000 чисел с экспоненциальным распределением.
Рассчитать минимальное, максимальное, среднее, сумму, мат. ожидание, дисперсию, ср. квадратичное
отклонение, моду, медиану
 */
package streams3;
import utils.*;

import java.util.stream.Stream;

@LabAnnotation(
        number = "16",
        text = "Сгенерировать случайную последовательность из 100000 чисел с экспоненциальным распределением. \n" +
                "Рассчитать минимальное, максимальное, среднее, сумму, мат. ожидание, дисперсию, ср. квадратичное \n" +
                "отклонение, моду, медиану. \n")
public class task16_ExponentalDistribution extends task {
    private long counter=0;
    private double lambda = 0.5d;
    private double min=0;
    private double max=0;
    private double avg=0;

    public task16_ExponentalDistribution() {
        super();

        double sum = Stream.generate(()-> {
                    return -Math.log(Math.random())/lambda;
                })
                .limit(100000)
//                .peek(x->{
//                    System.out.println(x + " ");
//                })
                .reduce( 0d, (res, x)->{
                    min = Double.min(min, x);
                    max = Double.max(max, x);
                    counter++;
                    return res+x;});

        System.out.println("lambda-parameter: " + lambda);
        System.out.println("numbers generated: " + counter);
        System.out.println("sum of all elements: " + sum);
        System.out.println("min value: " + min);
        System.out.println("max value: " + max);
        System.out.println("avg value: " + (double)sum/counter);

        System.out.println("dispersion: " + (double)1/(lambda*lambda));
        System.out.println("moda: " + "0.00");
        System.out.println("mediana: " + (double)Math.log(2)/lambda);
        System.out.println("math waiting: " + (double)1/lambda);
        System.out.println("среднеквадр. отклоненеие: " + (double)1/lambda);

    }
}
