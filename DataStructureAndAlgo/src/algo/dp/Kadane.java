package algo.dp;

public class Kadane {
	public static void main(String args[]) {
		int a[] = {-2,1,-3,4,-1,2,1,-5,4};
		int currStart = 0; int start = 0; int end = 0;
		int max = Integer.MIN_VALUE; int currMax = 0;
		for(int i = 0; i < a.length ; i++) {
			if(currMax < 0) {
				currMax = a[i];
				currStart = i;
			} else {
				currMax += a[i];
			}
			if(currMax > max) {
				max = currMax;
				start = currStart;
				end  = i;
			}
		}
		System.out.println(max + " " + "from " + start + " - " +end);
		for(int i = start; i <= end; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
