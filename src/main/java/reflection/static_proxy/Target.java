package reflection.static_proxy;

public class Target implements InterfaceA {
    String name;

    public Target(String name) {
        this.name = name;
    }

    @Override
    public void methodA() {
        System.out.println(name + " method a");
    }
}
