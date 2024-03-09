
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
		return str.substring(1);
	}
	
	public static String head(String str) {
		// Your code goes here
	
		return str.substring(0,1);
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		String a = word1.toLowerCase();
		String b = word2.toLowerCase();
		if (tail(a).length() == 0 ) {
			return tail(b).length() ;
		}	
		else if (tail(b).length() == 0) {
			return  tail(a).length() ;
		}
		
		if (head(a) == head(b)) {
			return  levenshtein(tail(a), tail(b));
		}
		else
		return (1 + Math.min(Math.min(levenshtein(tail(a), b), levenshtein(a, tail(b))), levenshtein(tail(a), tail(b))));
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
		// Your code goes here
		String similar = "";
		int edistance = 1000; /*random big number of edit distances */
		for(int i = 0; i < dictionary.length; i++)
		{
			if ( edistance > levenshtein(word, dictionary[i])) 
			{
				edistance = levenshtein(word, dictionary[i]);
				similar = dictionary[i];
			}
		}
		if (threshold >= edistance)
		{
			return similar;
		}
		return word;
	}

}
