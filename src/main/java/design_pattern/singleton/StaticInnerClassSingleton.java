package design_pattern.singleton;

public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    private static final class InstanceHolder {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
