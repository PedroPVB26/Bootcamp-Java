
public enum EstadoBrasileiro {
	SAO_PAULO("SP", "São Paulo", 11),
	PARANA("PR", "Paraná", 12),
	RIO_GRANDE_DO_SUL("RS", "Rio Grande Do Sul", 13);
	
	private String nome;
	private String sigla;
	private int ibge;
	
	private EstadoBrasileiro(String sigla, String nome, int ibge) {
		this.sigla = sigla;
		this.nome = nome;
		this.ibge = ibge;
	}

	// Getters
	public int getIbge() {
		return ibge;
	}
	
	public String getNome() {
		return nome;
	}
	public String getSigla() {
		return sigla;
	}
	
	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setIbge(int ibge) {
		this.ibge = ibge;
	}

	
	public String getNomeMaiusculo() {
		return nome.toUpperCase();
	}
}
