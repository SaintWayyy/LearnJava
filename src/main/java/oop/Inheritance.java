package oop;

public class Inheritance {
    public static void main(String[] args) {

    }
}

/**
 * 子类方法的访问权限应比父类方法的访问权限更大或相等。
 * 子类方法返回值类型应是父类方法返回值类型的子类或相同类型。
 * 子类方法声明抛出的异常类应是父类方法声明抛出的异常类的子类或相同的异常类型。
 */
class Father {
    protected Father print() throws Exception {
        return null;
    }
}

class Son extends Father {
    @Override
    public Son print() throws RuntimeException {
        return null;
    }
}
