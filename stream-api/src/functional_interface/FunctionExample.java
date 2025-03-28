package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
 * Representa uma função que aceita um argumento do tipo T e retorna um resultado do tipo R.
 * É utilizado para transformar/maperar elemenos do stream em outros valores/tipos
 * */

public class FunctionExample {
	public static void main(String[] arg) {
		List<Integer> numeros = Arrays.asList(1,2,3,4,5,6);
		
		// receber um inteiro e retorna um inteiro
		Function<Integer, Integer> dobrar = numero -> numero * 2;
		
		List<Integer> numerosDobrados = numeros.stream()
				.map(dobrar)
				.toList();
		
		List<Integer> numerosDobrados2 = numeros.stream()
				.map(n -> n * 2)
				.toList();
		
		numerosDobrados.forEach(n -> System.out.println(n));
	}
}
