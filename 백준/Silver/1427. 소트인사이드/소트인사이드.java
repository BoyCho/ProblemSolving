import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();
        Arrays.sort(s);

        System.out.println(new StringBuilder(new String(s)).reverse());
    }
}