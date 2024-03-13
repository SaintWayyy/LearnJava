import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        try {
            Method method = integerList.getClass().getMethod("add", Object.class);
            method.invoke(integerList,"test");
            method.invoke(integerList,100.f);
        }catch (Exception e) {
            e.printStackTrace();
        }

        for (Object o: integerList){
            System.out.println(o);
        }

        // Producer Extends Consumer Super (PECS)
    }
}
