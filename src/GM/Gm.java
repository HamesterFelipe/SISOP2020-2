package GM;

import CPU.Cpu;

public class Gm {
    private int[] paginas = new int[16];
    private Cpu cpu;
    private boolean[] livres;

    public Gm() {
        for (int i = 0; i < 16; i++) {
            paginas[i] = -1;
        }
        setLivres(new boolean[16]);
    }

    public boolean[] getLivres() {return livres;}
    public void setLivres(boolean[] livres) {this.livres = livres;}
    
    
    public void setOcupado(int i){
        livres[i] = false;
    }

    public boolean desalocaParticao(){
        return true;
    }

    //retorna o primeiro frame livre da paginação(fazer metodo para verificar se tem espaço)
    public int verificaLivre(){
        for (int i = 0; i < 16; i++) {
            if(livres[i]==true){
                for(int j = 0; j<64 ; j++){
                    if(cpu.memoria[((i*64)+j)]==null){
                        return (i*64)+j
                    }
                }          
            }
        }
    }

    //retorna o primeiro frame da pagina que foi enviada por parametro(tem que mostrar a partir de qual frame da mesma ta disponivel)
    public int alocar(int ID) {
        int aux = -1;

        for (int i = 0; i < 16; i++) {
            if (paginas[i] == ID) {
                aux = i + 1;
            }
        }
        if (aux != -1) {
            return aux * 64;
        } else {
            for (int i = 0; i < 16; i++) {
                if (paginas[i] == -1) {
                    paginas[i] = ID;
                    return (i + 1) * 64;
                }
            }
        }
        return aux;
    }


    //Desaloca memória da pagina selecionada
    public void Desaloca(int limiteSup) {
        for (int i = limiteSup - 63; i < limiteSup; i++) {
            cpu.desalocaMemoria(i);
        }
    }
}