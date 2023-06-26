package controller.circular;

import service.lista_circular.impl.ImplCircular;

import java.util.Scanner;

public class ListaCircular {

    public static void run() throws Exception {
        Scanner scanner = new Scanner(System.in);
        ImplCircular implCircular = new ImplCircular();
        String element;
        int index;

        while ( true ) {
            Menu();
            int print = scanner.nextInt();

            if ( print == 8 ) {
                try {
                    System.out.println("Bay Bay Bay");
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                break;
            }

            switch ( print ) {
                case 1:
                    scanner.nextLine();
                    System.out.println(" Digite o dia da semana.... ");
                    String dia_semana = scanner.nextLine();

                    implCircular.add(dia_semana);
                    System.out.println( " Foi um sucesso adicionar o dia da semana : " + dia_semana );
                    break;
                case 2:
                    System.out.println("Digite o index que deseja buscar....");
                    index = scanner.nextInt();

                    implCircular.removeIndex(index);
                    System.out.println("Removido com sucesso... " );
                    break;
                case  3:
                    System.out.println("Consultar o dia da semana pela posição...");
                    index = scanner.nextInt();

                    System.out.println( " O dia da semana em busca é : " +  implCircular.element(index));
                    break;
                case 4:
                    System.out.println( " O tamanho da lista é : " + implCircular.size());
                    break;
                case 5:
                    System.out.println( " O primeiro elemento é :  "  + implCircular.first());
                    break;
                case 6:
                    System.out.println( " O ultimo elemento é : " + implCircular.last());
                    break;
                case 7:
                    implCircular.print();
            }
        }
    }

    public static void Menu() {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Adicionar ");
        System.out.println("2 - Excluir por index ");
        System.out.println("3 - Consultar elemento de uma posição");
        System.out.println("4 - Consultar tamanho");
        System.out.println("5 - Print the first");
        System.out.println("6 - Print the last");
        System.out.println("7 - Print the list");
        System.out.println("8 - leave");
    }
}
