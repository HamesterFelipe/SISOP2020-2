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
        int[] aux = new int[64];
        int pos = 0;
        for(int i = 0; i < 64; i++){
            if(livres[i]==true){
                aux[pos] = i;
                pos++; 
            }
        }
        return aux;
    }

    public void setLivres(boolean[] livres) {
        for(int i = 0; i< livres.length - 1; i++) livres[i] = true;
        this.livres = livres;
    }
    
    //ocupa o frame no valor que foi enviado
    public void setOcupado(int i){
        livres[i] = false;
    }

    public boolean desalocaParticao(){
        return true;
    }

    public void desalocar(int ID){

    }

    //retorna o primeiro endereço de memoria do frame que foi enviada
    //por parametro(tem que mostrar a partir de qual frame da mesma ta disponivel)
    public int alocar(int ID) {
        int aux = -1;
        livres[ID] = false;
        for (int i = 0; i < 64; i++) {
            if (frames[i] == ID) {
                aux = i + 1;
            }
        }
        if (aux != -1) {
            return aux * 16;
        } else {
            for (int i = 0; i < 64; i++) {
                if (frames[i] == -1) {
                    frames[i] = ID;
                    return i * 16;
                }
            }
        }
        return aux;
    }

    //Desaloca frame selecionada e posições de memoria na cpu
    public void Desaloca(int frame) {
        livres[frame] = true;
        frames[frame] = -1;
    }

   
    
}