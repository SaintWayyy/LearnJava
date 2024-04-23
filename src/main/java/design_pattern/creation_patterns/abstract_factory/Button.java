package design_pattern.creation_patterns.abstract_factory;

interface Button {
    void click();
}

// 具体产品族1 - Windows 风格按钮
class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows Button clicked");
    }
}

// 具体产品族2 - MacOS 风格按钮
class MacOSButton implements Button {
    @Override
    public void click() {
        System.out.println("MacOS Button clicked");
    }
}
