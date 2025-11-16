package Util;

import Modelo.Carga;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVUtil {

	public static Carga[] lerArquivo(String caminhoArquivo) {
		try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

			int linhasValidas = 0;
			br.mark(10_000_000); 
			String linha;
			while ((linha = br.readLine()) != null) {
				if (ehLinhaValida(linha)) linhasValidas++;
			}

			br.reset();

			Carga[] cargas = new Carga[linhasValidas];
			int index = 0;

			while ((linha = br.readLine()) != null) {
				if (!ehLinhaValida(linha)) continue;

				String[] partes = linha.split(",");
				int id = Integer.parseInt(partes[0]);
				int tipo = Integer.parseInt(partes[1]);
				int urgencia = Integer.parseInt(partes[2]);
				int peso = Integer.parseInt(partes[3]);
				String descricao = partes[4];

				cargas[index++] = new Carga(id, tipo, urgencia, peso, descricao);
			}

			return cargas;
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
			return null;
		}
	}

	private static boolean ehLinhaValida(String linha) {
		if (linha == null || linha.isEmpty()) return false;
		String[] partes = linha.split(",");
		if (partes.length < 5) return false;

		try {
			int urg = Integer.parseInt(partes[2]);
			int peso = Integer.parseInt(partes[3]);
			return urg >= 1 && urg <= 3 && peso >= 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

