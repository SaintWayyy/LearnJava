package classloading;

public class OuterClass {
    int field = initField();
    static int staticField = initStaticField();
    final static int finalStaticField = initFinalStaticField();

    public static int initFinalStaticField() {
        System.out.println("init final static field");
        return 2;
    }

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

    public static void main(String[] args) {
        // Static Initialization Block and Static Fields Assignments are executed when the class is loaded <clinit>
        OuterClass.doNothing();
        // Instance Initialization Block, Fields Assignments, Constructor are executed when the instance is created <init>
        OuterClass outerClass = new OuterClass();

        // Inner classes are loaded only when they are used
        OuterClass.StaticInnerClass.doNothing();
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();

        OuterClass.InnerClass.doNothing();
        // Internal classes depend on instances of outer classes
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    }
}
