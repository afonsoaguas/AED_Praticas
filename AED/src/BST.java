import java.util.LinkedList;
import java.util.Scanner;

public class BST {

	Node root;

	//Classe Nó
	private class Node{
		private int key;
		private String val;
		private Node left, right;
		private int count;
		public Node(int key, String val){
			this.key = key;
			this.val = val;
		}
	}

	//Associa o valor à chave na BST
	public void put(int key, String val){
		root = put(root, key, val);
	}

	//Associa o valor à chave na BST. Se o nó já existir, substitui
	//o seu valor pelo recebido
	private Node put(Node x, int key, String val){
		if (x == null)
			return new Node(key, val);
		if (key<x.key)
			x.left = put(x.left, key, val);
		else if (key>x.key)
			x.right = put(x.right, key, val);
		else if (key==x.key)
			x.val = val;
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	//Devolve a posição da chave key
	public int rank(int key){
		return rank(key, root);
	}

	private int rank(int key, Node x){
		if (x == null)
			return 0;
		if (key<x.key)
			return rank(key, x.left);
		else if (key>x.key)
			return 1 + size(x.left) + rank(key, x.right);
		else
			return size(x.left);
	}

	//Devolve o valor double correspondente à chave recebida, ou 0
	//se não encontrar a chave
	public String get(int key){
		Node x = root;
		while (x != null){
			if (key<x.key)
				x = x.left;
			else if (key>x.key)
				x = x.right;
			else
				return x.val;
		}
		return null;

	}

	//Devolve o tamanho da BST
	public int size(){
		return root.count;
	}

	private int size(Node x){ //perguntar se é preciso adicionar
		if (x == null)
			return 0;
		return x.count;
	}

	//Devolve a chave do nó k
	public int select(int k){
		return select(root, k).key;
	}

	//Devolve o Nó que contém a key da classificação (rank) k
	private Node select(Node x, int k){
		if (x == null)
			return null;
		int leftSize = size(x.left);
		if (leftSize > k)
			return select(x.left,  k);
		else if (leftSize < k)
			return select(x.right, k - leftSize - 1); 
		else
			return x;
	}

	//Iterador de chaves
	public Iterable<Integer> keys(){
		LinkedList<Integer> q = new LinkedList<Integer>();
		inorder(root, q);
		return q;

	}

	private void inorder(Node x, LinkedList<Integer> q){
		if (x == null)
			return;
		inorder(x.left, q);
		q.add(x.key);
		inorder(x.right, q);
	}

	//Verifica se o rank e o select devolve a classificação e chave
	//correta.
	private boolean checkRankSelect(){
		for (int i = 0; i < size()-1; i++)
            if (i != rank(select(i)))
            	return false;
        for (int key : keys())
            if (key>select(rank(key)) || key<select(rank(key)))
            	return false;
        return true;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		BST bst = new BST();

		//preenche a BST
		int max = in.nextInt();
		for (int i = 0; i < max; i++)
			bst.put(in.nextInt(), in.nextLine());
		System.out.println(bst.checkRankSelect());
	}

}
