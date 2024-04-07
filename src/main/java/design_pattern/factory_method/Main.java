package design_pattern.factory_method;

public class Main {
    private static GUIFactory factory;

    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            factory = new WindowsGUIFactory();
        } else {
            factory = new MacOSGUIFactory();
        }
    }

    public static void main(String[] args) {
        configure();
        Button button = factory.createButton();
    }
}