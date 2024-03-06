
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		return str;
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		String a = word1.toLowerCase();
		String b = word2.toLowerCase();
		if (tail(a).length() == 0 && tail(b).length()==0) 
			return 0;
		if (a.charAt(0)!= b.charAt(0)) {
			return 1 + levenshtein(tail(a), tail(b));
		}
		else
		return 0 + levenshtein(tail(a), tail(b));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		// Your code here
		for (int i=0; i<dictionary.length; i++)
		{
			dictionary[i] = in.readString();
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		String str = "";
		// Your code goes here
		return str;
	}

}
