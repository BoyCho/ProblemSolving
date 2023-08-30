import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int T, cnt;
	static String N, M;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			stk = new StringTokenizer(br.readLine());
			
			N = stk.nextToken();
			M = stk.nextToken();
			
			sb.append(factorial(new BigInteger(M)).divide(factorial(new BigInteger(N)).multiply(factorial(new BigInteger(M).subtract(new BigInteger(N)))))).append("\n");
		}
		System.out.println(sb);
	}
	
	public static BigInteger factorial(BigInteger n) {
		if (n.compareTo(BigInteger.ONE) <= 0) return BigInteger.ONE;
		return factorial(new BigInteger(n.subtract(BigInteger.ONE).toString())).multiply(n);
	}
}
