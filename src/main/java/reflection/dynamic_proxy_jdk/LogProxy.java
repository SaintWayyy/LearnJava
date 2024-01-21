package reflection.dynamic_proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LogProxy implements InvocationHandler {
    private Object target;

    public LogProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin to invoke method: " + method.getName() + " | params: " + Arrays.toString(args));
        return method.invoke(target, args);
    }
}