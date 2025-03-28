package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/*
 * Representa uma operação que combina 2 argumentos do tipo T e retorna um resultado do mesmo tipo T.
 * É usada para realizar operações de redução em pares de elementos, como somar números ou combinar objetos
 * */

public class BinaryExample {
	public static void main(String[] arg) {
		List<Integer> numeros = Arrays.asList(1,2,3,5,6,7,8,9,10);
		
		BinaryOperator<Integer> somar = (n1, n2) -> n1 + n2;
		
		int resultado = numeros.stream()
				.reduce(0, somar); // 0 é como se fosse uma variável temporária, como se fosse o i em um for, mas aqui é utilizada para acumular o resultado.
		
		int resultado2 = numeros.stream()
				.reduce(0, (n1, n2) -> n1 + n2 );

		int resultado3 = numeros.stream()
				.reduce(0, Integer::sum);
		
		System.out.println(resultado);
	}
}
