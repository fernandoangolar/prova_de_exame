package controller.grafos;

import domain.grafos.Pessoa;
import domain.grafos.Vertice;
import service.grafos.Grafo;

import java.util.Scanner;

public class GrafoMain {

    public static void run() {

            Grafo<Pessoa> grafo = new Grafo<>();

            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                Menu();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome da pessoa: ");
                        scanner.nextLine();
                        String nome = scanner.next();
                        System.out.print("Digite a idade da pessoa: ");
                        int idade = scanner.nextInt();
                        Pessoa novaPessoa = new Pessoa(nome, idade);
                        Vertice<Pessoa> novoVertice = new Vertice<>(novaPessoa);
                        grafo.adicionarVertice(novoVertice);
                        System.out.println("Vértice adicionado com sucesso.");
                        break;
                    case 2:
                        System.out.print("Digite o nome da pessoa de início: ");
                        String nomeInicio = scanner.next();
                        System.out.print("Digite o nome da pessoa de fim: ");
                        String nomeFim = scanner.next();
                        System.out.print("Digite o peso da aresta: ");
                        int pesoAresta = scanner.nextInt();

                        Vertice<Pessoa> verticeInicio = null;
                        Vertice<Pessoa> verticeFim = null;
                        for (Vertice<Pessoa> vertice : grafo.getVertices()) {
                            if (vertice.getDado().getNome().equals(nomeInicio)) {
                                verticeInicio = vertice;
                            }
                            if (vertice.getDado().getNome().equals(nomeFim)) {
                                verticeFim = vertice;
                            }
                        }

                        if (verticeInicio != null && verticeFim != null) {
                            grafo.adicionarAresta(verticeInicio, verticeFim, pesoAresta);
                            System.out.println("Aresta adicionada com sucesso.");
                        } else {
                            System.out.println("Vértices não encontrados.");
                        }
                        break;
                    case 3:
                        System.out.print("Digite o nome da pessoa inicial: ");
                        String nomePessoaInicial = scanner.next();
                        Vertice<Pessoa> pessoaInicial = null;
                        for (Vertice<Pessoa> vertice : grafo.getVertices()) {
                            if (vertice.getDado().getNome().equals(nomePessoaInicial)) {
                                pessoaInicial = vertice;
                                break;
                            }
                        }

                        if (pessoaInicial != null) {
                            System.out.println("Busca em largura:");
                            grafo.buscaEmLargura(pessoaInicial);
                        } else {
                            System.out.println("Vértice inicial não encontrado.");
                        }
                        break;
                    case 4:
                        System.out.print("Digite o nome da pessoa inicial: ");
                        String nomePessoaInicialProf = scanner.next();
                        Vertice<Pessoa> pessoaInicialProf = null;
                        for (Vertice<Pessoa> vertice : grafo.getVertices()) {
                            if (vertice.getDado().getNome().equals(nomePessoaInicialProf)) {
                                pessoaInicialProf = vertice;
                                break;
                            }
                        }

                        if (pessoaInicialProf != null) {
                            System.out.println("Busca em profundidade:");
                            grafo.buscaEmProfundidade(pessoaInicialProf);
                        } else {
                            System.out.println("Vértice inicial não encontrado.");
                        }
                        break;
                    case 5:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                System.out.println();
            } while (opcao != 5);

    }

    public static void Menu() {
        System.out.println("Selecione uma opção:");
        System.out.println("1. Adicionar vértice");
        System.out.println("2. Adicionar aresta");
        System.out.println("3. Busca em largura");
        System.out.println("4. Busca em profundidade");
        System.out.println("5. Sair");
        System.out.print("Opção: ");
    }
}

