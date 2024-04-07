package functional_programming;

import java.util.function.BiConsumer;

public class Lambda {
    // Same as the interfaces in the package: java.util.function.*
    @FunctionalInterface
    public interface MathOperation<T, S, U> {
        T operate(S a, U b);
    }

    public static <T, S, U> T operate(S a, U b, MathOperation<T, S, U> operation) {
        return operation.operate(a, b);
    }

    public static void main(String[] args) {
        operate(1.0, 2, (o1, o2) -> o1 * o2);
        operate(1.0, 2.0, Math::pow);
    }
}
