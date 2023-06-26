package service.fila.impl;

import domain.fila.Tire;
import service.fila.InterfaceTire;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ImplTire implements InterfaceTire {

    Scanner scanner = new Scanner(System.in);

    Tire tire;
    Queue<Tire> goodstate = new LinkedList<>();
    Queue<Tire> betState  = new LinkedList<>();

    double width, weight;
    String state, mark, continues, toCheck;


    @Override
    public void loading() {
        while( true ) {
            System.out.println("\t\t\t\t\t\t\t Loading of Tire \n");

            System.out.print("Enter the mark : ");
            mark = scanner.nextLine();

            System.out.print("Enter the width : ");
            width = scanner.nextDouble();

            System.out.print("Enter the weight : ");
            weight = scanner.nextDouble();

            System.out.print("\nIt's in good condition [Y]es or [N]ot : ");
            toCheck = scanner.next();

            scanner.nextLine();

            if ( toCheck.equalsIgnoreCase("y") ) {
                tire = new Tire(width, weight, toCheck, mark);
                goodstate.add(tire);
                System.out.println("Good");
            } else if ( toCheck.equalsIgnoreCase("N")) {
                tire = new Tire(width, weight, toCheck, mark);
                betState.add(tire);
                System.out.println("Bed");
            }  else {
                System.out.println("   >>> Enter the value true, please");
                break;
            }

            System.out.print("\nDo you wish to continue? [Y]es or [N]ot : ");
            continues = scanner.nextLine();

            if ( ! "y".equalsIgnoreCase(continues) ) {
                break;
            }

        }

        getAllLoading();
        System.out.println("\nterminal loading\n");

    }

    @Override
    public void unloading() {

        System.out.println("\t\t\t\t\t\t\t Unloading of Tire \n");



        while( true ) {
            System.out.println("It's in good condition [Y]es or [N]ot :\n");
            toCheck = scanner.nextLine();

            if ( toCheck.equalsIgnoreCase("y") ) {
                tire = new Tire(toCheck);
                goodstate.add(tire);
                System.out.println("Good");
            } else if ( toCheck.equalsIgnoreCase("N")) {
                tire = new Tire(toCheck);
                betState.add(tire);
                System.out.println("Bed");
            } else {
                System.out.println("   >>> Enter the value true, Please");
                break;
            }

            System.out.print("\nDo you wish to continue? [y]es or [N]ot : ");
            continues = scanner.nextLine();

            if ( !"y".equalsIgnoreCase(continues) ) {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                break;
            }
        }

        getAllUnloading();
        System.out.println("\nTerminal Unloading\n");
    }

    @Override
    public void getAllLoading() {

        final int MAX_PRIORIDADE = 3;

        while (!goodstate.isEmpty() || !betState.isEmpty() ) {

            int cont = 0;

            while (!goodstate.isEmpty() && cont < MAX_PRIORIDADE ) {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                serviceTireLoading(goodstate);
                cont++;

            }

            if(!betState.isEmpty()) {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                serviceTireLoading(betState);
            }

            if ( goodstate.isEmpty() ) {
                while (!betState.isEmpty()) {
                    try {
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    serviceTireLoading(betState);
                }
            }
        }
    }

    @Override
    public void getAllUnloading() {

        final int MAX_PRIORIDADE = 3;

        while (!goodstate.isEmpty() || !betState.isEmpty() ) {

            int cont = 0;

            while (!goodstate.isEmpty() && cont < MAX_PRIORIDADE ) {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                serviceTireUnloading(goodstate);
                cont++;

            }

            if(!betState.isEmpty()) {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                serviceTireUnloading(betState);
            }

            if ( goodstate.isEmpty() ) {
                while (!betState.isEmpty()) {
                    try {
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    serviceTireUnloading(betState);
                }
            }
        }

    }

    public void serviceTireLoading(Queue<Tire> tires) {
        var  tire = tires.remove();
        System.out.println( "\n" + tire + "\t\t\t\t\t Loading  \n");
    }

    public void serviceTireUnloading(Queue<Tire> tires) {
        var  tire = tires.remove();
        System.out.println( "\n" + tire.toChecks() + "\t\t\t\t\t Unloading \n");
    }
}
