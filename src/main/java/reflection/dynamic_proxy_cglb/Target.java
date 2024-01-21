package reflection.dynamic_proxy_cglb;

public class Target {
    String name;

    public Target(String name) {
        this.name = name;
    }

    public void methodA() {
        System.out.println(name + " method a");
    }

    public void methodB() {
        System.out.println(name + "method b");
    }
}
