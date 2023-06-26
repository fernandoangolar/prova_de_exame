package service.grafos;

import domain.grafos.Aresta;
import domain.grafos.Vertice;

import java.util.*;

public class Grafo<T> {

    private List<Vertice<T>> vertices;
    private List<Aresta<T>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public List<Vertice<T>> getVertices() {
        return vertices;
    }

    public List<Aresta<T>> getArestas() {
        return arestas;
    }

    public void adicionarVertice(Vertice<T> vertice) {
        vertices.add(vertice);
    }

    public void adicionarAresta(Vertice<T> verticeInicio, Vertice<T> verticeFim, int peso) {
        Aresta<T> aresta = new Aresta<>(verticeInicio, verticeFim, peso);
        arestas.add(aresta);
        verticeInicio.getVerticesSaida().add(verticeFim);
        verticeFim.getVerticesEntrada().add(verticeInicio);
    }

    public Vertice<T> getVertice(T dado) {
        for (Vertice<T> vertice : vertices) {
            if (vertice.getDado().equals(dado)) {
                return vertice;
            }
        }
        return null;
    }

    public void buscaEmLargura(Vertice<T> verticeInicial) {
        Set<Vertice<T>> visitados = new HashSet<>();
        Queue<Vertice<T>> fila = new LinkedList<>();

        visitados.add(verticeInicial);
        fila.add(verticeInicial);

        while (!fila.isEmpty()) {
            Vertice<T> verticeAtual = fila.poll();
            System.out.println("Visitando o vértice: " + verticeAtual.getDado());

            for (Vertice<T> vertice : verticeAtual.getVerticesSaida()) {
                if (!visitados.contains(vertice)) {
                    visitados.add(vertice);
                    fila.add(vertice);
                }
            }
        }
    }

    public void buscaEmProfundidade(Vertice<T> verticeInicial) {
        Set<Vertice<T>> visitados = new HashSet<>();
        Stack<Vertice<T>> pilha = new Stack<>();

        visitados.add(verticeInicial);
        pilha.push(verticeInicial);

        while (!pilha.isEmpty()) {
            Vertice<T> verticeAtual = pilha.pop();
            System.out.println("Visitando o vértice: " + verticeAtual.getDado());

            for (Vertice<T> vertice : verticeAtual.getVerticesSaida()) {
                if (!visitados.contains(vertice)) {
                    visitados.add(vertice);
                    pilha.push(vertice);
                }
            }
        }
    }
}
