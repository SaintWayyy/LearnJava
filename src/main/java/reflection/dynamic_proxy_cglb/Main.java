package reflection.dynamic_proxy_cglb;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(Target.class.getClassLoader());
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(new LogProxy());

        Target target = (Target) enhancer.create(new Class[]{String.class}, new Object[]{"Target1"});
        target.methodA();
        target.methodB();
    }
}
