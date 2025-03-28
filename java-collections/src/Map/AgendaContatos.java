package Map;
import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
	private Map<String, Integer> agendaContatoMap;
	
	public AgendaContatos() {
		this.agendaContatoMap = new HashMap<>();
	}
	
	public void adicionarContato(String nome, Integer telefone) {
		agendaContatoMap.put(nome, telefone);
	}
	
	public void removerContato(String nome) {
		if(!agendaContatoMap.isEmpty()) {
			agendaContatoMap.remove(nome);
		}
	}
	
	public void exibirContatos() {
		System.out.println(agendaContatoMap);
	}
	
	public Integer pesquisarPorNome(String nome) {
		Integer numeroPorNome = null;
		
		if(!agendaContatoMap.isEmpty()) {
			numeroPorNome = agendaContatoMap.get(nome);
		}
		
		return numeroPorNome;
	}
	
	public static void main(String[] arg) {
		AgendaContatos ac = new AgendaContatos();
		
		ac.adicionarContato("Pedro", 123456789);
//		ac.adicionarContato("Pedro", 123456789); // Atualiza o valor anterior dessa chave
		ac.adicionarContato("Maria", 987654321);
		ac.adicionarContato("João", 456789123);
		ac.adicionarContato("Ana", 741852963);
		ac.adicionarContato("Carlos", 369258147);
		
		ac.removerContato("Maria");
		
		ac.exibirContatos();
	}
}
