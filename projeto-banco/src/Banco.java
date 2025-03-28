import java.util.Map;
import java.util.HashMap;


public class Banco {
	private String nome;
	private Map<Integer, Conta> listaContas;
	private Leitura l = new Leitura();
	
	public Banco() {
		listaContas = new HashMap<>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	private Conta verificarExistenciaConta(int cpf) {
		for(Conta conta: listaContas.values()) {
			if(conta.getPessoa().getCpf() == cpf) {
				return conta;
			}
		}
		return null;
	}
	
	private int verificarTipoConta(Conta conta) {
		if(conta instanceof ContaCorrente) {
			return 0;
		}else {
			return 1;
		}
	}
	
	private void cadastrarCorrente(Pessoa pessoa) {
		Conta contaCadastro = new ContaCorrente(pessoa);				
		listaContas.put(contaCadastro.getNumero(), contaCadastro);
	}
	
	private void cadastrarPoupanca(Pessoa pessoa) {
		Conta contaCadastro = new ContaPoupanca(pessoa);				
		listaContas.put(contaCadastro.getNumero(), contaCadastro);
	}
	
	private Conta buscarConta(int numero) {
		for(int numeroConta: listaContas.keySet()) {
			if(numeroConta == numero) {
				return listaContas.get(numero);
			}
		}
		return null;
	}
	
	public void depositar() {
		Conta conta = null;
		int numero, opc;
		double valor;
		boolean denovo = false;
		
		do {
			try {
				numero = Integer.parseInt(l.entDados("Insira o número da conta onde o valor será depositado: "));
				conta = buscarConta(numero);
				
				if(conta != null) {
					valor = Integer.parseInt(l.entDados("Insira valor a ser depositado: "));
					
					if(valor > 0) {
						conta.depositar(valor);
						denovo = false;
					}else {
						System.out.println("O valor a ser depositado deve ser maio que 0");
						denovo = true;
					}
					
				}else {
					System.out.println(">>> Não foi encontrada nenhuma conta com esse número");
					try {
						opc = Integer.parseInt(l.entDados("Deseja tentar de novo? \n0 - Não\n1 - Sim"));						
						if(opc == 1) {
							denovo = true;
						}else {
							denovo = false;
						}
						
					}catch(NumberFormatException nfe) {
						System.out.println(">>> Insira um número inteiro!");
						denovo = true;
					}
					
				}
				
			}catch(NumberFormatException nfe) {
				System.out.println(">>> Insira um número");
			}
		}while(denovo);
	}

	public void sacar() {
		Conta conta = null;
		int numero, opc;
		double valor;
		boolean denovo = false;
		
		do {
			try {
				numero = Integer.parseInt(l.entDados("Insira o número da conta de onde deseja sacar: "));
				conta = buscarConta(numero);
				
				if(conta != null) {
					valor = Float.parseFloat(l.entDados("Insira valor a ser sacado: "));
					
					if(valor > 0) {
						conta.sacar(valor);
						denovo = false;
					}else {
						System.out.println("O valor a ser sacado deve ser maio que 0");
						denovo = true;
					}
					
				}else {
					System.out.println(">>> Não foi encontrada nenhuma conta com esse número");
					try {
						opc = Integer.parseInt(l.entDados("Deseja tentar de novo? \n0 - Não\n1 - Sim"));						
						if(opc == 1) {
							denovo = true;
						}else {
							denovo = false;
						}
						
					}catch(NumberFormatException nfe) {
						System.out.println(">>> Insira um número inteiro!");
						denovo = true;
					}
					
				}
				
			}catch(NumberFormatException nfe) {
				System.out.println(">>> Insira um número");
			}
		}while(denovo);
	}
	
	public void transferirDinheiro() {
		int numeroContaDestino, numeroContaOrigem;
		Conta contaOrigem = null, contaDestino = null;;
		double valor;
		boolean denovo=false;
		
		do {
			
			try {
				// Procurando conta de origem
				numeroContaOrigem = Integer.parseInt(l.entDados("Insira o número da conta de origem: "));
				contaOrigem = buscarConta(numeroContaOrigem);
				
				if(contaOrigem != null) {
					// Procurando conta de destino
					numeroContaDestino = Integer.parseInt(l.entDados("Insira o número da conta de destino: "));
					contaDestino = buscarConta(numeroContaDestino);
					
					if(contaDestino != null) {
						System.out.println("Valor disponível para transferência: R$ " + contaOrigem.getSaldo());
						
						valor = Integer.parseInt(l.entDados("Informa o valor da transferência: "));
						
						if(valor > 0) {
							contaOrigem.transferir(valor, contaDestino);
							System.out.println("Valor transferido com sucesso!");
							denovo = false;
						}else {
							System.out.println(">>> O valor transferido deve ser maior que 0");
							denovo = true;
						}
					}else {
						System.out.println(">>> Não foi encontrada nenhuma conta com esse número");
						denovo = true;						
					}
				}else {
					System.out.println(">>> Não foi encontrada nenhuma conta com esse número");
					denovo = true;
				}
				
			}catch(NumberFormatException nfe) {
				System.out.println(">>> Informe um número inteiro!");
				denovo = true;
			}
		}while(denovo);
		
		
	}
	
	public void cadastrarConta() {
		int cpf=0,  opc, opc2;
		Pessoa pessoa;
		Conta conta;
		boolean denovo = true;
		

		do {
			// Pegando o cpf
			do {
				try {
					cpf = Integer.parseInt(l.entDados("Insira o seu CPF:"));				
					denovo = false;
				}catch(NumberFormatException nfe) {
					System.out.println(">>> Insira um número inteiro");
					denovo = true;
				}
				
			}while(denovo);
			
			// Pegando a pessoa
			pessoa = Pessoa.listaPessoas.get(cpf);
			
			// Se a pessoa existir
			if(pessoa != null) {
				try {
					// ContaCorrente ou ContaPoupança
					opc = Integer.parseInt(l.entDados("Qual tipo de conta você deseja cadastrar?\n1 - Corrente\n2 - Poupança:"));			
					
					// >>>>> Verificar se essa pessoa já tem uma conta desse tipo <<<<<<<<<
					conta = verificarExistenciaConta(cpf);
					
					if(conta!=null) {
						// Caso o usuário tenha conta Corrente
						if(verificarTipoConta(conta) == 0) {
							opc2 = Integer.parseInt(l.entDados("Você já possui conta corrente, Deseja cadastrar uma conta poupança?\n0 - Não\n1 - Sim"));
							if(opc2 == 1) {
								cadastrarPoupanca(pessoa);
								denovo = false;
							}
						// Caso o usuário tenha conta Poupança
						}else {
							opc2 = Integer.parseInt(l.entDados("Você já possui conta poupança, Deseja cadastrar uma conta corrente?\\n0 - Não\\n1 - Sim"));
							if(opc == 1) {
								cadastrarCorrente(pessoa);
								denovo = false;
							}
						}
					}else {
						// ContaCorrente
						if(opc == 1) {
							cadastrarCorrente(pessoa);
							denovo = false;
							
							// ContaPoupanca
						}else if(opc == 2) {
							cadastrarPoupanca(pessoa);
							denovo = false;
							
							// Opção inválida	
						}else {
							System.out.println(">>> Insira uma opcao valida!");
							denovo = true;
						}
					}
					
					// Entrada inválida	
				}catch (NumberFormatException  nfe){
					System.out.println(">>> Insira um número inteiro!");
					denovo = true;
				}
			}else {
				System.out.println(">>> CPF não encontrado!");
				try {
					opc2 = Integer.parseInt(l.entDados("1 - Tentar novamente\n2 - Cancelar"));
					
					if(opc2 == 2) {
						denovo = false;
					}else {
						denovo = true;
					}
				}catch (NumberFormatException nfe) {
					System.out.println(">>> Insira um número inteiro!");
					denovo = true;
				}
			}
		}while(denovo);
	}
	
	public void verContasCadastradas() {
		listaContas.forEach((numero, conta) ->{
			System.out.println(conta.toString());
			System.out.println(conta.getPessoa().toString());
		});
	}
	
}
