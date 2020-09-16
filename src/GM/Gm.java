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
                    return (i + 1) * 16;
                }
            }
        }
        return aux;
    }

    //Desaloca frame selecionada e posições de memoria na cpu
    public void Desaloca(int frame) {
        boolean[frame] = true;
        for (int i = frame * 16; i < (((frame+1)*16))-1; i++) {
            cpu.desalocaMemoria(i);
        }
    }

    //encerraProcesso recebendo id do processo
    public void encerraProcesso(int id){
		for(int i = 0; i < 64; i++){
			if(cpu.processos[i].getID() == id){
                int[] aux = cpu.processos[i].getFrames(); 
				for(int j = 0; j < aux.length; j++){
                    Desaloca(aux[j]);
                }
                cpu.processos[i] = null;
			}
        }        
    }
    
}