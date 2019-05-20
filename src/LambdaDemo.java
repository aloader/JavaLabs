/*
2.1.2 Lambda, functional interface
 */

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;
import java.util.regex.Pattern;
import lambdas.*;

public class LambdaDemo {

    public static void main(String[] args) {

        // Вернуть лямбду, которая печатает “Hello world!”
        System.out.println("\n*** task 01 ***");
        PrintHelloWorld printHelloWorld = () -> System.out.println("Hello, world!");
        printHelloWorld.doPrintHelloWordl();

        // Вернуть лямбду, которая поприветствует того, чье имя
        // будет передано первым аргументом
        System.out.println("\n*** task 02 ***");
        String nm = "Lenin";
        Consumer printHiName = str-> System.out.println("Hi, " + str+".");
        printHiName.accept(nm);


        // Вернуть лямбду, которая принимает в качестве аргумента
        // предыдущую лямбду, и добавляет вывод “Have a nice day!”
        // после выполнения лямбды
        System.out.println("\n*** task 03 ***");
        Function<Consumer, Consumer> printHaveANiceDay = o-> {
            return o.andThen((s)-> System.out.println("Have a nice day!"));
        };
        printHaveANiceDay.apply(printHiName).accept("Lennon");

        // Вернуть лямбду, которая возвращает текущее время
        System.out.println("\n*** task 04 ***");
        Supplier<String> CurrTime = ()-> {
            return String.valueOf((LocalDateTime.now()).toLocalTime());
        };
        System.out.println("current time: "+CurrTime.get());

        // Вернуть лямбду, которая проверяет строку на наличие в ней email.
        // Под email понимать любую строку, которая ввыглядит как
        // <любые символы>@<любые символы>.<любые символы>
        System.out.println("\n*** task 05 ***");
        String emailPattern = "[^@]*@{1}[^@]*\\.{1}[^@.]++";
        String testStr = "h.jdfgh.kda@gmail.ty.u.u.u..by";
        Predicate<String> isEmail = str -> Pattern.matches(emailPattern, str);
        System.out.println("is string \""+ testStr + "\" email? " + isEmail.test(testStr));;
        testStr = "sdf.gsdf@dfgb.dsfg@tut.by";
        System.out.println("String \""+ testStr + "\" is email? " + isEmail.test(testStr));

        // К предыдущей лямбде добавить проверку на длину строки (> 10)
        System.out.println("\n*** task 06 ***");
        testStr = "sdf.gsdf@dfgb.dsfg@tut.by";
        Predicate<String> more10Char = str -> str.length()>10;
        System.out.println("String \""+ testStr + "\" is email and lenght>10? " +
                isEmail.and(more10Char).test(testStr));

        // К предыдущей лямбде добавить отрицание
        System.out.println("\n*** task 07 ***");
        testStr = "sdf.gsdf@dfgb.dsfg@tut.by";
        System.out.println("NOT string \":"+testStr+"\" is email and lenght>10 " +
                isEmail.and(more10Char).negate().test(testStr));


        // Вернуть лямбду, которая проверяет число на принадлежность к ряду
        // Фибоначчи. Лямбда должна запоминать ранее вычисленные значения.
        new task08_CheckNumFibonachchi();

        // Вернуть лямбду, которая возвращает сумму двух входных аргументов
        System.out.println("\n*** task 09 ***");
        BiFunction<Integer, Integer, Integer> getSum = (num1, num2)-> {return num1+num2;};
        System.out.println("sum 2 arguments 5+7: " + getSum.apply(5, 7));

        // К предыдущей лямбде добавить возведение в квадрат
        System.out.println("\n*** task 10 ***");
        Function<Integer, Integer> getSquare = (Integer num) -> {return num*num;};
        System.out.println("(6+8)^2 = " + getSum.andThen(getSquare).apply(6, 8));

        // Вернуть лямбду, которая возвращает сумму трех входных аргументов
        System.out.println("\n*** task 11 ***");
        SumThreeArgs<Integer> SumThree = (num1,num2,num3) -> num1+num2+num3;
        System.out.println("sum 3 arguments 12+3+4: " + SumThree.getSumThreeArgs(12, 3, 4));

        // Вернуть лямбду, которая возводит число в квадрат
        System.out.println("\n*** task 12 ***");
        Function<Integer, Integer> getNumSquare = num->{return num*num;};
        System.out.println("square of 6: " + getNumSquare.apply(6));

        // Добавить к предыдущей лямбде инкремент перед
        System.out.println("\n*** task 13 ***");
        Function<Integer, Integer> getInc = (num)->num+1;
        System.out.println("prev lambda, inc before (8+1)^2: " + getNumSquare.compose(getInc).apply(8));
        System.out.println("");

        // Добавить к предыдущей лямбде декремент после
        System.out.println("\n*** task 14 ***");
        Function<Integer, Integer> getDec = (num)->num-1;
        System.out.println("prev lambda, inc before dec after (8+1)^2-1: " +
                getNumSquare.compose(getInc).andThen(getDec).apply(8));
        System.out.println("");

        // Вернуть лямбду, которая решает уравнение x^2 + 3x – 1 для заданного x
        System.out.println("\n*** task 15 ***");
        Function<Integer, Integer> quadEcu1 = x->{return x*x+3*x-1;};
        System.out.println("x^2 + 3x – 1, when x=3: " + quadEcu1.apply(3));

        // Вернуть лямбду, которая решает уравнение
        // (x^2 + 3x – 1)^2 + 3* (x^2 + 3x – 1) -1  для заданного x.
        // Необходимо решить задачу переиспользованием предыдущей лямбды.
        System.out.println("\n*** task 16 ***");
        Function<Integer, Integer> quadEcu2 = quadEcu1;
        System.out.println("(x^2 + 3x – 1)^2 + 3* (x^2 + 3x – 1) -1, when x=3: " +
                quadEcu2.andThen(quadEcu1).apply(3));

        // Вернуть лямбду, которая решает уравнение
        // x*x*x + y*y*y + z*z*z + u*u*u + v*v*v
        // для заданных (x,y,z,u,v)
        System.out.println("\n*** task 17 ***");
        FuncFiveArgs<Integer> getEcu2 = (x, y, z, u, v)->
            {return x*x*x + y*y*y + z*z*z + u*u*u + v*v*v;};
        System.out.println("x*x*x + y*y*y + z*z*z + u*u*u + v*v*v, when x=3,y=4,z=5,u=6,v=7: " +
                getEcu2.getFiveArgs(3,4,5,6,7));


        // Вернуть лямбду, которая возвращает лямбду, возводящую в квадрат по заданной степени
        //
        // Идея в том что первая лямбда запоминает степень, и возвращает ещё одну лямбду.
        // А вторая уже на основании входящего значения возводит в степень
        System.out.println("\n*** task 18 ***");
        System.out.println("x^y");

        Supplier< Function<Integer, Integer>> f18_0 = ()->{
                int[] pow = {-1};
                return x->{
                    if (pow[0]==-1) {
                        pow[0] = x;
                        return 0;
                    } else for (int i=1; i<pow[0]; i++, x *= x);
                    return x;
                };
        };
        Function< Integer, Integer> f18_1 = f18_0.get();
        System.out.println("f18.apply(2), result: " +  f18_1.apply(2));
        System.out.println("f18.apply(10), result: " +  f18_1.apply(10));
        System.out.println("f18.apply(5), result: " +  f18_1.apply(5));


        // Вернуть лямбду, которая производит композицию двух функций. (f1,f2) => f2(f1(x)) .
        // Для этого реализовать функциональный интерфейс. Пример использования:
        // f.compose(x->x*2,x->x-1).apply(10))                                                  19
        // f.compose(f8.compose(x -> x * x, x -> x - 10), f8.compose(x -> x / 2, x -> x + 1)    46
        System.out.println("\n*** task 19 ***");
        System.out.println("lambda (f1,f2) => f2(f1(x))");
        BiFuncCompose<Integer, Integer> f19 = x->x;
        System.out.println("f19.compose(x->x*2,x->x-1).apply(10), result: " + f19.compose(x->x*2,x->x-1).apply(10));
        System.out.println("f19.compose(f19.compose(x -> x * x, x -> x - 10),f19.compose(x -> x / 2, x -> x + 1)).apply(10), result: " +
                f19.compose(f19.compose(x -> x * x, x -> x - 10),
                f19.compose(x -> x / 2, x -> x + 1)).apply(10));


        // Вернуть лямбду, которая вернет полином, основанный на переданных коэффициентах
        //Пример входа                                  Пример выхода
        //f.apply(Arrays.asList(2,3,5))                 X -> 2*x*x + 3*x + 5
        //f.apply(Arrays.asList(-5,-10))                X -> -5*x – 10
        //f.apply(Arrays.asList(8))                     X -> 8

        System.out.println("\n*** task 20 ***");
        System.out.println("polinom");
        Function<List<Integer>, Function <Integer, Integer>> getPolinom = (k_list) -> {
            Integer[] factor = (Integer[]) k_list.toArray();
            return x -> {
                int i,j,k, res=0, fact=1;
                for (i=factor.length-1, j=0; i>=0; i--, j++) {
                    fact = factor[i];
                    for (k=0; k<j; k++) fact *=x;
                    res += fact;
                }
                return res;
            };
        };
        Function<Integer, Integer> f20;
        f20 = getPolinom.apply(Arrays.asList(2,3,5));
        System.out.println("f20 = getPolinom.apply(Arrays.asList(2,3,5)), f_20.apply(5)-> "+f20.apply(5));
        f20 = getPolinom.apply(Arrays.asList(-5,10));
        System.out.println("f20 = getPolinom.apply(Arrays.asList(-5,10)), f_20.apply(5)-> "+f20.apply(5));
        f20 = getPolinom.apply(Arrays.asList(8));
        System.out.println("f20 = getPolinom.apply(Arrays.asList(8)), f_20.apply(5)-> "+f20.apply(5));


        // Вернуть лямбду, которая кеширует результат некоторой функции, которая является
        // входных аргументом
        // Пример входа                     Пример выхода
        //f.apply(() -> Math.random())      0.42
        //f.apply(() -> Math.random())      0.42
        //f.apply(() -> Math.random())      0.42
        System.out.println("\n*** task 21 ***");
        System.out.println("cache function result:");

        Supplier<Function<Supplier, Object>> f21_1 = () -> {
            HashMap<Supplier, Object> cache = new HashMap();
            return (f) -> {
                if (!cache.containsKey(f)) {
                    cache.put(f, f.get());
                } else {
                    System.out.println("result from cache:");
                }
                return cache.get(f);
            };
        };
        Function<Supplier, Object> f21_2 = f21_1.get();
        Supplier<Object> func1 = () -> Math.random();
        Supplier<Object> func2 = () -> Math.PI;

        System.out.println("f.apply(() -> Math.random()) " + f21_2.apply(func1));
        System.out.println("f.apply(() -> Math.random()) " + f21_2.apply(func1));
        System.out.println("f.apply(() -> Math.PI) " + f21_2.apply(func2));
        System.out.println("f.apply(() -> Math.PI) " + f21_2.apply(func2));
        System.out.println("f.apply(() -> Math.random()) " + f21_2.apply(func1));
        System.out.println("f.apply(() -> Math.PI) " + f21_2.apply(func2));
        System.out.println("f.apply(() -> Math.random()) " + f21_2.apply(func1));
        System.out.println("f.apply(() -> Math.random()) " + f21_2.apply(func1));
        System.out.println();


        // Вернуть лямбду, которая запускает переданную функцию f, и в случае исключения перезапускает ее n раз
        //Пример входа                                                      Пример выхода
        //Long n = 0;
        //f.apply({ if (++n[0] % 2 == 0) throw new Exception("error");              2
        // else return n[0]; })
        System.out.println("\n*** task 22 ***");
        System.out.println("exception in lambda");
        Long n = 0L;
        Long[] n_ptr = new Long[1];
        n_ptr[0] = n;
        FunctionException fe22 = ()-> {
            if (++n_ptr[0] % 4 == 0) throw
                    new MyFunctionException();
            else
                return (Object) n_ptr[0];
        };

        Function<FunctionException, Object> f22 = (f) -> {
            Object result=null;
            Long reRunCnt = 0L;
            do {
                try {
                    result = (Object) f.apply();
                } catch (MyFunctionException e) {
                    reRunCnt++;
                    result = null;
                    if (reRunCnt>=n_ptr[0]) {
                        System.out.println("We can't run function - exception counter ends, but function trows exception.");
                        break;
                    }
                };
            } while (reRunCnt <=n_ptr[0] & result==null);
            if (reRunCnt>0) System.out.println("Exception! Function reruns!");
            return result;
        };
        System.out.println("Run function with exception. Rerun function on each 4-th invoke.");
        for (int i=0; i<=6; i++) {
            System.out.println("Run " + i + ", function result: " +f22.apply(fe22));
        }

        // Вернуть лямбду, которая перед и после запуска переданной функции f, вызывает функцию логгера
        // logFunc
        //Пример входа                                                      Пример выхода
        //f10.intercept(x -> x + 1, System.out::println).apply(10)          Before 10
        //                                                                  After 11
        System.out.println("\n*** task 23 ***");
        System.out.println("invoke logFunc before the function call and after the function");
        System.out.println("f23.intercept(x -> x + 1, System.out::println).apply(10)");
        FunctionLogger<Integer, Integer> f23 = (x)->x;
        f23.intercept(x -> x + 1, System.out::println).apply(10);


        // Вернуть лямбду, представляющую из себя последовательность, которая начинается с переданного x
        // Пример входа                                         Пример выхода
        //Supplier<Long> startFrom100 = f.apply(100L);
        //startFrom100.get();                                   100
        //startFrom100.get();                                   101
        //startFrom100.get();                                   102
        System.out.println("\n*** task 24 ***");
        System.out.println("set start point: 100");
        Function<Integer, Supplier<Integer>> getStartFrom = x-> {
            Integer[] startSeq = {x};
            return () -> {
                return startSeq[0]++;
            };
        };
        Supplier<Integer> startFrom = getStartFrom.apply(100);
        System.out.println("startFrom.get(): " + startFrom.get());
        System.out.println("startFrom.get(): " + startFrom.get());
        System.out.println("startFrom.get(): " + startFrom.get());
        System.out.println("startFrom.get(): " + startFrom.get());

    }

}

