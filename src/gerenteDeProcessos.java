package src;

import java.util.ArrayList;
import java.io.*;
import java.lang.Thread;

public class gerenteDeProcessos {

    private ArrayList listaDeProntos;

    public gerenteDeProcessos(ArrayList array) {

        listaDeProntos = array;

    }

    // public ArrayList getLista() {
    // return this.listaDeProntos;
    // }

    public void loadArquivo(String Resposta) {

        ArrayList programa = new ArrayList<>();

        if (Resposta.charAt(Resposta.length() - 1) != 't' || Resposta.charAt(Resposta.length() - 2) != 'x'
                || Resposta.charAt(Resposta.length() - 3) != 't' || Resposta.charAt(Resposta.length() - 4) != '.') {
            Resposta = Resposta + ".txt";
        }

        try {
            FileReader arq = new FileReader(Resposta);
            BufferedReader lerArq = new BufferedReader(arq);
            // System.out.println("tamanho: " + lerArq);
            String linha = lerArq.readLine();

            while (linha != null) {

                // Adiciona as instruções(opcode) a um array vinculado ao "pcb"
                String[] strArray = linha.split("[,' ']");
                // System.out.println(strArray);
                if (strArray.length == 1) {
                    posicaoDeMemoria line = new posicaoDeMemoria(strArray[0], null, null, -99);
                    programa.add(line);
                } else if (strArray.length == 2) {
                    if (strArray[1].charAt(0) == 'r') {
                        posicaoDeMemoria line = new posicaoDeMemoria(strArray[0], strArray[1], null, -99);
                        programa.add(line);
                    } else {
                        int castInt = Integer.parseInt(strArray[1]);
                        posicaoDeMemoria line = new posicaoDeMemoria(strArray[0], castInt, null);
                        programa.add(line);
                    }
                } else if (strArray.length == 3) {
                    if (strArray[1].charAt(0) == 'r' && strArray[2].charAt(0) == 'r') {
                        posicaoDeMemoria line = new posicaoDeMemoria(strArray[0], strArray[1], strArray[2], -99);
                        programa.add(line);
                    } else if (strArray[1].charAt(0) == 'r' && strArray[2].charAt(0) != 'r') {
                        int castInt = Integer.parseInt(strArray[2]);
                        posicaoDeMemoria line = new posicaoDeMemoria(strArray[0], strArray[1], castInt);
                        programa.add(line);
                    } else if (strArray[1].charAt(0) != 'r' && strArray[2].charAt(0) == 'r') {
                        int castInt = Integer.parseInt(strArray[1]);
                        posicaoDeMemoria line = new posicaoDeMemoria(strArray[0], castInt, strArray[2]);
                        programa.add(line);
                    }

                } else {
                    System.out.println("Erro na linha!");
                }

                linha = lerArq.readLine();
            }

            arq.close();

            pCB PCB = new pCB(Resposta, programa);

            listaDeProntos.add(PCB);
            System.out.println(listaDeProntos);

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

    }
}
