package controller.fila;

import service.fila.impl.ImplTire;

import java.util.Scanner;

public class FilaMain {
    public static void run() {

        ImplTire service = new ImplTire();
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            Menu();

            System.out.print( "\n >>> : " );
            opcao = scanner.nextInt();

            switch( opcao ) {
                case 1:
                    service.loading();
                    break;
                case 2:
                    service.unloading();
                    break;
                case 3:
                    System.out.println("Opção inválida");
            }
            break;
        } while ( opcao != 3 );
    }

    public static void Menu() {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Loading the Tire ");
        System.out.println("2 - UnLoading the Tire ");
        System.out.println("3 - sair");
    }

}
