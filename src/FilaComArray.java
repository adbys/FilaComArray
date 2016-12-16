import java.util.Arrays;
import java.util.Scanner;
//Adbys José Vasconcelos de Andrade - 116110498

class FilaComArray {
	
		
		private static int[] array;
		private static int head;
		private static int tail;
		
		
		public static void queue(int size) {
			array = new int[size];
			head = -1;
			tail = -1;
		}
		
		
		public static int element() {
			if (isEmpty()) {
				return -1;
			}
				
			return array[head];
		}
		
		
		public static boolean isEmpty() {
			if (head == -1 && tail == -1){
				return true;
			} else {
				return false;
			}
		}
		
		
		public static boolean isFull() {
			if (tail == array.length-1) {
				return true;
			} else {
				return false;
			}
		}
		
		
		public static void add(int element) throws Exception {
			if (isFull()) {
				System.out.println("full");
			} else {
				if (tail == -1 && head == -1) {
					array[++head] = element;
					tail++;
				} else {
					array[++tail] = element;					
				}
				
			}
		}
		
		
		public static void remove() throws Exception {
			if (isEmpty()) {
				System.out.println("empty");
			} if (tail == head) {
				tail--;
				head--;
			} else {
				tail--;
				shift();				
			}
		}
		
		private static void shift() {
			for (int i = 1; i <= tail; i++) {
				array[i-1] = array[i];
			}
		}
		
		public static String print(){
			if(isEmpty()) {
				return "empty";
			} else {
				String out = "";
				for (int i = head; i <= tail; i++) {
					out += array[i] + " ";
				}
				return out.trim();
			}
			
		}
			
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
		
			int size = sc.nextInt();
			sc.nextLine();
			queue(size);
			
			String opcao = sc.nextLine();
		
			while (opcao != "end") {
				
				String[] opcao2 = opcao.split(" ");
		
				switch (opcao2[0]) {
		
					case "print":
						System.out.println(print());
						break;
						
					case "element":
						System.out.println(element());
						break;
						
					case "add":
						try {
							add(Integer.parseInt(opcao2[1]));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					
					case "remove":
						try {
							remove();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
						
					case "end":
						System.exit(0);
						break;
		
				}
			
				opcao = sc.nextLine();
		
			}
			
		}


}
