package src;

import java.util.ArrayList;

public class pCB {

    private String id;
    private int safe; // Primeira posição da memoria fisica
    private int r0, r1, r2, r3, r4, r5, r6, r7;
    private ArrayList array; // ArrayList de instruções
    private int[] framesOcupados;

    public pCB(String id, ArrayList array) {

        this.id = id;
        this.safe = 0;
        this.r0 = 0;
        this.r1 = 0;
        this.r2 = 0;
        this.r3 = 0;
        this.r4 = 0;
        this.r5 = 0;
        this.r6 = 0;
        this.r7 = 0;
        this.array = array;

    }

    public void setParts(int[] parts) {
        this.framesOcupados = parts;
    }

    public int[] getParts() {
        return this.framesOcupados;
    }

    public String getId() {
        return this.id;
    }

    public int getr0() {
        return this.r0;
    }

    public int getr1() {
        return this.r1;
    }

    public int getr2() {
        return this.r2;
    }

    public int getr3() {
        return this.r3;
    }

    public int getr4() {
        return this.r4;
    }

    public int getr5() {
        return this.r5;
    }

    public int getr6() {
        return this.r6;
    }

    public int getr7() {
        return this.r7;
    }

    public int getSafe() {
        return this.safe;
    }

    public void setSafe(int x) {
        this.safe = x;
    }

    public void setr0(int x) {
        this.r0 = x;
    }

    public void setr1(int x) {
        this.r1 = x;
    }

    public void setr2(int x) {
        this.r2 = x;
    }

    public void setr3(int x) {
        this.r3 = x;
    }

    public void setr4(int x) {
        this.r4 = x;
    }

    public void setr5(int x) {
        this.r5 = x;
    }

    public void setr6(int x) {
        this.r6 = x;
    }

    public void setr7(int x) {
        this.r7 = x;
    }

    public ArrayList getArray() {
        return this.array;
    }

    @Override
    public String toString() {

        return getId();

    }

}