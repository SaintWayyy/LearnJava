package reflection.static_proxy;

public class LogProxy implements InterfaceA {
    private InterfaceA target;

    public LogProxy(InterfaceA target) {
        this.target = target;
    }

    @Override
    public void methodA() {
        System.out.println("Logging");
        target.methodA();
    }
}