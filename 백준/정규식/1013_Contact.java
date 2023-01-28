import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            boolean tf = Pattern.matches("(100+1+|01)+", br.readLine());
            if (tf) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }
}
