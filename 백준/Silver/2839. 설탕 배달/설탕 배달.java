import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
	    int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
	    System.out.println(getAns(N));
	}
	
	public static int getAns(int N) {
		int cnt = 0;
		
	    while (true) {
	    	if (N < 3 * cnt) 
	    		return -1;
	    	if ((N - 3 * cnt) % 5 == 0) 
	    		return cnt + (N - 3 * cnt) / 5;
	    	cnt++;
	    }
	}
}