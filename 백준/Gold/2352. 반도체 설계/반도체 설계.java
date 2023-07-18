import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] port = new int[N];
    	
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) 
    		port[i] = Integer.parseInt(stk.nextToken());
    	
    	int[] LIS = new int[N];
    	int size = 0;
    	
    	for (int i = 0; i < N; i++) {
    		int t = port[i];
    		int l = 0, r = size;
    		
    		while(l < r) {
    			int mid = (l + r) / 2;
    			
    			if (t < LIS[mid])
    				r = mid;
    			else
    				l = mid + 1;
    		}
    		LIS[r] = t;
    		if (r == size) size++;
    	}
    	System.out.println(size);
    }
	
}
