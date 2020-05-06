package Huffman;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class HuffmanFrequencyTable {

	private String str;
	private static HashMap<Character, Integer> map;

	public HuffmanFrequencyTable(String newStr) {
		str = newStr;
		map = new HashMap<Character, Integer>();
	}

	/*
	 * Method to get frequency of characher
	 * @return HashMap
	 */
	public HashMap<Character, Integer> insertString() {

		try {
			if (str == null) {
				throw new NoSuchElementException();
			}
			if (str.length() < 2) {
				throw new NullPointerException();
			}
		} catch ( NoSuchElementException e) {
			System.out.println("String input is empty");
		} catch (NullPointerException e) {
			System.out.println("Minimum characters is two");
		}

		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if(map.containsKey(c)) {
				int fre = map.get(c);
				map.put(c,++fre);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}

}
