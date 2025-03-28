package List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListaTarefas {
	static ArrayList<Tarefa> bdTarefas = new ArrayList<Tarefa>();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String arg[]) {
		Boolean continuar = true;
		int opcao = 0;

		while(continuar) {
			try {
				System.out.println("0 - Parar\n1 - Adicionar Tarefa\n2 - Remover Tarefa\n3 - Obter Número Total de Tarefas\n4 - Obter Descrição das Tarefas\nSua opção:");
				opcao = input.nextInt();
				
				switch(opcao) {
					case 0:
						continuar = false;
						break;
					case 1:
//						System.out.println("Adicionando Tarefa");
						input.nextLine();
						adicionarTarefa();
						break;
					case 2:
//						System.out.println("Removendo Tarefa");
						input.nextLine();
						removerTarefa();
						break;	
					case 3:
//						System.out.println("Obtendo número total de tarefas");
						obterNumeroTarefas();
						input.nextLine();
						break;
					case 4:
//						System.out.println("Obtendo descrição das tarefas");
						obterDescricoesTarefas();
						input.nextLine();
						break;
					default:
						System.out.println(">>> Insira uma opção válida!");
						input.nextLine();
						break;
				}
				
			}catch(InputMismatchException ims) {
				System.out.println(">>> Insira um número inteiro!");
				input.nextLine(); // clear the invalid input from the scanner, 
			}
		}
		input.close();
	}
	
	private static void adicionarTarefa() {
		Tarefa tarefa = new Tarefa();
		Boolean continuar = true;
		
		while(continuar) {
			try {
				System.out.println("Insira a descrição da tarefa: ");			
				tarefa.setDescricao(input.nextLine().toLowerCase());
				
				bdTarefas.add(tarefa);
				
				continuar = false;
				
			}catch(NoSuchElementException ims) {
				System.out.println(">>> Insira um texto!");
				continuar = true;
			}			
		}
	}
	
	private static void removerTarefa() {
		String descricao = "";
		Tarefa tarefa=null;
 		System.out.println("Qual a descrição da tarefa que deve ser excluída?");
		descricao = input.nextLine();
			
		for(Tarefa t: bdTarefas) {
			if(descricao.toLowerCase().equals(t.getDescricao())) {
				tarefa = t;
			}
		}
		
		bdTarefas.remove(tarefa);
	}
	
	private static void obterNumeroTarefas() {
		System.out.println("Há " + bdTarefas.size() + " tarefas no total");
	}
	
	private static void obterDescricoesTarefas() {
		bdTarefas.forEach((tarefa) -> {
			System.out.println(tarefa.getDescricao());
		});
	}
}
