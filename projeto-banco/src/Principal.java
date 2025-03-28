
public class Principal {
	static Leitura l = new Leitura();
	
	public static void main(String[] arg) {
		Banco banco = new Banco();
		int opc = 0;
		
		do {
			try {
				opc = Integer.parseInt(l.entDados("\n1 - Cadastrar pessoa\n2 - Cadastrar Conta\n3 - Ver pessoas cadastradas\n4 - Ver contas cadastradas\n5 - Sacar\n6 - Depositar\n7 - Transferir\n0 - Sair"));
				
				switch (opc) {
				case 1:
					cadastrarPessoa();
					break;
				case 2:
					banco.cadastrarConta();
					break;
				case 3:
					verPessoasCadastradas();
					break;
				case 4:
					banco.verContasCadastradas();
					break;
				case 5:
					banco.sacar();
					break;
				case 6:
					banco.depositar();
					break;
				case 7:
					banco.transferirDinheiro();
					break;
				default:
					if(opc != 0) {
						System.out.println(">>> Informe um valor dentro das opções informadas!");						
					}
				}
			}catch(NumberFormatException nfe) {
				System.out.println(">>> Informe um número interio!");
				opc = 8;
			}
		}while (opc != 0);
	}
	
	
	public static void verPessoasCadastradas() {
		Pessoa.listaPessoas.forEach((cpf, pessoa) -> {
			System.out.println(pessoa.toString());
		});
	}
	
	public static void cadastrarPessoa() {
		Pessoa pessoa = null;
		String nome;
		String endereco;
		String dataNascimento;
		int cpf;
		boolean denovo = true;
		
		nome = l.entDados("Insira seu nome: ");
		endereco = l.entDados("Insira seu endereço: ");
		dataNascimento = l.entDados("Insira sua data de nascimento: ");
		
		do {
			try {
				
				do {
					cpf = Integer.parseInt(l.entDados("Insira seu CPF (apenas números): "));				
					
					// Verificando se já não existe uma pessoa com esse CPF
					pessoa = Pessoa.listaPessoas.get(cpf);
					if(pessoa != null) {
						System.out.println(">>> Já existe uma pessoa com esse CPF, por favor insira outro!");
					}
				}while(pessoa != null);
				
				
				// Criando a pessoa efetivamente
				pessoa = new Pessoa(cpf, nome, endereco, dataNascimento);
				
				// Adicioando a pessoa no "bd"
				Pessoa.listaPessoas.put(pessoa.getCpf(), pessoa);
				
				denovo = false;
				
			}catch(NumberFormatException nfe) {
				System.out.println(">>> Insira apenas números para o cpf!");
				denovo = true;
			}
		}while(denovo);
	}
}
