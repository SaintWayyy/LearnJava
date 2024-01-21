package design_pattern.creation_patterns.singleton;

public class LazyInitializationSingleton {
    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton() {
    }

    public static synchronized LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }
}
