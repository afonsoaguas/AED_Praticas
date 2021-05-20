import java.util.Scanner;

public class MergesortUpdated {

	private static boolean isSorted(int[] a, int lo, int hi){
		for (int i = lo; i < hi; i++)
			if (less(a[i], a[i-1]))
				return false;
		return true;
	}

	private static boolean less(Integer a, Integer b){
		return a.compareTo(b) < 0;
	}

	private static void exch(int[] arr, int i, int j){
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}

	public static void insertionSort(int[] arr, int lo, int hi){
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > 0; j--)
				if (less(arr[j], arr[j-1]))
					exch(arr, j, j-1);
				else break;
	}

	//implementa o algoritmo mergesort sobre o vetor a[]
	private static void merge(int[] a, int[] aux, int lo, int mid, int hi){
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(a[j], a[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		assert isSorted(a, lo, hi);
	}

	//ordena recursivamente o vetor a[]
	private static void sort(int[] a, int[] aux, int lo, int hi){
		if (hi <= lo) return;
		if (hi <= lo + 12 - 1){
			insertionSort(a, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		if (!less(a[mid+1], a[mid])) return;
		merge(a, aux, lo, mid, hi);
	}

	//cria cópia do vetor a[] e chama a função sort
	public static void sort(int[] a){
		int[] array = a.clone();
		sort(a, array, 0, a.length - 1);
		array = null;
	}

	//Main de teste
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);

		//1 – Recebe o tamanho do vetor
		int size= in.nextInt();

		//3 – Preenche o vetor com os inteiros que recebe a partir do Scanner
		int[] arr = new int[size];
		for(int i=0; i<size; i++)
			arr[i]=(in.nextInt());

		//4 - Chama a função sort com o vetor como argumento
		sort(arr);

		//5 – Imprime o vetor
		System.out.print(arr[0]);
		for(int j=1; j<arr.length; j++)
			System.out.print(" "+arr[j]);
		System.out.println();
	}
}
