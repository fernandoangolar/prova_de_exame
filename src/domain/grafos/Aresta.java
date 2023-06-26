package domain.grafos;

public class Aresta<T> {

    private Vertice<T> verticeInicio;
    private Vertice<T> verticeFim;
    private int peso;

    public Aresta(Vertice<T> verticeInicio, Vertice<T> verticeFim, int peso) {
        this.verticeInicio = verticeInicio;
        this.verticeFim = verticeFim;
        this.peso = peso;
    }

    public Vertice<T> getVerticeInicio() {
        return verticeInicio;
    }

    public Vertice<T> getVerticeFim() {
        return verticeFim;
    }

    public int getPeso() {
        return peso;
    }
}
