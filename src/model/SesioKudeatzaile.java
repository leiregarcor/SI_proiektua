package model;

import view.HasieraPanela;
import view.SudokuBista;

public class SesioKudeatzaile {
    private static SesioKudeatzaile sk = null;
    private int lvl;
    private String izena;

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

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void tableroaKargatu(){
        Sudoku.getNireSudoku().tableroKargatu(lvl);
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
        Loader.getInstance().tableroakKargatu();
        HasieraPanela.main(null);

    }
    public void partidaBukatu(){
        lvl++;
        SudokuBista.main(null);
    }
}
