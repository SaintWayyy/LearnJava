package data_structure;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
    public String s = "";

    public StringJoiner stringJoiner = new StringJoiner(", ");

    public StringBuilder stringBuilder = new StringBuilder();
    public StringBuffer stringBuffer = new StringBuffer();

    public void regex() {
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();

        b = Pattern.matches("[a-z]+", "aaaaab");
    }

    @Test
    public void equals() {
        String b = "test";
        String c = "test";
        String a = new String("test");
        String d = new String("test");

        //指向同一个常量池对象
        System.out.println(a == b);

        //一个指向常量池，一个指向堆
        System.out.println(b == c);

        //两个不同的堆对象
        System.out.println(c == d);
    }
}
