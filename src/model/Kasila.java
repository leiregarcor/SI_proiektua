package model;

public abstract class Kasila {
    protected int err;
    protected int zut;
    protected int koadrante;
    protected int soluzio; // sol

    public Kasila(int err, int zut) {
        this.err = err;
        this.zut = zut;
        this.koadrante = (err / 3) * (zut / 3);
    }

    public int getSoluzio() {
        return soluzio;
    }

    public void setSoluzio(int soluzio) {
        this.soluzio = soluzio;
    }

    public int getZut() {
        return zut;
    }

    public void setZut(int x) {
        this.zut = x;
    }

    public int getErr() {
        return zut;
    }

    public void setErr(int y) {
        this.err = y;
    }

    public int getKoadrante() {
        return koadrante;
    }

    public void setKoadrante(int koadrante) {
        this.koadrante = koadrante;
    }

    //
    // public static void main(String[] args) {
    // Kasila k = new Kasila(1,1);
    // k.setPredicted(1);
    // k.setSoluzio(1);
    // System.out.println(k.zuzenaDa());
    // k.setPredicted(2);
    // System.out.println(k.zuzenaDa());
    // }

}
