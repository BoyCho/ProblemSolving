import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int L = 0;
        while (N > 0)
            N -= ++L;

        if (L % 2 == 0)
            System.out.println((L + N) + "/" + (1 - N));
        if (L % 2 == 1)
            System.out.println((1 - N) + "/" + (L + N));
    }
}