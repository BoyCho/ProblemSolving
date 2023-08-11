import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringBuilder sb = new StringBuilder();
	
	static int[] D = new int[9];
	static int[] pick = new int[7];
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 9; i++)
			D[i] = Integer.parseInt(br.readLine());
		
		comb(0, 0, 0);
	}
	
	public static void comb(int L, int st, int sum) {
		if (L == 7) {
			if (sum != 100) return;
			
			for (int p : pick) sb.append(p).append("\n");
			System.out.println(sb);
			return;
		}
		
		for (int i = st; i < 9; i++) {
			pick[L] = D[i];
			comb(L + 1, i + 1, sum + D[i]);
		}
	}
}
