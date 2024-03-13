package annotation;

@SelfDefinedAnnotation(name = "wei", number = 20)
public class TestClass {
    public static void main(String[] args) {
        Class<TestClass> clazz = TestClass.class;
        SelfDefinedAnnotation annotation = clazz.getAnnotation(SelfDefinedAnnotation.class);

        if (annotation != null) {
            String name = annotation.name();
            int number = annotation.number();

            System.out.println("Name: " + name);
            System.out.println("Number: " + number);
        } else {
            System.out.println("Annotation not found");
        }
    }
}
