import java.util.Scanner;

public class ShellsortUnderMicroscope {

	private static boolean isSorted(char[] a){
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i-1]))
				return false;
		return true;
	}

	private static boolean less(char a, char b){
		return Character.compare(a,b) < 0;
	}

	private static void exch(char[] arr, int i, int j){
		char swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}

	public static void sort(char[] a){
		int N = a.length;
		int h = 1;
		while (h < N/3) h = 3*h + 1;
		while (h >= 1){
			for (int i = h; i < N; i++)
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
					exch(a, j, j-h);
			h = h/3;
			if(!isSorted(a)){
				System.out.print(a[0]);
				for(int j=1; j<a.length; j++)
					System.out.print(" "+a[j]);
				System.out.println();
			}
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

		System.out.print(arr[0]);
		for(int j=1; j<arr.length; j++)
			System.out.print(" "+arr[j]);
		System.out.println();
	}

}
