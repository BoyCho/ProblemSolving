import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            List<int[]> info = new ArrayList<>();
            while (B-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                int inT = convert(st.nextToken(), st.nextToken());
                int outT = convert(st.nextToken(), st.nextToken());

                info.add(new int[]{inT, 1});
                info.add(new int[]{outT + C, 2});
            }
            Collections.sort(info, (int[] a, int[] b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

            int rooms = 0, max = 0;
            for (int[] in : info) {
                if (in[1] == 2) rooms--;
                else rooms++;
                max = Math.max(max, rooms);
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }

    static int convert(String date, String time) {
        StringTokenizer st;
        st = new StringTokenizer(date, "-");
        int year = Integer.parseInt(st.nextToken()) - 2013;
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        day += year * 365;
        for (int i = 1; i < month; i++) {
            if (i == 2) day += 28;
            else if (i == 4 || i == 6 || i == 9 || i == 11) day += 30;
            else day += 31;
        }
        int ans = day * 1440 + h * 60 + m;
        return year >= 3 && month >= 3 ? ans + 1440 : ans;
    }
}