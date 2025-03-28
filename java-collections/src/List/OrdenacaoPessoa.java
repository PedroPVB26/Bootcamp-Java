package List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {
	private List<Pessoa> pessoaList;

	public OrdenacaoPessoa() {
		super();
		this.pessoaList = new ArrayList<>();
	}
	
	public void adicionarPessoa(String nome, int idade, double altura) {
		pessoaList.add(new Pessoa(nome, idade, altura));
	}
	
	// ORDENANDO -- COMPARABLE
	public List<Pessoa> ordenarPorIdade(){
		List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
		
		Collections.sort(pessoasPorIdade); // O método vai entender que ele deverá ordenar pelo atributo definido em "compareTo" da classe Pessoa.
		
		return pessoasPorIdade;
	}
	
	public List<Pessoa> ordenarPorAltura(){
		List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
		
		Collections.sort(pessoasPorAltura, new ComparatorPorAltura()); // Entende que o método para ordenar está na class ComparatorPorAltura.
		
		return pessoasPorAltura;
	}
	
	// Testando
	public static void main(String[] args) {
		OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();
		
		ordenacaoPessoa.adicionarPessoa("Nome 1", 20, 1.40);
		ordenacaoPessoa.adicionarPessoa("Nome 2", 10, 1.90);
		ordenacaoPessoa.adicionarPessoa("Nome 3", 19, 1.84);
		ordenacaoPessoa.adicionarPessoa("Nome 4", 23, 1.60);
		
		System.out.println(ordenacaoPessoa.ordenarPorIdade());
		System.out.println(ordenacaoPessoa.ordenarPorAltura());
	}
}
