package lambdas;

@FunctionalInterface
public interface FuncFiveArgs<T extends Number> {
    public T getFiveArgs(T num1, T num2, T num3, T num4, T num5);
}
