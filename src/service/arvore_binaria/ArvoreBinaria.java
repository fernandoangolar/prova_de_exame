package service.arvore_binaria;

import domain.arvore_binaria.NoArvore;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {

    public NoArvore raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Método para adicionar um valor à árvore
    public void adicionar(int valor) {
        raiz = adicionarRecursivo(raiz, valor);
    }

    private NoArvore adicionarRecursivo(NoArvore atual, int valor) {
        if (atual == null) {
            return new NoArvore(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = adicionarRecursivo(atual.direita, valor);
        }

        return atual;
    }

    // Método para percorrer a árvore em ordem pós-fixada
    public void posFixada(NoArvore no) {
        if (no != null) {
            posFixada(no.esquerda);
            posFixada(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    // Método para percorrer a árvore em ordem infixa
    public void infixado(NoArvore no) {
        if (no != null) {
            infixado(no.esquerda);
            System.out.print(no.valor + " ");
            infixado(no.direita);
        }
    }

    // Método para percorrer a árvore em ordem pré-fixada
    public void preFixado(NoArvore no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preFixado(no.esquerda);
            preFixado(no.direita);
        }
    }

    // Método para percorrer a árvore em largura (busca em largura)
    public void buscaEmLargura() {
        if (raiz == null) {
            return;
        }

        Queue<NoArvore> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            NoArvore no = fila.poll();
            System.out.print(no.valor + " ");

            if (no.esquerda != null) {
                fila.add(no.esquerda);
            }

            if (no.direita != null) {
                fila.add(no.direita);
            }
        }
    }
}
