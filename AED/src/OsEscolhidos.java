import java.util.Scanner;

public class OsEscolhidos {

	static Node first;


	private static class Node{
		int key;
		String val;
		Node next;
		Node(int key, String val) {
			this.key = key;
			this.val = val;
		}
	}

	public String get(int key){
		Node nd = first;
		while (nd != null) {
			if (nd.key == key)
				return nd.val;
			nd = nd.next;
		}
		return null;
	}

	public static void put(int key, String val) {
		first = put(first, key, val);
	}

	public static Node put(Node node, int key, String val){
		if (node == null)
			return new Node(key, val);
		if (node.key == key)
			node.val = val;
		else
			node.next = put(node.next, key, val);
		return node;
	}


	public int getLastRegister (String value){
		Node nd = first;
		int result = 0;
		while (nd != null) {
			if (value.compareTo(nd.val) == 0)
				result = nd.key;
			nd = nd.next;
		}
		return result;
	}

	public static void main(String[] args) {
		OsEscolhidos oe = new OsEscolhidos();
		Scanner in = new Scanner (System.in);
		int n = in.nextInt();
		//guarda os registos
		for (int i = 0; i < n; i++) {
			int register = in.nextInt();
			in.nextLine(); //para guardar o final de linha do in.nextInt()
			String agency = in.nextLine();
			oe.put(register, agency);
		}
		//Imprime os escolhidos
		System.out.println(oe.getLastRegister ("ESA") + " ESA");
		System.out.println(oe.getLastRegister ("NASA") + " NASA");
	}

}

