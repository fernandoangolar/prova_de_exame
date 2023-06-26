package domain.grafos;

import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {

    private T dado;
    private List<Vertice<T>> verticesEntrada;
    private List<Vertice<T>> verticesSaida;

    public Vertice(T dado) {
        this.dado = dado;
        this.verticesEntrada = new ArrayList<>();
        this.verticesSaida = new ArrayList<>();
    }

    public T getDado() {
        return dado;
    }

    public List<Vertice<T>> getVerticesEntrada() {
        return verticesEntrada;
    }

    public List<Vertice<T>> getVerticesSaida() {
        return verticesSaida;
    }

}
