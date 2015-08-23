package algo.stringmatching;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//rolling hash
public class RabinKarp {
    public static void main(String args[] ) throws Exception {
        int prime = 7;
        int[] primePow = new int[100005];
        primePow[0] = 1;
        for(int k = 1; k< 100005; k++){
        	  primePow[k] = prime * primePow[k -1];
        }
  
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String input = br.readLine();
         
         int[] arr = new int[input.length() +1];
         
         arr[0] = 0;
         int h = 0;
         for(int j = 1; j<= input.length(); j++){
                h = 	7 * h + input.charAt(j-1);
                arr[j] = h; 
         }
         
         String line = br.readLine();
         int N = Integer.parseInt(line);
         int l1,r1,l2,r2;
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < N; i++) {
         	line = br.readLine();
         	String[] sp = line.split(" ");
         	l1 = Integer.parseInt(sp[0]);
         	r1 = Integer.parseInt(sp[1]);
         	l2 = Integer.parseInt(sp[2]);
         	r2 = Integer.parseInt(sp[3]);
         	
         	if((arr[r1] - arr[l1-1] * primePow[r1 -l1 +1] ) == 
         						(arr[r2] - arr[l2-1]* primePow[r2 -l2 +1])) {
         	    sb.append("Yes\n");
         	}else{
         		sb.append("No\n");
         	}
         }
         System.out.println(sb.toString());
    }


}
