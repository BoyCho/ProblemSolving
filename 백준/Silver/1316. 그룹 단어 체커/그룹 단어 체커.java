import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        while (N-- > 0)
            ans += isGroup(br.readLine());
        System.out.println(ans);
    }

    static int isGroup(String s) {
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (!set.contains(s.charAt(i)) ) {
                set.add(s.charAt(i));
                continue;
            }
            if (s.charAt(i - 1) != s.charAt(i))
                return 0;
        }
        return 1;
    }
}