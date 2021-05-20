import java.util.Scanner;

public class MediaCurso {

	Node root;

	private class Node{
		private String key;
		private Double val;
		private Node left, right;
		public Node(String key, Double val){
			this.key = key;
			this.val = val;
		}
	}

	public void put(String key, double val){
		root = put(root, key, val);
	}

	private Node put(Node x, String key, double val){
		if (x == null)
			return new Node(key, val);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		return x;
	}

	public double get(String key){
		Node x = root;
		while (x != null){
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x.val;
		}
		return 0;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MediaCurso mediaCurso = new MediaCurso();
		mediaCurso.put("E", 17.32);
		mediaCurso.put("MB", 16);
		mediaCurso.put("B", 14.68);
		mediaCurso.put("B-", 13.32);
		mediaCurso.put("S", 12);
		mediaCurso.put("S-", 10.68);
		mediaCurso.put("I+", 9.32);
		mediaCurso.put("I", 8);
		mediaCurso.put("I-", 6.68);
		mediaCurso.put("F+", 4);
		mediaCurso.put("F", 0);
		int max= in.nextInt();
		
		double media=0;
		for(int i=0; i<=max; i++)
			media += mediaCurso.get(in.nextLine());
		System.out.println(media/max);

	}

}
