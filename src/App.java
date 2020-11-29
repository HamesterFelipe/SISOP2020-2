package src;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.io.*;
import java.lang.Thread;

public class App {

    static volatile ArrayList ListaDeProntos = new ArrayList<>();
    static volatile boolean Flag = true;
    static volatile boolean FlagCPU = false;

    public static void main(String[] args) throws InterruptedException {

        Semaphore Semaforo1 = new Semaphore(1);
        Semaphore Semaforo2 = new Semaphore(1);

        shell shell = new shell(ListaDeProntos, Semaforo1);
        Thread Terminal = new Thread(shell);

        Escalonador escalonador = new Escalonador(ListaDeProntos, Semaforo1, Semaforo2);
        Thread Escalonador = new Thread(escalonador);

        CPU CPU = new CPU(Semaforo2);
        Thread Cpu = new Thread(CPU);

        Terminal.start();

        Escalonador.start();

        Cpu.start();

    }
}