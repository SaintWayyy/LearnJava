package reflection.dynamic_proxy_jdk;

public class Target implements InterfaceA, InterfaceB {
    String name;

    public Target(String name) {
        this.name = name;
    }

    @Override
    public void methodA() {
        System.out.println(name + " method a");
    }

    @Override
    public void methodB() {
        System.out.println(name + "method b");
    }
}
