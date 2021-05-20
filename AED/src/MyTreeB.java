import java.util.Scanner;

public class MyTreeB {

	//N� da ra�z
	private Node root;

	//Cores dos n�s
	private static final boolean RED = true;
	private static final boolean BLACK = false;

	//Representa os N�s da �rvore.
	private class Node{
		int key;
		String val;
		Node left, right;
		boolean color; 
		public Node(int key, String val, boolean color) {
			this.key = key;
			this.val = val;
			this.color = color;
		}
	}

	//Verifica se o N� x tem liga��o vermelha
	private boolean isRed(Node x){
		if (x == null)
			return false;
		return x.color == RED;
	}

	//Insere um novo n� na �rvore
	public void put(int key, String val){
		root = put(root, key, val);
		root.color = BLACK;
	}

	private Node put(Node h, int key, String val){
		if (h == null)
			return new Node(key, val, RED);
		if (key<h.key)
			h.left = put(h.left, key, val);
		else if (key>h.key)
			h.right = put(h.right, key, val);
		else
			h.val = val;
		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);
		return h;
	}

	//Orienta uma liga��o vermelha (temporariamente) inclinada para a
	//direita para inclinar para a esquerda
	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	//Orienta uma liga��o vermelha inclinada para a esquerda para
	//inclinar-se para a direita (temporariamente).
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	//Altera a cor do n� para dividir um n� (tempor�rio) de 4
	private void flipColors(Node h){
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	//Verifica se a �rvore est� equilibrada
	public boolean isBalanced(){
		int black = 0;
        Node x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;
        }
        return isBalanced(root, black);
	}
	
	private boolean isBalanced(Node node, int blackNodes){
		if (node == null)
			return blackNodes == 0;
        if (!isRed(node))
        	blackNodes--;
        return isBalanced(node.left, blackNodes) && isBalanced(node.right, blackNodes);
	}

	public static void main(String[] args){
		Scanner in = new Scanner (System.in);
		MyTreeB mt = new MyTreeB();
		int nodes = in.nextInt();
		for (int i = 0; i < nodes; i++)
		mt.put(in.nextInt(), in.nextLine());
		System.out.println(mt.isBalanced());
	}

}
