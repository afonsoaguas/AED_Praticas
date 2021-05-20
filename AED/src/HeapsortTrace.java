import java.util.Scanner;

public class HeapsortTrace {

	private static void sink(char[] a, int k, int N){
		while (2*k <= N){
			int j = 2*k;
			if (j < N && less(a, j-1, j))
				j++;
			if (!less(a, k-1, j-1))
				break;
			exch(a, k, j);
			k = j;
		}
	}

	private static boolean less(char[] array, int a, int b){
		return Character.compare(array[a],array[b]) < 0;
	}

	private static void exch(char[] arr, int i, int j){
		char swap = arr[i-1];
		arr[i-1] = arr[j-1];
		arr[j-1] = swap;
	}

	public static void sort(char[] a){
		int N = a.length;
		for (int k = N/2; k >= 1; k--)
			sink(a, k, N);
		while (N > 1){
			exch(a, 1, N--);
			sink(a, 1, N);
			System.out.print(a[0]);
			for(int j=1; j<a.length; j++)
				System.out.print(" "+a[j]);
			System.out.println();
		}

	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String word = in.nextLine();

		int count=0;
		char[] arr = new char[(int)(word.length() /2.0 + 0.5)];
		for(int i=0; i< word.length(); i++){
			if (word.charAt(i) == (' '))
				count++;
			else
				arr[i-count] = (word.charAt(i));
		}

		sort(arr);
	}

}
