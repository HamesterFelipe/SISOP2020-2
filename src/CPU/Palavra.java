package CPU;

public class Palavra {
    public String OPCode = null, r1 = null, r2 = null, label = null;
    public int num = 0;

    // STOP
    public Palavra (String OPC) {
        this.OPCode = OPC;
        this.label = OPC;
    }

    //Valor
    public Palavra (int num){
        this.num = num;
        this.label = Integer.toString(num);
    }

    //MULT r1,r2
    public Palavra (String OPC, String r1, String r2) {
        this.OPCode = OPC;
        this.r1 = r1;
        this.r2 = r2;

        StringBuilder s = new StringBuilder(OPCode).append(" ").append(this.r1).append(",").append(this.r2);
        this.label = s.toString();
    }

    //LDI r2,1
    public Palavra (String OPC, String r1, int num){
        this.OPCode = OPC;
        this.r1 = r1;
        this.num = num;

        StringBuilder s = new StringBuilder(OPCode).append(" ").append(this.r1).append(",").append(this.num);
        this.label = s.toString();
    }

    //STD 1,r1
    public Palavra (String OPC, int num, String r2){
        this.OPCode = OPC;
        this.num = num;
        this.r2 = r2;

        StringBuilder s = new StringBuilder(OPCode).append(" ").append(this.num).append(this.r2);
        this.label = s.toString();
    }

    public String toString() {
        return label;
    }

}