package classloading;

public class LearnClassLoaders {
    public static void main(String[] args) {
        // Class loader of classes in java.base package
        System.out.println(java.util.HashMap.class.getClassLoader());

        // Class loader of classes not in java.base package
        System.out.println(java.sql.DriverManager.class.getClassLoader());

        // Class loader of self defined class
        System.out.println(LearnClassLoaders.class.getClassLoader());

        // BootstrapClassLoader <-- PlatformClassLoader <-- AppClassLoader
        System.out.println(
                LearnClassLoaders.class.getClassLoader() + " " +
                        LearnClassLoaders.class.getClassLoader().getParent() + " " +
                        LearnClassLoaders.class.getClassLoader().getParent().getParent()
        );

        new ClassLoader(){
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return null;
            }

            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return null;
            }
        };
    }
}
