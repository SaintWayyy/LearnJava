package reflection;

public class Reflection {
    Class<Object> clazz;

    void getClazz() {
        try {
            Class clazz = Object.class;
            clazz = (Class<Object>) new Object().getClass();
            clazz = (Class<Object>) Class.forName("java.lang.Object");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
