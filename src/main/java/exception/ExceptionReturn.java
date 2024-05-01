package exception;

public class ExceptionReturn {
    static int result = 0;
    static int exceptionReturn() {
        try {
            System.out.println("try");
            result = 1;
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            result = 2;
            return 2;
        } finally {
            System.out.println("finally");
            result = 3;
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(exceptionReturn());
        System.out.println(result);
    }
}
