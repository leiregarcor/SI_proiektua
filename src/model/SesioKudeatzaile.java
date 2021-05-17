package model;

import view.HasieraPanela;
import view.SudokuBista;

import java.io.IOException;

public class SesioKudeatzaile {
    private static SesioKudeatzaile sk = null;
    private int lvl;
    private long denbora;
    private Erabiltzaile unekoErabiltzaile= new Erabiltzaile();

    private SesioKudeatzaile() {
    }

    public static SesioKudeatzaile getInstance() {
        if (sk == null) {
            sk = new SesioKudeatzaile();
        }
        return sk;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setDenbora(long denbora) {
        this.denbora = denbora;
    }

    public Erabiltzaile getUnekoErabiltzaile() {
        return unekoErabiltzaile;
    }

    public void tableroaKargatu(){
        Boolean b=Sudoku.getNireSudoku().tableroKargatu(lvl);
        if(!b){
            if(lvl<3){
                lvl=lvl+1;
                this.tableroaKargatu();
            }
            else{
                System.out.println("Ez dago sudokurik");

            }
        }

    }

    public void partidaBukatu(){
        lvl++;
        if(lvl<=3){
            Erabiltzaile berria= new Erabiltzaile();
            berria.setIzena(unekoErabiltzaile.getIzena());
            unekoErabiltzaile=berria;
            SudokuBista.main(null);
        }
    }

    public int getLvl() {
        return lvl;
    }

    public void puntuazioaKalkulatu() {
        unekoErabiltzaile.setLvl(lvl);
        unekoErabiltzaile.puntuazioaKalkulatu((int) denbora);
        RankingKud.getNireRankingKud().addErabiltzaile(unekoErabiltzaile);
        RankingKud.getNireRankingKud().fitxategiaEguneratu();
    }

    public static void main(String[] args) {
        /**
         * Kaixo, ongi etorri <3
         *
         * Hasiera Panela egikaritzean erabiltzailearen izena sartu eta 1, 2 edo 3
         * balioak SudokuBista agertzeko, beste zenbakiren bat sartzerakoan errore mezua
         * agertuko da eta berriro saiatzeko eskaten zaio erabiltzaileari.
         *
         */
        TableroCatalog.getInstance().rawTableroakKargatu();
        RankingKud.getNireRankingKud().rankingKargatu();
        HasieraPanela.main(null);

    }
}
