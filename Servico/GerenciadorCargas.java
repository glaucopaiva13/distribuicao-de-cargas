package Servico;

import Modelo.Carga;
import Modelo.HeapMaxima;
import Util.CSVUtil;

public class GerenciadorCargas {
	private HeapMaxima heap;

	public GerenciadorCargas(int capacidadeInicial) {
		this.heap = new HeapMaxima(capacidadeInicial);
	}

	public void carregarDeArquivo(String caminhoArquivo) {
		Carga[] cargas = CSVUtil.lerArquivo(caminhoArquivo);
		if (cargas != null) {
			for (int i = 0; i < cargas.length; i++) {
				if (cargas[i] != null) {
					heap.inserir(cargas[i]);
				}
			}
		}
	}

	public void inserirCarga(int id, int tipo, int urgencia, int peso, String descricao) {
		if (urgencia < 1 || urgencia > 3 || peso < 0) {
			System.out.println("Dados inválidos. Carga não inserida.");
			return;
		}
		Carga nova = new Carga(id, tipo, urgencia, peso, descricao);
		heap.inserir(nova);
	}

	public Carga consultarTopo() {
		return heap.consultarTopo();
	}

	public Carga removerCargaPrioritaria() {
		return heap.removerMaximo();
	}

	public void listarCargas() {
		System.out.println("ID   | Tipo | Urgência | Peso | Prioridade | Descrição");
		System.out.println("---------------------------------------------------------");

		for (int i = 1; i <= heap.tamanho(); i++) {
			System.out.println(heap.getElemento(i).toString()); // depende se você fez o getter do array
		}
	}

	public int quantidade() {
		return heap.tamanho();
	}
}

