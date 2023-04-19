import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            B[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++)
            A[i] += A[i-1];
        for (int i = 1; i < m; i++)
            B[i] += B[i-1];

        HashMap<Integer, Long> mapA = new HashMap<>(); mapA.put(A[0], 1L);
        HashMap<Integer, Long> mapB = new HashMap<>(); mapB.put(B[0], 1L);

        for (int i = 1; i < n; i++) {
            mapA.put(A[i], mapA.getOrDefault(A[i], 0L) + 1);
            for (int j = 0; j < i; j++) {
                int sub = A[i] - A[j];
                mapA.put(sub, mapA.getOrDefault(sub, 0L) + 1);
            }
        }
        for (int i = 1; i < m; i++) {
            mapB.put(B[i], mapB.getOrDefault(B[i], 0L) + 1);
            for (int j = 0; j < i; j++) {
                int sub = B[i] - B[j];
                mapB.put(sub, mapB.getOrDefault(sub, 0L) + 1);
            }
        }

        List<Integer> subB = new ArrayList<>(mapB.keySet());
        Collections.sort(subB);

        long answer = 0;
        for (int subA : mapA.keySet()) {
            int l = 0, r = subB.size();
            while (l < r) {
                int mid = (l + r) / 2;
                if (subB.get(mid) >= T - subA)
                    r = mid;
                else
                    l = mid + 1;
            }
            if (r < subB.size() && T - subA == subB.get(r))
                answer += mapA.get(subA) * mapB.get(subB.get(r));
        }
        System.out.println(answer);
    }
}
