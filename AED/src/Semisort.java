import java.util.Scanner;

public class Semisort {

	//Compara dois objetos do tipo Integer. Verifica se a é menor que b
	private static boolean less(Integer a, Integer b){
		return a.compareTo(b) < 0;
	}
	//Troca os elemenntos das posições i e j do vetor arr
	private static void exch(int[] arr, int i, int j){
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
	//Ordena o vetor arr parcialmente a partir do insertion sort na proporção recebida como parâmetro
	public static void sort(int[] arr, double p){
		int N =(int) (p * arr.length + 0.5);
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0; j--)
				if (less(arr[j], arr[j-1]))
					exch(arr, j, j-1);
				else break;
	}

	//Main de teste
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//1 – Recebe o tamanho do vetor
		int s = in.nextInt();
		//2 – Recebe a proporção do vetor a ordenar
		double p = in.nextDouble();
		//3 – Preenche o vetor com os inteiros que recebe a partir do Scanner
		int[] arr = new int[s];
		for(int i=0; i<s; i++)
			arr[i]=(in.nextInt());
		//4 - Ordena parcialmente o vetor
		sort(arr,p);
		//5 – Imprime o vetor parcialmente ordenado
		for(Integer val : arr)
			System.out.println(val);
	}

}