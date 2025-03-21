/* 
Record é um tipo de estrutura de dados que serve para armazenar dados de forma imutável, ou seja, uma vez definidos 
os valores do atributos do record (por meio do construtor com parâmetros), não será mais possível alterá-los, pois eles
são, por padrão, final.

*/

public record Person(String nome, int Idade) {
}
