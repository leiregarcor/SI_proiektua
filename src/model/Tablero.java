package model;

import java.util.Observable;

public class Tablero extends Observable{

    private Sudoku sudoku;
    private static Tablero nTablero = new Tablero();


    private Tablero(){
        this.fitxeroaKargatu();
    };
    public static Tablero getNireTablero(){
       return nTablero;
    }

    public boolean kasillaZuzenaDa(int zutabe,int errenkada ){
        return sudoku.getMatrizea()[zutabe][errenkada].zuzenaDa();
    }

    private void fitxeroaKargatu(){
        SudokuCatalog.getInstance().tableroakKargatu();
    }

    public Sudoku getSudoku() {
        return sudoku;
    }

    public void setSudoku(int lvl ) {
        this.sudoku = SudokuCatalog.getInstance().getSudoku(lvl);
    }

}
