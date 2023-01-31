import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pattern reg0 = Pattern.compile("\\d+\\b");
        Pattern reg1 = Pattern.compile("\\d+x");

        String s = br.readLine();
        if (s.equals("0")) { bw.write("W"); bw.close(); return; }

        Matcher m0 = reg0.matcher(s);
        Matcher m1 = reg1.matcher(s);

        if (m1.find()) s = s.replaceAll(reg1.pattern(), one(m1.group().split("x")[0], 1) + "xx");
        if (m0.find()) s = s.replaceAll(reg0.pattern(), one(m0.group(), 0) + "x");

        bw.write(s + "+W"); bw.close();
    }

    static String one(String s, int n) {
        int r = Integer.parseInt(s) / (n + 1);
        if (r == 1) return "";
        return String.valueOf(r);
    }
}