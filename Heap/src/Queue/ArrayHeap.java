package Queue;

import Huffman.HuffNode;

public class ArrayHeap<T> {

	private PriorityQueueNode<T>[] myHeap;
	private int size;

	public ArrayHeap() {
		myHeap = new PriorityQueueNode[100];
		size = 0;
	}


	/*
	 * Add new node to the array heap
	 * @param PriorityQueueNode nod
	 * @return PriorityQueuNode<t>[]
	 */
	public PriorityQueueNode<T>[] addElement(PriorityQueueNode<T> node) {
		try {
			if (node == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.println("The node is null");
		}
		myHeap[size] = node;
		int ind = size;
		size++;
		while (ind != 0 && (ind - 1) / 2 >= 0) {
			if (myHeap[ind].compareTo(myHeap[(ind - 1) / 2]) == -1) {
				swap(ind,(ind - 1) / 2);
			}
			ind = (ind - 1) / 2;
		}
		return myHeap;
	}

	/*
	 * Swap parent and child node
	 * @param PriorityQueueNode child and parent
	 * @return non;
	 */
	private void swap(int child, int parent) {

		PriorityQueueNode temp = myHeap[child];
		myHeap[child] = myHeap[parent];
		myHeap[parent] = temp;

	}

	public  PriorityQueueNode<T> removeMin() {
		PriorityQueueNode<T> temp = myHeap[0];
		myHeap[0] = myHeap[size - 1];
		heapifyDown(0);
		size--;
		return temp;
	}

	private void heapifyDown(int i) {
		int smallest = i;
		if ((2 * i + 1) < size && myHeap[smallest].compareTo(myHeap[2 * i + 1]) == 1) {
			smallest = 2 * i + 1;
		}
		if ((2 * i + 2) < size && myHeap[smallest].compareTo(myHeap[2 * i + 2]) == 1) {
			smallest = 2 * i + 2;
		}
		if (smallest != i) {
			swap(i, smallest);
			heapifyDown(smallest);
		}

	}

	public HuffNode getRoot() {
		try {
			if (myHeap[0] == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.println("Array Heap is empty");
		}
		return myHeap[0].getElement();
	}

	public int getSize() {

		return size;
	}
}
