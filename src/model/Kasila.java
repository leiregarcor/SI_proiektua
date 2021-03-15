package model;

public class Kasila {
    private int x;
    private int y;
    private int koadrante;
    private int actual;
    private int predicted;
    private String aukerak;

    public Kasila(int x, int y, int koadrante, int actual, int predicted, String aukerak) {
        this.x = x;
        this.y = y;
        this.koadrante = koadrante;
        this.actual = actual;
        this.predicted = predicted;
        this.aukerak = aukerak;
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
