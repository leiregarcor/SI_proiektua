package model;

import java.util.Observable;

public class Sudoku extends Observable {

    private Tablero tablero= new Tablero();
    private static Sudoku nSudoku = new Sudoku();

    private Sudoku() {}

    public static Sudoku getNireSudoku() {
        return nSudoku;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void tableroKargatu(int pLvl){
        tablero.tableroaKargatu(pLvl);
        setChanged();
        notifyObservers();
    }

    public void kasilaEguneratu(int pErr, int pZut, int pBalio, String pHautagaiak) {
        if(tablero.getMatrizea()[pErr][pZut] instanceof KasilaAldakorra){
            tablero.getMatrizea()[pErr][pZut].setBista(pBalio);
            ((KasilaAldakorra) tablero.getMatrizea()[pErr][pZut]).setAukerak(pHautagaiak);
            Mezua mezu= new Mezua();
            mezu.setHautagaiak(pHautagaiak);
            mezu.setInfo(new int[] { pErr, pZut, pBalio});
            setChanged();
            notifyObservers(mezu);
        }
    }

}
