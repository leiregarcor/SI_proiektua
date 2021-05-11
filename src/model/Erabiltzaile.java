package model;

public class Erabiltzaile {

    private String izena;
    private int puntuazioa;

    public Erabiltzaile(String izena) {
        this.izena = izena;
        this.puntuazioa = 0;
    }

    public void puntuazioaKalkulatu(int pZailtasunMaila,int pDenbora, int pLaguntzaKop){
        puntuazioa = (30000*pZailtasunMaila/(pDenbora+(30*pLaguntzaKop)));
    }
}
