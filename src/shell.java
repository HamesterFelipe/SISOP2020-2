package src;

import java.util.*;
import java.util.concurrent.Semaphore;
import src.App;

public class shell implements Runnable {

    private gerenteDeProcessos GDP;
    private Semaphore Semaforo3;

    public shell(ArrayList array, Semaphore semaforo) throws InterruptedException {

        GDP = new gerenteDeProcessos(array);
        Semaforo3 = semaforo;

    }

    public void run() {

        Scanner le = new Scanner(System.in);
        int i = 0;

        while (i == 0) {
            if (App.Flag == true) {
                try {
                    Semaforo3.acquire();
                } catch (InterruptedException Err) {
                }

                System.out.println("=========THE ULTIMATE VIRTUAL MACHINE==========");
                System.out.println("|Escolha uma das programas abaixo:             |");
                System.out.println("|1 = Fibonacci-10                              |");
                System.out.println("|2 = Fibonacci-n                               |");
                System.out.println("|3 = Fatorial                                  |");
                System.out.println("|Quit = Encerrar Programa                      |");
                System.out.println("=========THE ULTIMATE VIRTUAL MACHINE==========");
                System.out.println("Digite os comandos: ");
                String Resposta = le.nextLine();
                if (Resposta.equals("1")) {
                    Resposta = "Ex1";
                }
                if (Resposta.equals("2")) {
                    Resposta = "Ex2";
                }
                if (Resposta.equals("3")) {
                    Resposta = "Ex3";
                }
                if (Resposta.equals("Quit")) {
                    i++;
                } else {
                    GDP.loadArquivo(Resposta);
                    App.Flag = false;
                    App.FlagCPU = false;
                }
                Semaforo3.release();
            }

        }
    }

}
