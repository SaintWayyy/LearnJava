package design_pattern.abstract_factory;

// 抽象产品族 - 文本框接口
interface TextField {
    void input();
}

// 具体产品族1 - Windows 风格文本框
class WindowsTextField implements TextField {
    @Override
    public void input() {
        System.out.println("Windows TextField input");
    }
}

// 具体产品族2 - MacOS 风格文本框
class MacOSTextField implements TextField {
    @Override
    public void input() {
        System.out.println("MacOS TextField input");
    }
}
