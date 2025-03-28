
public class Iphone extends AparelhoTelefonico implements ReprodutorMusical, NavegadorInternet{

	// ReprodutorMusical
	public void tocar() {
		System.out.println("Tocando musica");
	}
	
	public void pausar() {
		System.out.println("Tocando musica");
	}
	
	public void selecionarMusica(String musica) {
		System.out.println("Musica selecionada: ".concat(musica));
	};
	
	// NavegadorInternet
	public void exibirPagina(String url) {
		System.out.println("Exibindo pagina de url: ".concat(url));
	}
	
	public void adicionarNovaAba() {
		System.out.println("Adicionando nova aba");
	}
	
	public void atualizarPagina() {
		System.out.println("Atualizando pagina");
	}
}
