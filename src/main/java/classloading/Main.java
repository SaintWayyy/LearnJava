package classloading;

public class Main {
    public static void main(String[] args) {
        // Static Initialization Block and Static Fields Assignments are executed when the class is loaded
        OuterClass.doNothing();
        // Instance Initialization Block and Fields Assignments are executed when the instance is created
        OuterClass outerClass = new OuterClass();

        // Inner classes are loaded only when they are used
        OuterClass.StaticInnerClass.doNothing();
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();

        OuterClass.InnerClass.doNothing();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    }
}
