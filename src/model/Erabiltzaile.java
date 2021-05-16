package model;

public class Erabiltzaile {

    private String izena;
    private int puntuazioa;
    private int laguntzaKop;
    private static Erabiltzaile nE= null;

    private Erabiltzaile() {
        this.puntuazioa = 0;
        this.laguntzaKop = 0;
    }

    public static Erabiltzaile getInstance(){
        if (nE == null){
            nE = new Erabiltzaile();
        }
        return nE;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void puntuazioaKalkulatu(int pZailtasunMaila, int pDenbora){
        puntuazioa = (30000*pZailtasunMaila/(pDenbora+(30*laguntzaKop)));
    }

    public void laguntzaHanditu(){
        laguntzaKop++;
    }
}
