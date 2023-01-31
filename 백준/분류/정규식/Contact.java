import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            boolean tf = Pattern.matches("(100+1+|01)+", br.readLine());
            if (tf) {
                bw.write("YES" + "\n");
                continue;
            }
            bw.write("NO" + "\n");
        }
        bw.close();
    }
}