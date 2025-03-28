package functional_interface;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T.
 * É comumente usada para criar ou fornecer novos objetos de um determinado tipo.
 * */

public class SupplierExample {
	public static void main(String[] arg) {
		// Usar o supplier com expressão lambda para fornecer uma saudação personalizada
		// () - não recebe argumentos
		// "Olá, seja bem vindo!" retorna o mesmo resultado informado em Supplier, que é String
		Supplier<String> saudacao = () -> "Olá, seja bem vindo!";
		
		List<String> listaSaudacoes = Stream.generate(saudacao) // generate recebe um supplier
				.limit(5) // informa quantas vezes a saudacao será gerada
				.toList();
		
		// Passando o supplier diretamente
		List<String> listaSaudacoes2 = Stream.generate(() -> "Hallo!!!")
				.limit(3)
				.toList();
		
		
		listaSaudacoes.forEach(s -> System.out.println(s));
	}
}
