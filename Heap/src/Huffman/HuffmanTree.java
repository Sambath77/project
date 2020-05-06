package Huffman;

import java.util.NoSuchElementException;

import Queue.PriorityQueue;

public class HuffmanTree {

	// Instance variables
	private HuffNode root;
	private PriorityQueue<HuffNode> queue;

	public HuffmanTree(PriorityQueue<HuffNode> que) {
		queue = que;
		buildHuffmanTree();
	}

	/*
	 * Method to build Huffman tree
	 */
	public void buildHuffmanTree() {
		try {
			if (queue == null) {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			System.out.println("The queue is empty");
		}
		while (queue.getSize() > 1) {
			HuffNode first = queue.removeNext();
			HuffNode second = queue.removeNext();
			int parent = first.getFre() + second.getFre();
			HuffNode newNode = new HuffNode((Character) null, parent);
			newNode.setLeft(first);
			newNode.setRight(second);
			queue.addElement(newNode, parent);
		}
		root = queue.getRoot();
	}

	/*
	 * Method to return a root of tree
	 */
	public HuffNode getRoot() {
		return root;
	}
}
