package lambdas;

@FunctionalInterface
public interface SumThreeArgs<T extends Number> {
    T getSumThreeArgs(T arg1, T arg2, T arg3);
}
