package exception;

public class ExceptionReturn {
    static int exceptionReturn(){
        try {
            throw new RuntimeException();
        }
        catch (Exception e){
            return 2;
        }
        finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(exceptionReturn());
    }
}
