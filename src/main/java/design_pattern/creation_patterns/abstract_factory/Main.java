package design_pattern.creation_patterns.abstract_factory;

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
        Button button = factory.createButton();
        TextField textField = factory.createTextField();
    }
}
