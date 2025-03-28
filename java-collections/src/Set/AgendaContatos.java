package Set;
import java.util.HashSet;

public class AgendaContatos {
	private static HashSet<Contato> listaContatos = new HashSet<Contato>();;

	
	public static void adicionarContato(String nome, int numero) {
		listaContatos.add(new Contato(nome, numero));
	}
	
	public static void exibirContatos() {
		listaContatos.forEach((contato) ->{
			System.out.println("---");
			System.out.println(contato.getNome());
			System.out.println(contato.getNumero());
		});
	}
	
	public static HashSet<Contato> pesquisarPorNome(String nome){
		HashSet<Contato> listaContatosEncontrados = new HashSet<Contato>();
		
		listaContatos.forEach((contato) -> {
			if(contato.getNome().equals(nome)) {
				listaContatosEncontrados.add(contato);
			}
		});
		
		return listaContatosEncontrados;
	}
	
	public static void atualizarNumeroContato(String nome, int novoNumero) {
		listaContatos.forEach((contato) -> {
			if(contato.getNome().equals(nome)) {
				contato.setNumero(novoNumero);
			}
		});
	}
	
	public static void main(String[] arg) {
		adicionarContato("Pedro", 123);
		adicionarContato("Paulo", 345);
		adicionarContato("Valente", 678);
		
		atualizarNumeroContato("Pedro", 333);
		
		exibirContatos();
	}
}
