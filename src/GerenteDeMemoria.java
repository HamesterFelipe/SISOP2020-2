package src;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;
import java.io.*;
import java.lang.Thread;

public class GerenteDeMemoria {

    public static volatile posicaoDeMemoria[] memoria;
    public static volatile Integer[] regis = new Integer[8];
    public static volatile Particoes Particao;
    public static volatile boolean cheio;
    public static volatile int PC;
    public static volatile pCB Edmundo;

    public GerenteDeMemoria() {

        memoria = new posicaoDeMemoria[1024];
        for (int k = 0; k < memoria.length; k++) {
            memoria[k] = new posicaoDeMemoria(null, null, null, -99);
        }
        PC = 0;
        for (int i = 0; i < regis.length; i++) {

            regis[i] = 0;
        }

        Particao = new Particoes();
        cheio = false;

    }

    public void allocate(pCB pcb) {

        int k = 0;
        // Alterado
        // verifica 64 partições
        while (k < 64) {
            // Aloca o pcb na primeira partição livre
            // TO DO caso para quando programa tiver mais de 16 instruções

            if (pcb.getArray().size() <= 16) {
                int livres[] = new int[1];
                if (Particao.getOcup(k) != true) {
                    System.out.println("Salvando o exercício " + pcb.getId() + " na partição " + k);
                    int comeco = Particao.traduz(k);
                    // Aloca partição
                    Particao.setOcup(k);
                    // Aloca programa no array de pcb de partições
                    Particao.setProgram(pcb, k);
                    // Seta onde começa o programa(memoria fisica)
                    pcb.setSafe(comeco);
                    livres[0] = k;
                    pcb.setParts(livres);
                    for (int i = 0; i < pcb.getArray().size(); i++) {
                        System.out.println(
                                "Posição da memória ocupada: " + comeco + "Instrução: " + pcb.getArray().get(i));
                        memoria[comeco] = (posicaoDeMemoria) pcb.getArray().get(i);
                        comeco++;
                    }
                    break;
                }
            } else {
                // On going
                int qntParticoes = (pcb.getArray().size() / 16) + 1;
                // Procurar qntPart de partições livres
                int partAchados = 0;
                int livres[] = new int[qntParticoes];
                int cont = 0;
                // Acha a quantidade necessária de partições
                while (partAchados != qntParticoes) {
                    if (Particao.getOcup(cont) != true) {
                        livres[partAchados] = cont;
                        partAchados++;
                    }
                    cont++;
                }
                int comeco = Particao.traduz(livres[0]);
                for (int i = 0; i < partAchados; i++) {
                    System.out.println("Salvando o exercício " + pcb.getId() + " na partição " + livres[i]);
                    // int comeco = Particao.traduz(k);
                    // Aloca partição
                    Particao.setOcup(livres[i]);
                    // Aloca programa no array de pcb de partições
                    Particao.setProgram(pcb, livres[i]);
                    // Seta onde começa o programa(memoria fisica)
                    pcb.setSafe(comeco);
                }
                pcb.setParts(livres);
                int contPos = 1;
                for (int j = 0; j < pcb.getArray().size(); j++) {
                    System.out.println("Posição da memória ocupada: " + comeco + "Instrução: " + pcb.getArray().get(j));
                    memoria[comeco] = (posicaoDeMemoria) pcb.getArray().get(j);
                    if ((j + 1) % 16 == 0) {
                        comeco = Particao.traduz(livres[contPos]);
                        contPos++;
                    } else {
                        comeco++;
                    }
                }
                break;

            }
            k++;

        }

        if (k == 63) {
            System.out.println("Memória lotada!");
            cheio = true;
        }

    }

    public boolean consulta() {
        return cheio;
    }
}
