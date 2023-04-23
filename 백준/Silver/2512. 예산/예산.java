import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        m = Integer.parseInt(br.readLine());

        int l = 0, r = arr[n-1] + 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (cmp(mid))
                r = mid;
            else
                l = mid + 1;
        }
        System.out.println(r - 1);
    }
    
    static boolean cmp(int n) {
        int sum = 0;
        for (int x : arr)
            sum += Math.min(x, n);
        return m < sum;
    }
}