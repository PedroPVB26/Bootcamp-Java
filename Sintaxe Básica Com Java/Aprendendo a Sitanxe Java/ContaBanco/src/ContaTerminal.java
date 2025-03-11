import java.util.Locale;
import java.util.Scanner;

/**
 * <h1>ContaTermina</h1>
 *Simples classe simulando um funcionamento bem básico de uma conta em um banco
 * <p>
 * <b>Note:</b> Lei atentamente a documentação desta classe para desfrutar dos recursos da mesma da melhor forma
 * @author Pedro Bittencourt
 * @version 1.0
 * @since 11/03/2025
 */
public class ContaTerminal {
    /**
     * Ex: 1021
     */     
    public static int numero;
    
     /**
     * Ex: 067-8
     */ 
    public static String agencia;

     /*
     * Ex: Pedro Paulo
     */
    public static String nomeCliente;
    
    /*
     * Ex: 2399.1
     */
    public static float saldo;
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o número");
        numero = scanner.nextInt();

        System.out.println("Digite sua agência");
        agencia = scanner.next();

        System.out.println("Digite o seu nome");
        nomeCliente = scanner.next();

        System.out.println("Digite o seu saldo");
        saldo = scanner.nextFloat();
        
        System.out.println("Olá ".concat(nomeCliente).concat(", obrigado por criar uma conta em nosso banco, sua agência é ").concat(agencia).concat(", conta ").concat(Integer.toString(numero)).concat(" e seu saldo ").concat(Float.toString(saldo)).concat(" já está disponível para saque"));
    }
}
