package classloading;

public class OuterClass {
    static int staticField = initStaticField();
    int field = initField();

    public static int initStaticField() {
        System.out.println("init static field");
        return 2;
    }

    public static int initField() {
        System.out.println("init field");
        return 2;
    }

    static {
        System.out.println("outer class static initialization block");
    }

    {
        System.out.println("outer class initialization block");
    }

    public OuterClass() {
        System.out.println("outer class constructor");
    }

    public static void doNothing() {
    }


    static class StaticInnerClass {
        static {
            System.out.println("static inner class static initialization block");
        }

        {
            System.out.println("static inner class initialization block");
        }

        public StaticInnerClass() {
            System.out.println("static inner class constructor");
        }

        public static void doNothing() {
        }
    }

    class InnerClass {
        static {
            System.out.println("inner class static initialization block");
        }

        {
            System.out.println("inner class initialization block");
        }

        public InnerClass() {
            System.out.println("inner class constructor");
        }

        public static void doNothing() {
        }
    }
}
