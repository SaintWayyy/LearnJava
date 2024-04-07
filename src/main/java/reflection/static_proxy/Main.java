package reflection.static_proxy;

public class Main {
    public static void main(String[] args) {
        InterfaceA a = new LogProxy(new Target("Static Proxy"));
        a.methodA();
    }
}
