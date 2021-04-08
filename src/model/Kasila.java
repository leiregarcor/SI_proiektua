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

    public boolean zuzenaDa(){
        // Kasila bateko soluzioa sartutako balioarekin konparatuko da, true balio zuzena bada, false bestela.
        return this.actual==this.predicted;
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

    public String getAukerak() {
        return aukerak;
    }

    public void setAukerak(String aukerak) {
        this.aukerak = aukerak;
    }

    public static void main(String[] args) {
        Kasila k = new Kasila(1,1);
        k.setPredicted(1);
        k.setActual(1);
        System.out.println(k.zuzenaDa());
        k.setPredicted(2);
        System.out.println(k.zuzenaDa());
    }

}
