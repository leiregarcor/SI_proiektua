package model;

import java.util.Observable;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Sudoku extends Observable{

    private Tablero tablero;
    private static Sudoku nSudoku = new Sudoku();


    private Sudoku(){
        this.fitxeroaKargatu();
    };
    public static Sudoku getNireSudoku(){
       return nSudoku;
    }

    public boolean kasillaZuzenaDa(int zutabe,int errenkada ){
        return tablero.getMatrizea()[zutabe][errenkada].zuzenaDa();
    }

    private void fitxeroaKargatu(){
        TableroCatalog.getInstance().tableroakKargatu();

    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(int lvl ) {
        this.tablero = TableroCatalog.getInstance().getTablero(lvl);        
        setChanged();
    	notifyObservers();
    }
    
    public void hautagaiakEguneratu(int pErr, int pZut, String pHautagaiak) {
    	setChanged();
    	notifyObservers();
    }
    
    public void balioakEguneratu(int pErr, int pZut, int pBalio) {
    	
    	tablero.getMatrizea()[pErr][pZut].setPredicted(pBalio);
    	setChanged();
    	notifyObservers(new int[]{pErr, pZut, pBalio});
    	//klase mezua sortu balioak aldatu ahal izateko
    	
    }

}
