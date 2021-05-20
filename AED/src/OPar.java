import java.util.Scanner;

public class OPar {
	int[] a;
	//Construtor: recebe o tamanho do vetor e o primeiro elemento. Preenche o
	//vetor.
	public OPar (int size, int first) {
		a = new int[size];
		for (int i = 0; i<a.length; i++)
			a[i] = first+i;
	}

	public boolean binarySearch(int[] a, int key){
		int lo = 0, hi = a.length-1;
		while (lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) 
				hi = mid - 1;
			else if (key > a[mid]) 
				lo = mid + 1;
			else 
				return true;
		}
		return false;
	}

	//Devolve o número total de pares cuja soma é 0
	public int checkPairs (){
		int count = 0; 
		int N=a.length;
		for (int i = 0; i < N; i++)
			if(binarySearch(a, -a[i])&&(a[i] !=0))
				count++;
		return count/2;
	}
	//função main para testar o algoritmo
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//tamanho do vetor
		int size = in.nextInt();
		//valor inicial
		int first = in.nextInt();
		OPar soma = new OPar(size,first);
		System.out.println(soma.checkPairs());
	}
}
