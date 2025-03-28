package Set;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
	private Set<Produto> listaProdutos;

	public CadastroProdutos() {
		super();
		this.listaProdutos = new HashSet<>();
	}
	
	public void adicionarProduto(int codigo, String nome, double preco, int quantidade) {
		listaProdutos.add(new Produto(nome, codigo, preco, quantidade));
	}
	
	
	public Set<Produto> exibirProdutosPorNome(){
		Set<Produto> produtosPorNome = new TreeSet<>(listaProdutos); // Vai organizar os produtos por nome, já que isso que foi definido na classe Produto.
		return produtosPorNome;
	}
	
	public Set<Produto> exibirProdutosPorPreco(){
		Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco()); // A forma de ordenação que será utilizada está na classe ComparatorPorPreco
		produtosPorPreco.addAll(listaProdutos);
		
		return produtosPorPreco;
	}
	
	public static void main(String[] arg) {
		CadastroProdutos cadastroProdutos = new CadastroProdutos();
		cadastroProdutos.adicionarProduto(1001, "Notebook Dell", 3500.50, 10);
		cadastroProdutos.adicionarProduto(1002, "Smartphone Samsung", 2200.75, 15);
		cadastroProdutos.adicionarProduto(1003, "Monitor LG", 899.99, 8);
		cadastroProdutos.adicionarProduto(1004, "Teclado Mecânico", 250.00, 20);

//		System.out.println(cadastroProdutos.exibirProdutosPorNome());
		System.out.println(cadastroProdutos.exibirProdutosPorPreco());
		
	}
}
