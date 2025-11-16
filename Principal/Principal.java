package Principal;

import java.util.Scanner;
import Modelo.Carga;
import Servico.GerenciadorCargas;

public class Principal {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GerenciadorCargas gerenciador = new GerenciadorCargas(50);
		int opcao;

		do {
			System.out.println("\n===== MENU =====");
			System.out.println("1 - Carregar cargas de arquivo CSV");
			System.out.println("2 - Inserir carga manualmente");
			System.out.println("3 - Exibir carga de maior prioridade");
			System.out.println("4 - Remover carga de maior prioridade");
			System.out.println("5 - Exibir todas as cargas ordenadas por prioridade ");
			System.out.println("6 - Sair");
			System.out.print("Escolha: ");

			opcao = in.nextInt();
			in.nextLine();

			switch (opcao) {

				case 1:
				System.out.print("Caminho do arquivo CSV: ");
				String caminho = in.nextLine();
				gerenciador.carregarDeArquivo(caminho);
				System.out.println("Arquivo carregado!");
				break;

				case 2:
				System.out.println("=== Inserir nova carga ===");

				System.out.print("ID: ");
				int id = in.nextInt();
				System.out.print("Tipo: ");
				int tipo = in.nextInt();
				System.out.print("Urgência: ");
				int urgencia = in.nextInt();
				System.out.print("Peso: ");
				int peso = in.nextInt();
				in.nextLine();
				System.out.print("Descrição: ");
				String descricao = in.nextLine();

				gerenciador.inserirCarga(id, tipo, urgencia, peso, descricao);
				System.out.println("Carga inserida!");
				break;


				case 3:
				Carga topo = gerenciador.consultarTopo();
				if (topo == null){
					System.out.println("Heap vazia!");
				}
				else{
					System.out.println("ID   | Tipo | Urgência | Peso | Prioridade | Descrição");
					System.out.println("---------------------------------------------------------");
					System.out.println(topo.toString());
				}
				break;

				case 4:
				Carga removida = gerenciador.removerCargaPrioritaria();
				if (removida == null){
					System.out.println("Heap vazia!");
				}
				else{
					System.out.println("Carga removida com sucesso.");
				}
				break;

				case 5:
				gerenciador.listarCargas();
				break;

				case 6:
				System.out.println("Encerrando...");
				break;

				default:
				System.out.println("Opção inválida!");
			}

		} while (opcao != 6);

		in.close();
	}
}

