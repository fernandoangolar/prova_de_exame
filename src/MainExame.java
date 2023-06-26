//import controller.exame.Menu;
import com.sun.tools.jconsole.JConsoleContext;
import controller.arvore.ArvoreMain;
import controller.circular.ListaCircular;
import controller.fila.FilaMain;
import controller.grafos.GrafoMain;
import controller.pilha.PilhaMain;
import service.fila.impl.ImplTire;
import service.pilha.impl.ImplCar;

import java.util.Scanner;

public class MainExame {

    public static void main(String[] args) throws Exception {

        PilhaMain pilhaMain = new PilhaMain();

        Scanner sc = new Scanner(System.in);
        Menu();
        while (true) {
            int opcao = sc.nextInt();
            if ( opcao == 6 ) {
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\nEstamos na estrutura de dados Filha....");
                    FilaMain.run();
                    Menu();
                    break;
                case 2:
                    System.out.println("\nEstamos na estrutura de dados Pilha....");
                    PilhaMain.run();
                    Menu();
                    break;
                case 3:
                    System.out.println("\nEstamos na estrutura de dados sobre Lista Circular....");
                    ListaCircular.run();
                    Menu();
                    break;
                case 4:
                    System.out.println("\nEstamos na estrutura de dados sobre Arvore binária....");
                    ArvoreMain.run();
                    Menu();
                    break;
                case 5:
                    System.out.println("\nEstamos na estrutura de dados sobre Grafos....");
                    GrafoMain.run();
                    Menu();
                    break;
                default:
                    System.out.println("Valor inválido, por favor digite um valor presente no menu... ");
                    Menu();
            }
        }

    }
    static void Menu() {
        System.out.println("\nSelecione uma opção:");
        System.out.println("1. Fila");
        System.out.println("2. Pilha");
        System.out.println("3. Lista Circula");
        System.out.println("4. Arvore Binária");
        System.out.println("5. Grafos");
        System.out.println("6. sair");
        System.out.print("Opção: ");
    }
}
