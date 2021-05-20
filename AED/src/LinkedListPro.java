import java.util.Scanner;

public class LinkedListPro {

	private Node first, last;

	private class Node{
		String item;
		Node next;
	}
	//Verifica se a LinkedList está vazia
	public boolean isEmpty(){
		return first == null;

	}
	//insere um novo item na LinkedList
	public void enqueue(String item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) 
			first = last;
		else 
			oldlast.next = last;
	}
	//retira um item da LinkedList
	public String dequeue(){
		String item = first.item;
		first = first.next;
		if (isEmpty()) 
			last = null;
		return item;

	}
	//verifica se um item se encontra na LinkedList
	public boolean find(String key) {
		for(Node i = first; i != null ; i=i.next)
			if ( i.item.equals(key))
				return true;
		return false;

	}
	//main de teste
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedListPro llp = new LinkedListPro();
		//enqueue
		int en = in.nextInt();
		in.nextLine();
		for (int i = 0; i < en; i++)
			llp.enqueue(in.nextLine());
		//dequeue
		int deq = in.nextInt();
		in.nextLine();
		for (int i = 0; i < deq; i++)
			llp.dequeue();
		//enqueue
		en = in.nextInt();
		in.nextLine();
		for (int i = 0; i < en; i++)
			llp.enqueue(in.nextLine());
		System.out.println(llp.find(in.nextLine()));
	}
}