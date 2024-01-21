package data_structure;

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
}
