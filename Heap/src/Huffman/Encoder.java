package Huffman;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Encoder {

	// instance variables
	private HashMap<Character, String> code;
	private HuffNode myRoot;
	private String string;


	/*
	 * Constructer
	 */
	public Encoder(HuffNode root, String str) {

		try {
			if (root == null) {
				throw new NullPointerException();
			}
			if(str == null) {
				throw new NoSuchElementException();
			}
		} catch (NullPointerException e) {
			System.out.println("Root is null");
		} catch (NoSuchElementException e) {
			System.out.println("The string is empty");
		}
		string = str;
		code = new HashMap<Character, String>();
		myRoot = root;
	}

	/*
	 * Build code for each character
	 * @param none
	 * @return HashMap
	 */
	public HashMap<Character, String> buildCode() {
		travelTree(myRoot, "");
		return code;
	}

	/*
	 * Method to find the each character's code
	 * @param HuffNode myRoot is root of the tree
	 * @param String cur is string code
	 */
	public  void travelTree(HuffNode myRoot, String cur) {
		if (myRoot == null) {
			return;
		}
		if (myRoot.getChar() == null) {
			if (myRoot.getLeft() != null) {
				travelTree(myRoot.getLeft(), cur + "0");
			}
			if (myRoot.getRight() != null) {
				travelTree(myRoot.getRight(), cur + "1");
			}

		} else {
			code.put(myRoot.getChar(), cur);
		}

	}

	/*
	 * Find the encoded bits stream
	 *
	 */
	public String findEncoded() {
		HashMap<Character, String> newCode = buildCode();
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			st.append(newCode.get(string.charAt(i)));
		}
		return st.toString();
	}

	/*
	 * find the total bits code
	 */
	public int calculateBite() {
		int sum = 8 * string.length();
		return sum;
	}

	public void printEncode(PrintStream write) {
		String str = findEncoded();
		int total = calculateBite();
		System.out.println("Encoded bit stream:\n" + str);
		System.out.println("\nTotal number of bits without Huffman coding "
								+ "( 8-bits per character ) : " + total);
		System.out.println("Total number of bits with Huffman coding: " +  str.length());

		write.println("\nEncoded bit stream:\n" + str);
		write.println("\nTotal number of bits without Huffman coding "
								+ "( 8-bits per character ) : " + total);
		write.println("Total number of bits with Huffman coding: " +  str.length());
	}
}
