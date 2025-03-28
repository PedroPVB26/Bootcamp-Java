package Map;

public class Evento {
	private String nome;
	private String atracao;
	
	public Evento(String nomeEvento, String nomeAtracao) {
		super();
		this.nome = nomeEvento;
		this.atracao = nomeAtracao;
	}

	public String getNomeEvento() {
		return nome;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nome = nomeEvento;
	}

	public String getNomeAtracao() {
		return atracao;
	}

	public void setNomeAtracao(String nomeAtracao) {
		this.atracao = nomeAtracao;
	}

	@Override
	public String toString() {
		return "Evento [nomeEvento=" + nome + ", nomeAtracao=" + atracao + "]\n";
	}
	
	
}
