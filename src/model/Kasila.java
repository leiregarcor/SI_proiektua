package model;

public class Kasila {
    private int err;
    private int zut;
    private int koadrante;
    private int actual; //sol
    private int predicted; //erabiltzaileak sartutakoa
    private String aukerak;

    public Kasila(int err, int zut) {
        this.err = err;
        this.zut = zut;
        this.koadrante = (err/3)*(zut/3);
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public int getPredicted() {
        return predicted;
    }

    public void setPredicted(int predicted) {
        this.predicted = predicted;
    }







    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getKoadrante() {
        return koadrante;
    }

    public void setKoadrante(int koadrante) {
        this.koadrante = koadrante;
    }

    public String getAukerak() {
        return aukerak;
    }

    public void setAukerak(String aukerak) {
        this.aukerak = aukerak;
    }



}
