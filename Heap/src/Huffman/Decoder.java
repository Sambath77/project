package Huffman;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class Decoder {

	// Instance variables
	private String myEncoded;
	private HuffNode myRoot;
	private StringBuilder decode;

	public Decoder(String encoded, HuffNode root) {
		myEncoded = encoded;
		myRoot = root;
		decode = new StringBuilder();
	}

	/*
	 * Method to find decode string
	 */
	public String decodeString() {

		try {
			if (myEncoded == null || myRoot == null) {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Encoded string is empty");
		}

		HuffNode child = myRoot;
		for (int i = 0; i < myEncoded.length(); i++) {
			if (myEncoded.charAt(i) == '0') {
				child = child.getLeft();
				if (child.getLeft() == null && child.getRight() == null) {
					decode.append(child.getChar());
					child = myRoot;
				}
			} else {
				child = child.getRight();
				if (child.getRight() == null && child.getRight() == null) {
					decode.append(child.getChar());
					child = myRoot;
				}
			}
		}
		return decode.toString();
	}

	/*
	 * Print Decode string
	 */
	public void printDecode(PrintStream write) {
		String myDecode = decodeString();
		System.out.print("Decoded String: " + myDecode);
		write.print("Decoded String: " + myDecode);
	}

}
