package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
 * Representa uma função que aceita um argumento do tipo T e retorna um valor booleano.
 * É comumente usada para filtrar os elementos do Stream com base em alguma condição.
 * */

public class PredicateExample {
	public static void main(String[] args) {
		List<String> palavras = Arrays.asList("Java", "Kotlin", "Python", "JavaScript", "c", "go", "ruby");
		
		// <String> é o tipo do argumento
		Predicate<String> maisDeCincoCaracteres = palavra -> palavra.length() > 5;
		
		// Percorre a lista
		// Aplicar a função filter, que recebe como parâmetre uma função Predicate
		// A função predicate retornar apenas as palavras que tiverem + que 5 caracteres
		palavras.stream()
			.filter(maisDeCincoCaracteres)
			.forEach(System.out::println);
		
		palavras.stream()
			.filter(s -> s.length() > 5)
			.forEach(System.out::println);
		
		
	}
}
