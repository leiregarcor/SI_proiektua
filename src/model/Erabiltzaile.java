package model;

public class Erabiltzaile {

    private String izena;
    private int puntuazioa;
    private int laguntzaKop;
    private int lvl;

    public Erabiltzaile() {
        this.puntuazioa = 0;
        this.laguntzaKop = 0;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getIzena() {
        return izena;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public void puntuazioaKalkulatu(int pDenbora){
        puntuazioa = (30000*lvl/(pDenbora+(30*laguntzaKop)));
    }

    public void laguntzaHanditu(){
        laguntzaKop++;
    }
}
