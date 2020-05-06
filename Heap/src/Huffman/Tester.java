package Huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Queue.PriorityQueue;

public class Tester {

	public Tester() {

	}

	public static void main(String[] args)  throws FileNotFoundException{
		String st = "Eerie eyes seen near lake.";
		String fileOut = "output.txt";
		File output = new File(fileOut);
		PrintStream write = new PrintStream(fileOut);
		PriorityQueue<HuffNode> queue = new PriorityQueue<HuffNode>();
		HuffmanFrequencyTable ft = new HuffmanFrequencyTable(st);
		HashMap<Character, Integer> myFre = ft.insertString();
		Set<Character> didPrint = new HashSet<Character>();
		for(int i = 0;i<st.length();i++)
		{
			char ch = st.charAt(i);
			if(!didPrint.contains(ch)) {
				queue.addElement(new HuffNode(ch, myFre.get(ch)), myFre.get(ch));
				didPrint.add(ch);
			}
		}

		HuffmanTree hmt = new HuffmanTree(queue);
		Encoder encode = new Encoder(hmt.getRoot(), st);
		HashMap<Character, String> myString = encode.buildCode();
		Decoder decode = new Decoder(encode.findEncoded(), hmt.getRoot());
		printTable(myFre, myString, st, write);
		System.out.println();
		encode.printEncode(write);
		decode.printDecode(write);
		write.close();
	}

	/*
	 * Method to print the output
	 * @param Hashmap map is to get frequency of character
	 * @param Hashmap myMap is to get code for character
	 * @param String str is the original string to input
	 */
	private static void printTable(HashMap<Character, Integer> map, HashMap<Character, String> newMap, String str, PrintStream write) {
		Set<Character> didPrint = new HashSet<Character>();
		System.out.println("Sample Output:\n");
		System.out.println("% Java Tester: " + " \"" + str + "\"");

		write.println("Sample Output:\n");
		write.println("% Java Tester: " + " \"" + str + "\"");

		for (int i = 0; i < 34; i++) {
			System.out.print("=");
		}

		for (int i = 0; i < 40; i++) {
			write.print("=");

		}

		String str0 = String.format("\n%s %14s %15s", "char", "frequency", "code");
		String str1 = String.format("\n%-20s %-20s %-20s", "char", "frequency", "code");
		System.out.println(str1);
		write.println(str0);

		for (int i = 0; i < 40; i++) {
			System.out.print("_");
			write.print("_");
		}

		System.out.println();
		write .println();
		for (int i = 0; i< str.length(); i++)
		{
			char ch = str.charAt(i);
			if(!didPrint.contains(ch)) {
				String str2 = String.format("%-22s %-30d %-20s\n", ch, map.get(ch), newMap.get(ch));
				String str3 = String.format("%-10s %-20d %-30s\n", ch, map.get(ch), newMap.get(ch));
				System.out.print(str2);
				write.print(str3);
				didPrint.add(ch);
			}
		}

		for (int i = 0; i < 34; i++) {
			System.out.print("=");
		}

		for (int i = 0; i < 40; i++) {
			write.print("=");
		}

	}
}
