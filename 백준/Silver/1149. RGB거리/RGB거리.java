import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] cost = new int[n][3];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 3; j++) {
            cost[i][j] = sc.nextInt();
        }
    }

    int[] dp = new int[3];
    dp[0] = cost[0][0];
    dp[1] = cost[0][1];
    dp[2] = cost[0][2];

    for (int i = 1; i < n; i++) {
        int[] temp = new int[3];
        temp[0] = Math.min(dp[1], dp[2]) + cost[i][0];
        temp[1] = Math.min(dp[0], dp[2]) + cost[i][1];
        temp[2] = Math.min(dp[0], dp[1]) + cost[i][2];
        dp = temp;
    }

    int answer = Math.min(dp[0], Math.min(dp[1], dp[2]));
    System.out.println(answer);
}
}