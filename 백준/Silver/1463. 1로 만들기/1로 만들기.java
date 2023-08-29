import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] d = new int[N + 1];
        
		if (N == 1) {
			System.out.println(0);
			return;
		}
		if (N <= 3) {
			System.out.println(1);
			return;
		}
		d[2] = 1;
		d[3] = 1;
		
		for (int i = 4; i <= N; i++) {
			d[i] = d[i - 1] + 1;
			if (i % 3 == 0) 
				d[i] = Math.min(d[i], d[i / 3] + 1);
			if (i % 2 == 0) 
				d[i] = Math.min(d[i], d[i / 2] + 1);
		}
		System.out.println(d[N]);
	}
}
