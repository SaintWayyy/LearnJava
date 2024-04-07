package reflection.dynamic_proxy_jdk;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Target target = new Target("Target1");
        LogProxy proxy = new LogProxy(target);

        InterfaceA a = (InterfaceA) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                proxy
        );
        a.methodA();
        System.out.println(a.getClass());

        InterfaceB b = (InterfaceB) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                proxy
        );
        b.methodB();
        System.out.println(a.getClass());
    }
}
