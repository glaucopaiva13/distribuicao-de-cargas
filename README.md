# Distribuição de Cargas

Este projeto foi desenvolvido como atividade da disciplina de Linguagem de Programação 2.

## Objetivo

Aplicar conceitos de Orientação a Objetos (OOP) em conjunto com a estrutura de dados Heap, utilizando um exemplo simples de gerenciamento de cargas com prioridade.

## O que o sistema faz

O programa permite:

- carregar cargas a partir de um arquivo CSV;
- inserir novas cargas manualmente;
- consultar a carga de maior prioridade;
- remover a carga de maior prioridade;
- listar todas as cargas ordenadas conforme a prioridade definida.

## Como a prioridade é calculada

Cada carga possui uma prioridade calculada com base em:

- urgência;
- peso;
- tipo.

A lógica utilizada está implementada na classe `Carga`, que define a prioridade da carga para a Heap.

## Estrutura do projeto

- `Principal/Principal.java` — menu principal e interação com o usuário.
- `Servico/GerenciadorCargas.java` — responsável por gerenciar as operações das cargas.
- `Modelo/Carga.java` — representação de uma carga.
- `Modelo/HeapMaxima.java` — implementação da estrutura Heap Maxima.
- `Util/CSVUtil.java` — leitura de dados a partir de arquivos CSV.
- `Teste.csv` — exemplo de arquivo de entrada.

## Como executar

1. Compile os arquivos Java:
   ```bash
   javac Principal/Principal.java Modelo/Carga.java Modelo/HeapMaxima.java Servico/GerenciadorCargas.java Util/CSVUtil.java
   ```

2. Execute o programa:
   ```bash
   java Principal.Principal
   ```

## Observação

O projeto foi pensado como uma aplicação para fins didáticos.
