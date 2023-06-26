package service.lista_circular;

public interface InterfaceCircular {

    public void add(String s) throws Exception;
    public String removeIndex( int i) throws Exception;
    public String element( int i) throws Exception;
    public int size();
    public String first();
    public String last();
    public void print();
}
