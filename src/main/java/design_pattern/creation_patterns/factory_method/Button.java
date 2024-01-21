package design_pattern.creation_patterns.factory_method;

/**
 * 抽象产品（Product）： 定义了产品的接口，是工厂方法模式创建的对象的超类型。
 * 具体产品（Concrete Product）： 实现了抽象产品接口，由具体的工厂方法创建。
 * 抽象工厂（Creator）： 声明了创建抽象产品对象的工厂方法，可以是抽象类或接口。
 * 具体工厂（Concrete Creator）： 实现了抽象工厂中的工厂方法，返回具体的产品实例。
 */

// 抽象产品 - 按钮接口
interface Button {
    void click();
}

// 具体产品 - MacOS 按钮
class MacOSButton implements Button {
    @Override
    public void click() {
        System.out.println("MacOS Button clicked");
    }
}

// 具体产品 - Windows 按钮
class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows Button clicked");
    }
}
