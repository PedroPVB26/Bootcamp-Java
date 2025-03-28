package Set;

import java.util.Objects;

public class Convidado {
	private String nome;
	private int codigoConvite;
	
	public Convidado(String nome, int codigoConvite) {
		this.nome = nome;
		this.codigoConvite = codigoConvite;
	}
	
	public String getNome() {
		return nome;
	}
	public int getCodigoConvite() {
		return codigoConvite;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true; //  verifica se os dois objetos comparados são exatamente a mesma instância na memória.
		if( !(obj instanceof Convidado convidado)) return false; // verifica se obj é uma instância da classe Convidad, convertendo obj em um Convidado caso true
		return getCodigoConvite() == convidado.getCodigoConvite();
	}

	@Override
	public int hashCode() { // gera um número inteiro único para representar o objeto na memória.
		return Objects.hashCode(getCodigoConvite()); // gera um código baseado no atributo codigoConvite, que é o código utilizado no equals
	}
	

	
	
}
