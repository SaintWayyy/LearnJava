package reflection.dynamic_proxy_cglb;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogProxy implements MethodInterceptor {
    /**
     * @param o           被代理的对象（需要增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param objects     方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin to invoke method: " + method.getName() + " | params: " + Arrays.toString(objects));
        return methodProxy.invokeSuper(o, objects);
    }
}