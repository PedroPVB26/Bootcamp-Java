package functional_interface;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * Consumer representa uma operação que aceita um argumento do tipo T e não retorna nenhum resultado.
 * É utilizado principalmente para realizar ações, ou efeitos colaterais nos elementos do Stream sem modificar, ou retornar valor.
 * */

public class ConsumerExample {
	public static void main(String[] arg) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// Usar o consumer como expressão lambda para imprimir números pares
		// <Integer> informa o tipo do parâmetro que a função irá receber
		Consumer<Integer> imprimirNumeroPar = numero -> {
			if(numero % 2 == 0) {
				System.out.println(numero + " ");
			}
		};
		
		// Implementa diretamente a função lambda no forEach, que recebe um Consumer como parâmetro
		numeros.forEach(n -> {
			if(n % 2 == 0) {
				System.out.println(n + " ");
			}
		});
		
		// Chama a função 
		numeros.forEach(imprimirNumeroPar);
	}
}
