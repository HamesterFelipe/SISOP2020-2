package src;

public class Particoes {

    // Alterado
    private boolean[] parts = new boolean[64];
    private pCB[] Programs = new pCB[64];

    public Particoes() {

        for (int i = 0; i < 64; i++) {
            this.parts[i] = false;
            this.Programs[i] = null;
        }

    }

    public boolean getOcup(int part) {
        return this.parts[part];
    }

    // Marca uma partição como ocupada
    public void setOcup(int part) {
        if (this.parts[part] == true) {
            this.parts[part] = false;
        } else {
            this.parts[part] = true;
        }
    }

    public pCB getProgram(int part) {
        return this.Programs[part];
    }

    // Bota um objeto programa em uma partição
    public void setProgram(pCB program, int part) {
        this.Programs[part] = program;
    }

    // Alterado
    public int traduz(int part) {
        int traducao = 0;
        if (part != 0) {
            traducao = (part * 16);
        }
        // 0-15
        // 15-31
        // 31-47
        // 47-

        // if (part == 1) {
        // return 255;
        // }
        // if (part == 2) {
        // return 512;
        // }
        // if (part == 3) {
        // return 768;
        // }
        return traducao;
    }

}