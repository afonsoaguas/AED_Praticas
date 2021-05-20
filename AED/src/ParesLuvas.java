import java.util.Scanner;

public class ParesLuvas {

	private static boolean less(Integer v, Integer w){
		return v.compareTo(w) < 0; 
	}

	private static void exch(int[] a, int i, int j){
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	//Indicar os números que faltam
	public static int binarySearch(int[] a, int key){
		int lo = 0, hi = a.length-1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	//Implementam do algoritmo Quicksort no vetor a[] 
	//(não precisa de baralhar o vetor mas terá de particionar e ordenar recursivamente cada parte)
	private static int partition(int[] a, int lo, int hi){
		int i = lo, j = hi+1;
		while (true){
			while (less(a[++i], a[lo]))
				if (i == hi) break;
			while (less(a[lo], a[--j]))
				if (j == lo) break;

			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	private static void sort(int[] a, int lo, int hi){
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	public static void sort(int[] a){
		sort(a, 0, a.length - 1);
	}

	//Devolve o número de luvas guardadas no vetor b[] que não estão no vetor a[]
	public static int numberLostGloves(int a[], int b[]){
		int count = 0;
		for(int i=0; i<a.length; i++)
			if (binarySearch(b,a[i]) == -1)
				count++;
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		//recebe o total de luvas da mão esquerda e cria um vetor para guardá-las
		int numbEsq= in.nextInt();
		int[] esq=new int[numbEsq]; 
		//recebe os tamanhos das luvas da mão esquerda e guarda-as no vetor
		for(int i=0; i<numbEsq; i++)
			esq[i]=in.nextInt();
		//repete o mesmo processo para as luvas da mão direita
		int numbDir= in.nextInt();
		int[] dir=new int[numbDir];
		for(int i=0; i<numbDir; i++)
			dir[i]=in.nextInt();
		//ordena os dois vetores que guardam as luvas
		sort(esq);
		sort(dir);
		//imprime o número de luvas da mão esquerda sem par
		System.out.println(numberLostGloves(esq,dir));

		//imprime o número de luvas da mão direita sem par
		System.out.println(numberLostGloves(dir,esq));

	}

}
