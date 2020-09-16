package GM;

import CPU.Cpu;

public class Gm {
    private int[] frames = new int[64];
    private Cpu cpu;
    private boolean[] livres;

    public Gm() {
        for (int i = 0; i < 64; i++) {
            frames[i] = -1;
        }
        setLivres(new boolean[64]);
    }

    //retorna um array de int com as posiçoes dos frames livres
    public int[] getLivres() {
        int[] aux = new int[64]
        int pos = 0;
        for(int i = 0; i < 64; i++){
            if(livres[i]==true){
                int[pos] = i;
                pos++; 
            }
        }
    }

    public void setLivres(boolean[] livres) {this.livres = livres;}
    
    //ocupa o frame no valor que foi enviado
    public void setOcupado(int i){
        livres[i] = false;
    }

    public boolean desalocaParticao(){
        return true;
    }

    //retorna o primeiro endereço de memoria do frame que foi enviada por parametro(tem que mostrar a partir de qual frame da mesma ta disponivel)
    public int alocar(int ID) {
        int aux = -1;

        for (int i = 0; i < 64; i++) {
            if (paginas[i] == ID) {
                aux = i + 1;
            }
        }
        if (aux != -1) {
            return aux * 16;
        } else {
            for (int i = 0; i < 64; i++) {
                if (paginas[i] == -1) {
                    paginas[i] = ID;
                    return (i + 1) * 16;
                }
            }
        }
        return aux;
    }


    //Desaloca frame selecionada
    public void Desaloca(int limiteSup) {
        for (int i = limiteSup - 15; i < limiteSup; i++) {
            cpu.desalocaMemoria(i);
        }
    }
}