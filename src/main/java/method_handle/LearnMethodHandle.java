package method_handle;

import java.io.PrintStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class LearnMethodHandle {
    public static void main(String[] args) {
        // 方法的返回值 方法的入参
        MethodType methodType = MethodType.methodType(void.class, Object.class);
        try {
            MethodHandle printlnHandle  = MethodHandles.lookup().findVirtual(
                    PrintStream.class, "println", methodType
            );
            printlnHandle.invoke(System.out, "Hello World");

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
