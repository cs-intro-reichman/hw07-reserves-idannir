
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
		String newstr ="";
		for(int i=1; i<str.length(); i++)
		{
			newstr += str.charAt(i);
		}
		return newstr;
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		String a = word1.toLowerCase();
		String b = word2.toLowerCase();
		if (tail(a).length() == 0 || tail(b).length()==0) {
		if (tail(a).length() > tail(b).length()) {
			return tail(a).length() - tail(b).length() ;
		}	
		else
			return tail(b).length() - tail(a).length() ;
		}
		if (a.charAt(0)!= b.charAt(0)) {
			return 1 + levenshtein(tail(a), tail(b));
		}
		else
		return levenshtein(tail(a), tail(b));
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
		String similar = "";
		int edistance = 0;
		for(int i =0; i<dictionary.length; i++)
		{
			if ( edistance > levenshtein(word, dictionary[i])) 
			{
				edistance = levenshtein(word, dictionary[i]);
				similar = dictionary[i];
			}
		}
		if (threshold > edistance)
		{
			return similar;
		}
		return word;
	}

}
