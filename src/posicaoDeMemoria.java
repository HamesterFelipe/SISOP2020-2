package src;

// Autores: Pedro Portella, Rafael Resende e Lucas Tashan

// Classe do objeto de posição de memória
// Possui os atributos necessários para realizar as alterações conforme os opcodes
// Possui vários construtores para popular corretamente a memória de acordo com os opcodes dos programas

public class posicaoDeMemoria {
    public String opcode;
    public String registrador1;
    public String registrador2;
    public int parametro;

    public posicaoDeMemoria(String opcode) {
        this.opcode = opcode;
    }

    public posicaoDeMemoria(int parametro) {
        this.parametro = parametro;
    }

    public posicaoDeMemoria(String opcode, int parametro) {
        this.opcode = opcode;
        this.parametro = parametro;
    }

    public posicaoDeMemoria(String opcode, String registrador1) {
        this.opcode = opcode;
        this.registrador1 = registrador1;
    }

    public posicaoDeMemoria(String opcode, String registrador1, String registrador2) {
        this.opcode = opcode;
        this.registrador1 = registrador1;
        this.registrador2 = registrador2;
    }

    public posicaoDeMemoria(String opcode, String registrador1, int parametro) {
        this.opcode = opcode;
        this.registrador1 = registrador1;
        this.parametro = parametro;
    }

    public posicaoDeMemoria(String opcode, int parametro, String registrador1) {
        this.opcode = opcode;
        this.parametro = parametro;
        this.registrador1 = registrador1;
    }

    public posicaoDeMemoria(String opcode, String registrador1, String registrador2, int parametro) {
        this.opcode = opcode;
        this.registrador1 = registrador1;
        this.registrador2 = registrador2;
        this.parametro = parametro;
    }

    public String getOpcode() {
        return this.opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getRegistrador1() {
        return this.registrador1;
    }

    public void setRegistrador1(String registrador1) {
        this.registrador1 = registrador1;
    }

    public String getRegistrador2() {
        return this.registrador2;
    }

    public void setRegistrador2(String registrador2) {
        this.registrador2 = registrador2;
    }

    public int getParametro() {
        return this.parametro;
    }

    public void setParametro(int parametro) {
        this.parametro = parametro;
    }

    @Override
    public String toString() {
        return "{" + " opcode='" + getOpcode() + "'" + ", registrador1='" + getRegistrador1() + "'" + ", registrador2='"
                + getRegistrador2() + "'" + ", parametro='" + getParametro() + "'" + "}";
    }

}
