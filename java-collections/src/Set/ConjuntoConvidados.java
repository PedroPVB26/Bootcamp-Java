package Set;
import java.util.HashSet;

public class ConjuntoConvidados {
	private static HashSet<Convidado> listaConvidados = new HashSet<Convidado>();
	
	public static void adicionarConvidado(String nome, int codigoConvite) {
		Convidado convidado = new Convidado(nome, codigoConvite);
		
		listaConvidados.add(convidado);
	}
	
	public static void exibirConvidados() {
		for(Convidado c : listaConvidados) {
			System.out.println("----");
			System.out.println(c.getNome());
			System.out.println(c.getCodigoConvite());
		}
	}
	
	public static void removerConvidadoPorCodigoConvite(int codigoConvite) {
		Convidado convidadoRemover = null;
		
		for(Convidado convidado: listaConvidados) {
			if(convidado.getCodigoConvite() == codigoConvite) {
				convidadoRemover = convidado;
			}
		}
		
		
		listaConvidados.remove(convidadoRemover);
	}
	
	public static void contarConvidados() {
		System.out.println("Quantidade de convidados: " + listaConvidados.size());
	}
	
	public static void main(String[] arg) {
		adicionarConvidado("pedro", 1);
		adicionarConvidado("paulo", 2);
		adicionarConvidado("bittencourt", 3);
		
		removerConvidadoPorCodigoConvite(2);
		contarConvidados();

		exibirConvidados();
	}
}
