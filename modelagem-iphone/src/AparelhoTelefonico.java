
public abstract class AparelhoTelefonico {
	public void tocar(String numero) {
		System.out.println("Ligando para: ".concat(numero));
	}
	
	public void atender() {
		System.out.println("Atendendo ligação");
	}
	
	public void iniciarCorreioVoz() {
		System.out.println("Iniciando correio de voz");
	}
}
