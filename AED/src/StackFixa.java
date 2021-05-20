import java.util.Scanner;

public class StackFixa {

	private String[] s;
	private int N = 0;

	//Construtor da classe. Cria uma stack com o tamanho do valor que recebe como argumento
	public StackFixa (int size){
		s = new String[size];
	}

	//Verifica se a stack está vazia. Devolve true se não tiver elementos
	public boolean isEmpty(){
		return N == 0;
	}

	//Devolve o tamanho da stack
	public int size(){
		return N;

	}

	//Insere o elemento na stack que recebe como argumento
	public void push(String item){
		s[N++] = item;

	}

	//Retira um elemento da stack
	public String pop(){
		String item = s[--N];
		 s[N] = null;
		 return item;

	}

	//Verifica se a stack está totalmente preenchida
	public boolean isFull(){
		return N == s.length;
	}

	//Verifica se a stack tem pelo menos metade das posições preenchidas
	public boolean isHalfFull(){
		return N >= (s.length/2);
	}

	// Retira o número de elementos da stack que recebe como argumento. Devolve o último elemento
	//retirado
	public String popLarge(int n){
		for(int i=0; i< n; i++)
			N--;
		return s[N];
	}

	//função main para testar o algoritmo
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		//tamanho da stack
		int size = in.nextInt();
		StackFixa sf = new StackFixa(size);
		//testes: push:1, pop:2, poplarge: 3, exit:4
		int pushpop = in.nextInt();
		while (pushpop != 4) {
			if (pushpop == 1) {
				in.nextLine(); //para guardar o final de linha do in.nextInt()
				sf.push(in.nextLine());
			}
			else if (pushpop == 2)
				System.out.println(sf.pop());
			else if (pushpop == 3){
				int large = in.nextInt();
				if (sf.size()>large)
					System.out.println(sf.popLarge(large));
			}
			pushpop = in.nextInt();
			System.out.println(sf.size() + " " + sf.isEmpty() + " " + sf.isFull() + " " + sf.isHalfFull());
		}
	}


}
