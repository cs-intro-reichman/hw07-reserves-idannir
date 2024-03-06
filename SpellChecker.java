
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
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		String a = word1.toLowerCase();
		String b = word2.toLowerCase();
		int length = 0;
		if (word1.length() > word2.length())
		{
			length = word1.length;
		}
		else length = word2.length();
		if (length == 1) {
			
				if (a!=b) {
					return 1 + levenshtein(tail(a), tail(b));
				}
			else return 0 + levenshtein(tail(a), tail(b));
		}
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		// Your code here

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
	}

}
