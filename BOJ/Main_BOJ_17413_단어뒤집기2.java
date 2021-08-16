package IMpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_17413_단어뒤집기2 {
	
	static StringBuilder result;
	static Stack<Character> word;

	public static void main(String[] args) throws Exception {

		String s;
		Boolean isTag = false;

		result = new StringBuilder();
		word = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isTag == true) {
				if (c == '>')
					isTag = false;
				result.append(c);
			} else {
				if (c == '<') {
					isTag = true;
					if(!word.isEmpty()) appendWord();
					result.append(c);
				} else if (c == ' ') {
					appendWord();
					result.append(c);
				} else {
					word.push(c);
				}
			}
		}

		appendWord();

		System.out.println(result);

	}

	private static void appendWord() {
		while (!word.isEmpty()) {
			result.append(word.pop());
		}
	
		return;
	}

}
