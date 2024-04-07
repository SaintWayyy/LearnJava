package oop;

import org.junit.jupiter.api.Test;

public class InnerClasses {
    class InnerClass {

    }

    static class StaticInnerClass {

    }

    @Test
    public void methodWithInnerClass() {
        class MethodInnerClass {

        }
        System.out.println(MethodInnerClass.class);
    }

    @Test
    void anonymousInnerClasses() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass());
            }
        };
        new Thread(r).start();

        System.out.println(new Object() {
        }.getClass());
    }
}
