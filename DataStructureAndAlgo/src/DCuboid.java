import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class DCuboid {
	public DCuboid() throws Exception {
		/*BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("A-small-attempt0.in")));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("A-small-attempt0.out")));*/
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		int caseno = 0;
		while(T-- > 0) {
			String input[] = in.readLine().trim().split(" ");

			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int dimensions[] = new int[N];
			input = in.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				dimensions[i] = Integer.parseInt(input[i]);
			}
			caseno++;
			out.write("Case #"+caseno+":\n");
			while(M-- > 0) {
				input = in.readLine().trim().split(" ");
				int L = Integer.parseInt(input[0]);
				int R = Integer.parseInt(input[1]);
				double cuboidVolume = 1.0d;
				for(int i = L; i <= R; i++) {
					cuboidVolume *= dimensions[i];
				}
				double edge = nthroot(R-L+1, cuboidVolume);
				edge = Math.round( edge * 1000000000.0 ) / 1000000000.0;
				out.write(edge+ "\n");
			}
		}
		out.flush();
		
		
		
	}
	
	public double nthroot(int n, double x) {
		return nthroot(n, x, .0001);
	}

	public double nthroot(int n, double x, double p) {
		if (x < 0) {
			System.err.println("Negative!");
			return -1;
		}
		if (x == 0)
			return 0;
		double x1 = x;
		double x2 = x / n;
		while (Math.abs(x1 - x2) > p) {
			x1 = x2;
			x2 = ((n - 1.0) * x2 + x / Math.pow(x2, n - 1.0)) / n;
		}
		return x2;
	}
	
	public static void main(String args[]) throws Exception {
		new DCuboid();
	}
}
