package Huffman;

public class HuffNode {

	public Character myChar;
	public int myFre;
	public HuffNode myLeft, myRight;


	public HuffNode(Character cha, int fre) {
		myChar = cha;
		myFre = fre;
		myLeft = null;
		myRight = null;

	}

	public Character getChar() {
		return myChar;
	}

	public void setChar(Character newChar) {
		myChar = newChar;
	}

	public int getFre() {
		return myFre;
	}

	public void setFre(int newFre) {
		myFre = newFre;
	}

	public HuffNode getLeft() {
		return myLeft;
	}

	public void setLeft(HuffNode newLeft) {
		myLeft = newLeft;
	}

	public HuffNode getRight() {
		return myRight;
	}

	public void setRight(HuffNode newRight) {
		myRight = newRight;
	}


}
