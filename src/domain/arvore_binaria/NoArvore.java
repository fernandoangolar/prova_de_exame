package domain.arvore_binaria;

public class NoArvore {

    public int valor;
    public NoArvore esquerda;
    public NoArvore direita;

    public NoArvore(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}
