package model;

import java.util.Observable;

public class Sudoku extends Observable{

    private Tablero tablero;
    private static Sudoku nTablero = new Sudoku();


    private Sudoku(){
        this.fitxeroaKargatu();
    };
    public static Sudoku getNireTablero(){
       return nTablero;
    }

    public boolean kasillaZuzenaDa(int zutabe,int errenkada ){
        return tablero.getMatrizea()[zutabe][errenkada].zuzenaDa();
    }

    private void fitxeroaKargatu(){
        SudokuCatalog.getInstance().tableroakKargatu();
        setChanged();
    	notifyObservers();
    }

    public Tablero getSudoku() {
        return tablero;
    }

    public void setSudoku(int lvl ) {
        this.tablero = SudokuCatalog.getInstance().getSudoku(lvl);
    }
    
    public void hautagaiakEguneratu(int pErr, int pZut, String pHautagaiak) {
    	setChanged();
    	notifyObservers();
    }
    
    public void BalioakEguneratu(int pErr, int pZut, String pBalio) {
    	setChanged();
    	notifyObservers();
    	//klase mezua sortu balioak aldatu ahal izateko
    	
    }

}
