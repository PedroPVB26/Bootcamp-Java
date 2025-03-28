package Map;
import java.util.Map;
import java.util.HashMap;

public class EstoqueProdutos {
	private Map<Long, Produto> estoqueProdutoMap;
	
	public EstoqueProdutos() {
		this.estoqueProdutoMap = new HashMap<>();
	}
	
	public void adicionarProduto(long codigo, String nome, int quantidade, double preco) {
		estoqueProdutoMap.put(codigo, new Produto(nome, quantidade, preco));
	}
	
	public void exibirProdutos() {
		System.out.println(estoqueProdutoMap);
	}
	
	public double calcularValorTotalEstoque() {
		double valorTotal = 0d;
		
		if(!estoqueProdutoMap.isEmpty()) {
			for(Produto produto: estoqueProdutoMap.values()) {
				valorTotal += produto.getPreco() * produto.getQuantidade();
			}
		}
	
		return valorTotal;
	}
	
	public Produto obterProdutoMaisCaro() {
		Produto produtoMaisCaro = null;
		double maiorPreco = Double.MIN_VALUE; // O 1° produto automaticamente será o maior preço
		
		if(!estoqueProdutoMap.isEmpty()) {
			for(Produto p: estoqueProdutoMap.values()) {
				if(p.getPreco() > maiorPreco) {
					produtoMaisCaro = p;
					maiorPreco = p.getPreco();
				}
			}			
		}
		
		return produtoMaisCaro;
	}
	
	public Produto obterProdutoMaisBarato() {
		Produto produtoMaisBarato = null;
		double menorPreco = Double.MAX_VALUE;
		
		if(!estoqueProdutoMap.isEmpty()) {
			for(Produto p: estoqueProdutoMap.values()) {
				if(p.getPreco() < menorPreco) {
					produtoMaisBarato = p;
					menorPreco = p.getPreco();
				}
			}			
		}
		
		return produtoMaisBarato;
	}
	
	public static void main(String[] args) {
		EstoqueProdutos estoque = new EstoqueProdutos();
		
		estoque.adicionarProduto(1L, "Produto A", 10, 5.0);
		estoque.adicionarProduto(2L, "Produto B", 20, 10.0);
		estoque.adicionarProduto(3L, "Produto C", 15, 7.0);
		estoque.adicionarProduto(4L, "Produto D", 30, 12.0);
		estoque.adicionarProduto(5L, "Produto E", 25, 9.0);
		
		System.out.println("Valor total do estoque: " + estoque.calcularValorTotalEstoque());
		System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());
		System.out.println("Produto mais barato: " + estoque.obterProdutoMaisBarato());
	}
}
