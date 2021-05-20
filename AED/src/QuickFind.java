//LAB_2A

import java.util.Scanner;

public class QuickFind {

	int [] v;
	int count;

	public QuickFind (int size) {

		v=new int[size];
		count=size;

		for(int i=0; i<size; i++)
			v[i]=i;
	}

	public int count() {

		return count;
	}

	public int find (int site) {

		return v[site];
	}

	public boolean connected (int site1, int site2) {

		return v[site1] == v[site2];
	}

	public void union(int site1, int site2) {
		if(v[site1]!=v[site2]){
			int id1 = v[site1];
			int id2 = v[site2];
			for (int i = 0; i < v.length; i++)
				if (v[i] == id1) {
					v[i] = id2;
				}
			count--;
		}

	}

	public static void main(String[] args) {

		//inicializa variáveis e classe QuickFind
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		QuickFind qf = new QuickFind(size);
		int nTest = in.nextInt();
		//testes dos métodos find, connected, union e count
		while (nTest>0){
			int site1 = in.nextInt();
			int site2 = in.nextInt();
			System.out.println(qf.find(site1));
			System.out.println(qf.connected(site1, site2));
			qf.union(site1, site2);
			System.out.println(qf.connected(site1, site2));
			System.out.println(qf.count());
			nTest--;

		}
	}

}
