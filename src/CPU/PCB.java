package CPU;

public class PCB {
    private int[] framesOcupados;
    private int ID;
    private String nomePrograma;

    public PCB(int ID, int[] framesOcupados){
        this.ID = ID;
        this.framesOcupados = framesOcupados;
        this.nomePrograma = "Programa sem nome";
    }

    public PCB(int ID, int[] framesOcupados, String nomePrograma){
        this.ID = ID;
        this.framesOcupados = framesOcupados;
        this.nomePrograma = nomePrograma;
    }

    public int[] getFrames(){
        return framesOcupados;
    }

    public int getID(){
        return ID;
    }   

    public String toString(){
        String response = new String();
        response = "Nome do programa: "+ this.nomePrograma + " ID: " + this.ID + " Frames Ocupados: ";
        for(int i=0; i < this.framesOcupados.length; i++){
            response += this.framesOcupados[i] +", ";
            
        }
        return response += '\n';
    }
}