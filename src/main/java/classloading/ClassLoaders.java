package classloading;

import com.sun.net.httpserver.HttpServer;

import java.util.concurrent.atomic.AtomicInteger;

public class ClassLoaders {
    public static void main(String[] args) {
        // class loader of self defined class
        System.out.println(ClassLoaders.class.getClassLoader());

        // class loader of HttpServer
        System.out.println(HttpServer.class.getClassLoader());

        // class loader of AtomicInteger
        System.out.println(AtomicInteger.class.getClassLoader());

        // BootstrapClassLoader <-- PlatformClassLoader <-- AppClassLoader
        System.out.println(
                ClassLoaders.class.getClassLoader() + " " +
                ClassLoaders.class.getClassLoader().getParent() + " " +
                ClassLoaders.class.getClassLoader().getParent().getParent());
    }
}
