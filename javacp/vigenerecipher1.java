import java. util.*;
interface process{ 
	String generateKey(String str, String key);
	String cipherText(String str, String key);
}
class vignere1 implements process {
	public String generateKey(String str, String key) {
		int x = str.length();

		for (int i = 0; ; i++) {
			if (x == i)
				i = 0;
			if (key.length() == str.length())
				break;
			key += (key.charAt(i));
		}
		return key;
	}


	public String cipherText(String str, String key) {
		String cipher_text = "";

		for (int i = 0; i < str.length(); i++) {

			int x = (str.charAt(i) + key.charAt(i)) % 26;


			x += 'A';

			cipher_text += (char) (x);
		}
		return cipher_text;
	}
	static String originalText(String cipher_text, String key) {
		String orig_text = "";

		for (int i = 0; i < cipher_text.length() &&
				i < key.length(); i++) {

			int x = (cipher_text.charAt(i) -
					key.charAt(i) + 26) % 26;


			x += 'A';
			orig_text += (char) (x);
		}
		return orig_text;
	}

	static String LowerToUpper(String s) {
		StringBuffer str = new StringBuffer(s);
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(s.charAt(i))) {
				str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
			}
		}
		s = str.toString();
		return s;
	}

}
class vigenere1{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a string: ");

		String Str = sc.nextLine();

		vignere1 b= new vignere1();
		String Keyword = "RANDOM";

		String str = b.LowerToUpper(Str);
		String keyword = b.LowerToUpper(Keyword);

		String key = b.generateKey(str, keyword);
		String cipher_text = b.cipherText(str, key);

		System.out.println("Ciphertext : "
				+ cipher_text + "\n");

		System.out.println("Decrypted Text : "
				+ b.originalText(cipher_text, key));
	}
}


