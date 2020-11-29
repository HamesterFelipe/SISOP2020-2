package src;

import java.util.ArrayList;
import java.util.concurrent.*;

import java.io.*;
import java.lang.Thread;
import java.util.*;
import src.App;
import src.CPU;

public class Escalonador implements Runnable {

    private ArrayList listaDeProntos;
    private Semaphore Semaforo4;
    private Semaphore Semaforo5;
    private GerenteDeMemoria GDM;

    public Escalonador(ArrayList array, Semaphore semaforo, Semaphore semaforo1) {

        Semaforo4 = semaforo;
        Semaforo5 = semaforo1;
        listaDeProntos = array;
        GDM = new GerenteDeMemoria();
    }

    public void run() {

        while (true) {
            if (App.Flag == false) {
                try {
                    Semaforo4.acquire();
                    Semaforo5.acquire();
                } catch (InterruptedException Err) {
                    System.out.println(Err);
                }

                if (listaDeProntos.size() >= 1 && GDM.consulta() != true) {
                    CPU.i = 0;
                    GDM.allocate((pCB) listaDeProntos.remove(0));
                } else {
                    CPU.i = 0;
                    System.out.println("Não há espaço disponível na memória.");
                }

                App.Flag = true;
                Semaforo4.release();
                Semaforo5.release();
            }

        }

    }
}