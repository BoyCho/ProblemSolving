public class Main {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        boolean[] d = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int n = creater(i);
            if (n > 10000) continue;
            d[n] = true;
        }
        for (int i = 1; i <= 10000; i++)
            if (!d[i]) sb.append(i + "\n");
        System.out.println(sb);
    }

    public static int creater(int n) {
        int n_ = n;
        while (n != 0) {
            n_ += n % 10;
            n /= 10;
        }
        return n_;
    }
}
