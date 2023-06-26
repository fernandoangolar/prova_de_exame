package controller.arvore;


import service.arvore_binaria.ArvoreBinaria;

import java.util.Scanner;

public class ArvoreMain {

    public static void run() {
        ArvoreBinaria arvore = new ArvoreBinaria();

        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado à árvore: ");
                    int valor = scanner.nextInt();
                    arvore.adicionar(valor);
                    break;
                case 2:
                    System.out.print("Percurso pós-fixado: ");
                    arvore.posFixada(arvore.raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Percurso infixo: ");
                    arvore.infixado(arvore.raiz);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Percurso pré-fixado: ");
                    arvore.preFixado(arvore.raiz);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Percurso em largura: ");
                    arvore.buscaEmLargura();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            System.out.println();
        } while (opcao != 0);
    }

    public static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Adicionar valor à árvore");
        System.out.println("2. Imprimir percurso pós-fixado");
        System.out.println("3. Imprimir percurso infixo");
        System.out.println("4. Imprimir percurso pré-fixado");
        System.out.println("5. Imprimir percurso em largura");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
}

