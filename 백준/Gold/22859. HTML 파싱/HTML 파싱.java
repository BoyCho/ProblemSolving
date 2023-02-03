import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        Matcher m1 = Pattern.compile("<div title=\"(\\w|_|\\s)*\"").matcher(s);
        Matcher m2 = Pattern.compile("<p>(\\w|\\s|</?[^p]>|</?\\w{2,}\\s?>|\\.)*</p>").matcher(s);
        Map<Integer, String> map = new HashMap<>();

        while (m1.find()) map.put(m1.start(), "title : " + m1.group().split("\"")[1] + "\n");
        while (m2.find()) {
            String p = m2.group().replaceAll("<[\\w\\s/]*>", "");
            map.put(m2.start(), p.replaceAll("\\s{2,}", " ") + "\n");
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i : list) sb.append(map.get(i));
        System.out.println(sb);
    }
}
