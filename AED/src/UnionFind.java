//LAB_2B

import java.util.Scanner;

public class UnionFind {

	int [] v;
	int[] id;
	int count;

	public UnionFind (int size) {

		v=new int[size];
		id=new int[size];
		count=size;

		for(int i=0; i<size; i++) {
			v[i]=i;
			id[i]=1;
		}
	}

	public int count() {

		return count;
	}

	public int find (int site) {

		while (site != v[site]) {
			site = v[site];
		}
		return site;
	}

	public boolean connected (int site1, int site2) {

		return find(site1) == find(site2);
	}

	public void union(int site1, int site2) {
		if(find(site1)!=find(site2)){
			int i = find(site1);
			int j = find(site2);
			if (i == j) return;
			if (id[i] < id[j]) { 
				v[i] = j; id[j] += id[i]; 
			}else{ 
				v[j] = i; id[i] += id[j];
			} 
			count--;
		}
	}


	public static void main(String[] args) {
		//inicializa variáveis e classe UnionFind
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		UnionFind uf = new UnionFind(size);
		int nTest = in.nextInt();
		//testes dos métodos find, connected, union e count
		while (nTest>0){
			int site1 = in.nextInt();
			int site2 = in.nextInt();
			System.out.println(uf.find(site1));
			System.out.println(uf.connected(site1, site2));
			uf.union(site1, site2);
			System.out.println(uf.connected(site1, site2));
			System.out.println(uf.count());
			nTest--;
		}

	}


}
