public class PCB {
    private int[] framesOcupados;
    private int primeiraPosição, ultimaPosição;
    private int ID;
    private String nomePrograma;

    public PCB(int ID, int[] framesOcupados){
        this.ID = ID;
        this.framesOcupados = framesOcupados;
    }

    public PCB(int id, int[] framesOcupados, String nomePrograma){
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
}