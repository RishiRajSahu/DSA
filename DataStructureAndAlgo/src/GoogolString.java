import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class GoogolString {
	StringBuilder longS = new StringBuilder("0");
	public void prepare() {
		//double length = Math.pow(10, 5);
		for(double i = 1; i < 22; i++) {
			longS.append("0");
			reverseSwitchStr();			
		}
	}
	
	
	public void reverseSwitchStr( ) {
		for(int i = longS.length() - 2; i >= 0 ; i--) {
			if(longS.charAt(i) == '0')
				longS.append("1");
			else 
				longS.append("0");
		}
	}
	
	public GoogolString() throws Exception {
		prepare();
		/*BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("A-small-attempt0.in")));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("A-small-attempt0.out")));*/
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		/*for(int p = 0 ; p < prev.length; p++) {
			System.out.print(prev[p]);
		}
		System.out.println("adfs");*/
		System.out.println(longS.length());
		int T = Integer.parseInt(in.readLine());
		int caseno = 0;
		while(T-- > 0) {
			caseno++;
			int k = Integer.parseInt(in.readLine());
			if(k < longS.length()) {
				char charac = longS.charAt(k-1);
				out.write("Case #"+caseno+": "+charac+"\n");
			} else {
				
			}
		}
		out.flush();
	}
	
	
	public static void main(String args[]) throws Exception {
		new GoogolString();
	}
}
