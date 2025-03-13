import java.util.Scanner;

public class Contador {

    public static void main(String[] args){
        Scanner terminal = new Scanner(System.in);
        
        System.out.println("Digite o primeiro parametro");
        int parametroUm = terminal.nextInt();
        
        System.out.println("Digite o segundo parametro");
        int parametroDois = terminal.nextInt();
        
        try{
            contar(parametroUm, parametroDois);
        }catch (ParametrosInvalidosException pie){
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException{
        if(parametroUm < parametroDois){
            for(int i = 0; i < parametroDois - parametroUm; i++){
                System.out.println("Imprimindo numero "+ i);
            }
        }else{
            ParametrosInvalidosException PIE = new ParametrosInvalidosException();
        }
    }
}
