package programming.others;

public class StringReplace {
	public static void main(String args[]) {
		String input = "this string  contains     different no. of       White Spaces  in Between";
		System.out.println("intial : " + input.length());
		String tokens[] = input.split(" ");
		int len = 0;
		for(String token : tokens) {
			int length = token.length();
			System.out.println(":" +token + ": " + length);;
			len += length;
		}
		len += tokens.length;
		System.out.println("final : " + len);
		
	}
}
