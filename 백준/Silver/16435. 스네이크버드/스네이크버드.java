import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine());
		
	    int N = Integer.parseInt(stk.nextToken());
	    int L = Integer.parseInt(stk.nextToken());
	    int[] arr = new int[N];
	    
	    stk = new StringTokenizer(br.readLine());
	    for (int i = 0; i < N; i++)
	    	arr[i] = Integer.parseInt(stk.nextToken());
	    
	    Arrays.sort(arr);
	    
	    for (int i = 0; i < N; i++) {
	    	if (L < arr[i]) break;
	    	L++;
	    }
	    System.out.println(L);
	}
}