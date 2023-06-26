package service.lista_circular.impl;

import domain.lista_circular.No;
import service.lista_circular.InterfaceCircular;

public class ImplCircular implements InterfaceCircular {

    private No inicio;

    @Override
    public void add(String s) throws Exception {

        No newNo = new No(s);

        if ( isvazia() ) {
            inicio = newNo;
            inicio.proximo = inicio;
        } else {

            int tamanho = size();

            // 1 é para parar no ultimo não no proximo
            for ( int i = 1; i < tamanho; i++ ) {
                if( inicio.dado.equals(newNo.dado)) {
                    throw new Exception("Dados repetido");
                }
                inicio = inicio.proximo;
            }

            newNo.proximo = inicio.proximo;
            inicio.proximo = newNo;
            inicio = inicio.proximo.proximo;
        }
    }

    @Override
    public String removeIndex(int i) throws Exception {

        if ( isvazia() || i < 0 || i >= size() ) {
            throw new Exception("Lista está vazia");
        } else if( size() == 1 && i == 0 ) {

            String dado = inicio.dado;
            inicio = null;
            return dado;
        } else {

            String element = element(i);

            while ( !inicio.proximo.dado.equals(element) ) {

                inicio = inicio.proximo;
            }

            inicio.proximo = inicio.proximo.proximo;

            return element;
        }

    }

    @Override
    public String element( int i ) throws Exception {

        if ( isvazia() || i < 0 || i >= size() ) {
            throw new Exception("A lista não possui este index");
        } else {
            for ( int cont = 0; cont < i; cont++ ) {
                inicio = inicio.proximo;
            }
            return  inicio.dado;
        }
    }

    @Override
    public int size() {

        int tamanho = 0;

        if ( !isvazia() ) {
            tamanho++;
            String dados = inicio.dado;

            while (!inicio.proximo.dado.equals(dados)) {
                tamanho++;
                inicio = inicio.proximo;
            }
            inicio = inicio.proximo;
        }

        return tamanho;
    }

    @Override
    public String first() {

        if ( isvazia() ) {
            return null;
        } else {
            return inicio.dado;
        }
    }

    @Override
    public String last() {

        if ( isvazia() ) {
            return null;
        } else {
            String dado = inicio.dado;

            while (!inicio.proximo.dado.equals(dado) ) {
                inicio = inicio.proximo;
            }

            dado  = inicio.dado;
            inicio = inicio.proximo;

            return dado;
        }

    }

    public boolean isvazia() {
        return  inicio == null;
    }

    @Override
    public void print() {

        System.out.println("LISTA >>>> ");

        if ( !isvazia() ) {

            int tamanho = size();

            for (int i = 0; i < tamanho; i++ ) {

                System.out.println(" -> " + inicio.dado );
                inicio = inicio.proximo;
            }
        } else {
            System.out.println("Vazio");
        }
    }

}
