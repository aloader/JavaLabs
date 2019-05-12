package lambdas;
import java.util.function.Function;

@FunctionalInterface
public interface FunctionException  {
    Object apply() throws MyFunctionException;
}
