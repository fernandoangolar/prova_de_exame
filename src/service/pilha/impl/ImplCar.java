package service.pilha.impl;

import domain.pilha.Car;
import service.pilha.InterfaceCar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class ImplCar extends Car implements InterfaceCar {

    Queue<Car> Cars = new LinkedList<>();
    Scanner input = new Scanner(System.in);
    public ImplCar() {
        super();
    }
    @Override
    public void addCar() {
        while (true){
            System.out.println("Digite o nome de proprietário da viatura: ");
            String owner = input.nextLine();
            System.out.println("É uma viatura protocolar? (s/n): ");
            String protocol = input.nextLine();
            boolean verifyProtocol = protocol.equalsIgnoreCase("s");
            Car car = new Car(owner, verifyProtocol);
            Cars.add(car);
            System.out.println("Viatura salva com sucesso!");
            System.out.println("Deseja continuar ? (s/n) :");
            String continueAdd = input.nextLine();

            if (!continueAdd.equalsIgnoreCase("s")){
                break;
            }
        }
    }

    @Override
    public void semaphore() {
        while(true) {
            int semaphore = new Random().nextInt(3);
            switch (semaphore){
                case 0 ->{
                    System.out.println("\n--Vermelho--\n");
                    try {
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    for(Car car: Cars){
                        if(car.isProtocol()){
                            System.out.println("Viatura protocolar " + car.owner + " pode passar");
                            continue;
                        }
                        System.out.println("Viatura " + car.owner + " deve parar");
                    }
                }
                case 1 ->{
                    System.out.println("\n««Amarelo»»\n");
                    try {
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    for(Car car: Cars){
                        if(car.isProtocol()){
                            System.out.println("Viatura protocolar " + car.owner + " pode passar com cuidado !");
                            continue;
                        }
                        System.out.println("Viatura " + car.owner + " deve ter cuidado e se preparar para parar !");
                    }
                }
                case 2 ->{
                    System.out.println("\n==Verde==\n");
                    try {
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    for(Car car: Cars){
                        if(car.isProtocol()){
                            System.out.println("Viatura protocolar " + car.owner + " tem prioridade de passar livremente !");
                            continue;
                        }
                        System.out.println("Viatura " + car.owner + " pode passar, mais deve dar prioridade a viatura protocolar !");
                    }
                }

            }
        }
    }

}
