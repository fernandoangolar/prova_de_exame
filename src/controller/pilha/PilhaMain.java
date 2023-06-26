package controller.pilha;

import service.pilha.impl.ImplCar;

import java.util.Scanner;

public class PilhaMain {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        ImplCar car = new ImplCar();

        while(true){
            PilhaMain.Menu();
            System.out.print( "\n >>> : " );

            switch(scanner.nextInt()){
                case 1 -> car.addCar();
                case 2 -> car.semaphore();
                case 3 -> {
                    return;
                }
            }
            break;
        }
    }

   public static void Menu() {
       System.out.println("Selecione uma opção:");
       System.out.println("1 - Adicionar viatura: ");
       System.out.println("2 - Semáforo");
       System.out.println("3 - Sair");
   }
}
