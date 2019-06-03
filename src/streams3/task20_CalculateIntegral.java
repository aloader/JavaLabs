/*
 Рассчитать интеграл  на заданном диапазоне с заданным шагом.

 пример из интернета:
 Приближенно вычислить интеграл от функции LN(2+SIN(X)) в про-
    межутке от A до B (где A<B), используя составную формулу пря-
    моугольников для заданного шага H>=100 :
    интеграл от A до B (где A<B) функции приближенно равен
    H*[F(X1)+F(X2)+...+F(XN)], Где H=(B-A)/N, XI=A+I*H-H/2

 */
package streams3;
import utils.*;

import java.util.function.Function;
import java.util.stream.Stream;

@LabAnnotation(
        number = "20",
        text = "Рассчитать интеграл  на заданном диапазоне с заданным шагом.")
public class task20_CalculateIntegral extends task {
    public task20_CalculateIntegral() {
        super();

        double a = 1;           // left bound
        double b = 10;          // right bound
        long n = 9000;          // number of intervals
        double h = (b-a)/n;     // step

        // h*[f(x0+h/2) + f(x1+h/2) + f(x2+h/2) ....]   <- formula
        // h = (b-a)/n      <- step

        Function<Double, Double> f = x-> {
            x += h/2;
            return 3*Math.sqrt(2*Math.log(x))/(x*x+Math.pow(5,x));
        };

        Double y = Stream.iterate(a, x->x+h)
                .limit(n)
                .peek(x->{System.out.print(x+" ");})
                .reduce(0d, (acc, xi)->acc+f.apply(xi));
        System.out.println("\nresult: " + y*h);
    }
}
