package Modelo;

public class HeapMaxima {
	private Carga[] heap;
	private int quantidade;
	private int capacidade;


	public HeapMaxima(int capacidadeInicial) {
		this.capacidade = capacidadeInicial;
		this.heap = new Carga[capacidade + 1]; 	
		this.quantidade = 0;
	}

	private boolean maior(Carga a, Carga b){
		if (a.getPrioridade() != b.getPrioridade()){
			return a.getPrioridade() > b.getPrioridade();
		}
		if (a.getUrgencia() != b.getUrgencia()){
			return a.getUrgencia() > b.getUrgencia();
		}
		if (a.getPeso() !=b.getPeso()){
			return a.getPeso() > b.getPeso();
		}

		return a.getId() < b.getId();
	}

	public void inserir(Carga novaCarga) {
		if (quantidade >= capacidade)
		garantirCapacidade();

		heap[++quantidade] = novaCarga; 
		subir(quantidade);
	}

	public Carga removerMaximo() {
		if (quantidade == 0) return null;

		Carga max = heap[1];
		heap[1] = heap[quantidade];
		quantidade--;
		descer(1);

		return max;
	}

	public Carga consultarTopo() {
		if (quantidade == 0) return null;
		return heap[1];
	}

	public Carga getElemento(int i) {
		if (i < 1 || i > quantidade){ 
			return null;
		}
		return heap[i];
	}

	public int tamanho() {
		return quantidade;
	}

	private void subir(int i) {
		while (i > 1 && maior(heap[i], heap[i / 2])) {
			trocar(i, i / 2);
			i = i / 2;
		}
	}

	private void descer(int i) {
		int maiorFilho;

		while (2 * i <= quantidade) {
			int esquerdo = 2 * i;
			int direito = 2 * i + 1;
			maiorFilho = esquerdo;

			if (direito <= quantidade && maior(heap[direito], heap[esquerdo])) {
				maiorFilho = direito;
			}

			if (!maior(heap[maiorFilho], heap[i]))
			break;

			trocar(i, maiorFilho);
			i = maiorFilho;
		}
	}

	private void trocar(int i, int j) {
		Carga temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private void garantirCapacidade() {
		capacidade *= 2;
		Carga[] novoHeap = new Carga[capacidade + 1];
		for (int i = 1; i <= quantidade; i++) {
			novoHeap[i] = heap[i];
		}
		heap = novoHeap;
	}
}
