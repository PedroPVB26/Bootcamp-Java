import java.util.Map;
import java.util.Objects;
import java.util.HashMap;

public class Pessoa {
	private int cpf;
	private String nome;
	private String endereco;
	private String dataNascimento;

	public static Map<Integer, Pessoa> listaPessoas = new HashMap<>();

	// Construtor
	public Pessoa(int cpf, String nome, String endereco, String dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}
	
	// Getters
	public String getEndereco() {
		return endereco;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public int getCpf() {
		return cpf;
	}


	public String getNome() {
		return nome;
	}

	
	// Seters - Apenas coisas que uma pessoa pode mudar na vida real
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Pessoa pessoa))return false;
		return cpf == pessoa.cpf;
	}

	@Override
	public String toString() {
	    return "--- PESSOA ---\n" +
	            "CPF: " + cpf + "\n" +
	            "Nome: " + nome + "\n" +
	            "Data de Nascimento: " + dataNascimento + "\n" +
	            "Endereço: " + endereco;
	}
	
	
}
