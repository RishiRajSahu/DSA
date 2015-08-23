package algo.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;


//https://www.hackerrank.com/challenges/candies
public class Candies {

    public static void main(String[] args) throws Exception {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int rating[] = new int[N];
        int count[] = new int[N];
        for(int i = 0; i < N; i++) {
            rating[i] = Integer.parseInt(in.readLine().trim());
        }
        boolean complete = true;
        while(complete) {
        	complete = false;
            for(int i = 0; i < N; i++) {
				if (i == 0) {
					if (rating[0] > rating[1] && count[0] <= count[1]) {
						count[0] = count[1] + 1;
						complete = true;
					}
				} else if (i == N - 1) {
					if (rating[N - 1] > rating[N - 2] && count[N - 1] <= count[N - 2]) {
						count[N - 1] = count[N - 2] + 1;
						complete = true;
					}
				} else {
	                if(rating[i] > rating[i+1] && count[i] <= count[i+1]) {
	                	//System.out.println("one");
	                	count[i] = count[i+1] +1;
                		complete = true;
	                }
	                else if(rating[i] > rating[i-1] && count[i] <= count[i-1]) {
	                	//System.out.println("two");
	                	count[i] = count[i-1] +1;
	                	complete = true;
	                }
				}
            }
           //System.out.println(complete);
        }
        
        int result = 0;
        for(int i = 0; i < N; i++) {
            result += count[i];
        }
        result += N;
        
        System.out.println(result);
        
    }
}