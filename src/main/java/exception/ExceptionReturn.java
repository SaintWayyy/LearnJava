package exception;

public class ExceptionReturn {
    static int exceptionReturn() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println(2);
            return 2;
        } finally {
            System.out.println(3);
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(exceptionReturn());
    }
}
