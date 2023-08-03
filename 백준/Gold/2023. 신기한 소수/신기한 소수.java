import java.io.*;

public class Main {
	
	static int N, size;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	
		N = Integer.parseInt(br.readLine());
		size = (int) Math.pow(10, N);
		
		for (int i = 2; i <= 9; i++) {
			if (!isPrime(i)) continue;
			dfs(1,i);
		}
		
		System.out.println(sb);
	}

	static boolean isPrime(int n) {
		if (n == 0) return true;
		
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0) return false;
		
		return isPrime(n / 10) && true;
	}
	
	static void dfs(int L, int n) {
		if (L == N) {
			sb.append(n).append("\n");
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			int newN = n * 10 + i;
			
			if (!isPrime(newN)) continue;
			
			dfs(L + 1, newN);
		}
	}
}
