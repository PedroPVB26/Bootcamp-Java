import java.util.Objects;

public abstract class Conta implements IConta{
	private static int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Pessoa pessoa;


	public Conta(Pessoa pessoa){
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = 0;
		this.pessoa = pessoa;
	}

	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	@Override
	public void sacar(double valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso");
		}else {
			System.out.println("Valor para saque é superior ao saldo disponível");
		}
	}
	
	@Override
	public void depositar(double valor) {
		this.saldo += valor;
		System.out.println("Valo depositado/transferido com sucesso");
	}
	
	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			contaDestino.depositar(valor);
		}else {
			System.out.println("Valor para transferência é superior ao saldo disponível");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Conta conta)) return false;
		return numero == conta.numero;
	}


	@Override
	public String toString() {
	    return "---------- CONTA " + numero + " -----\n" +
	            "Agência: " + agencia + "\n" +
	            "Saldo: " + saldo;
	}
	
	
}
