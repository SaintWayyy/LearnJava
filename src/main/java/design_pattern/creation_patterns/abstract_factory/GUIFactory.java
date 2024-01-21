package design_pattern.creation_patterns.abstract_factory;

// 抽象工厂接口
interface GUIFactory {
    Button createButton();
    TextField createTextField();
}

// 具体工厂1 - Windows GUI 工厂
class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}

// 具体工厂2 - MacOS GUI 工厂
class MacOSGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public TextField createTextField() {
        return new MacOSTextField();
    }
}
