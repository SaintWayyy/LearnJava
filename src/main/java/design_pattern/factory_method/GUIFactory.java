package design_pattern.factory_method;

// 抽象工厂 - GUI 工厂接口
interface GUIFactory {
    Button createButton();
}

// 具体工厂 - MacOS GUI 工厂
class MacOSGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }
}

// 具体工厂 - Windows GUI 工厂
class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
